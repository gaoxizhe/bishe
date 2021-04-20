package com.fgy.oa.service.impl;

import com.fgy.oa.dao.ClaimVoucherDao;
import com.fgy.oa.dao.ClaimVoucherItemDao;
import com.fgy.oa.dao.DealRecordDao;
import com.fgy.oa.dao.EmployeeDao;
import com.fgy.oa.domain.ClaimVoucher;
import com.fgy.oa.domain.ClaimVoucherItem;
import com.fgy.oa.domain.DealRecord;
import com.fgy.oa.domain.Employee;
import com.fgy.oa.global.Constant;
import com.fgy.oa.service.ClaimVoucherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("claimVoucherService")
public class ClaimVoucherServiceImpl implements ClaimVoucherService {
    @Resource(name = "claimVoucherDao")
    private ClaimVoucherDao claimVoucherDao;
    @Resource(name = "claimVoucherItemDao")
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Resource(name = "dealRecordDao")
    private DealRecordDao dealRecordDao;
    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;

    /**
     * 保存报销单
     * @param claimVoucher
     * @param items
     */
    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreate_time(new Date());
        claimVoucher.setNext_deal_sn(claimVoucher.getCreate_sn());
        claimVoucher.setStatus(Constant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.insert(claimVoucher);

        for(ClaimVoucherItem item:items){
            item.setClaim_voucher_id(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    /**
     * 根据报销单id获取报销单信息
     * @param id
     * @return
     */
    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    /**
     * 根据报销单编号获取报销单条目信息
     * @param cvid
     * @return
     */
    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    /**
     * 根据报销单编号获取处理记录
     * @param cvid
     * @return
     */
    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    /**
     * 获取个人报销单
     * @param sn
     * @return
     */
    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

    /**
     * 获取待处理报销单
     * @param sn
     * @return
     */
    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }

    /**
     * 更新报销单
     * @param claimVoucher
     * @param items
     */
    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setNext_deal_sn(claimVoucher.getCreate_sn());
        claimVoucher.setStatus(Constant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.update(claimVoucher);

        List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
        for(ClaimVoucherItem old:olds){
            boolean isHave=false;
            for(ClaimVoucherItem item:items){
                if(item.getId()==old.getId()){
                    isHave=true;
                    break;
                }
            }
            if(!isHave){
                claimVoucherItemDao.delete(old.getId());
            }
        }
        for(ClaimVoucherItem item:items){
            item.setClaim_voucher_id(claimVoucher.getId());
            if(item.getId()!= null && item.getId()>0){
                claimVoucherItemDao.update(item);
            }else{
                claimVoucherItemDao.insert(item);
            }
        }
    }

    /**
     * 提交报销单
     * @param id
     */
    public void submit(int id) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(id);
        Employee employee = employeeDao.select(claimVoucher.getCreate_sn());

        claimVoucher.setStatus(Constant.CLAIMVOUCHER_SUBMIT);
        claimVoucher.setNext_deal_sn(employeeDao.selectByDepartmentAndPost(employee.getDepartment_sn(),Constant.POST_FM).get(0).getSn());
        claimVoucherDao.update(claimVoucher);

        DealRecord dealRecord = new DealRecord();
        dealRecord.setDeal_way(Constant.DEAL_SUBMIT);
        dealRecord.setDeal_sn(employee.getSn());
        dealRecord.setClaim_voucher_id(id);
        dealRecord.setDeal_result(Constant.CLAIMVOUCHER_SUBMIT);
        dealRecord.setDeal_time(new Date());
        dealRecord.setComment("无");
        dealRecordDao.insert(dealRecord);
    }

    /**
     * 处理报销单（审核，打款）
     * @param dealRecord
     */
    public void deal(DealRecord dealRecord) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(dealRecord.getClaim_voucher_id());
        Employee employee = employeeDao.select(dealRecord.getDeal_sn());
        dealRecord.setDeal_time(new Date());

        //通过
        if(dealRecord.getDeal_way().equals(Constant.DEAL_PASS)){
            //如果报销单子 < 5000 或者 这个人是部门总经理
            if(claimVoucher.getTotal_amount()<=Constant.LIMIT_CHECK || employee.getPost().equals(Constant.POST_GM)){
                //已审核
                claimVoucher.setStatus(Constant.CLAIMVOUCHER_APPROVED);
                claimVoucher.setNext_deal_sn(employeeDao.selectByDepartmentAndPost(employee.getDepartment_sn(),Constant.POST_CASHIER).get(0).getSn());

                dealRecord.setDeal_result(Constant.CLAIMVOUCHER_APPROVED);
            }else{
                claimVoucher.setStatus(Constant.CLAIMVOUCHER_RECHECK);
                claimVoucher.setNext_deal_sn(employeeDao.selectByDepartmentAndPost(employee.getDepartment_sn(),Constant.POST_GM).get(0).getSn());

                dealRecord.setDeal_result(Constant.CLAIMVOUCHER_RECHECK);
            }
        }else if(dealRecord.getDeal_way().equals(Constant.DEAL_BACK)){
            claimVoucher.setStatus(Constant.CLAIMVOUCHER_BACK);
            claimVoucher.setNext_deal_sn(claimVoucher.getCreate_sn());

            dealRecord.setDeal_result(Constant.CLAIMVOUCHER_BACK);
        }else if(dealRecord.getDeal_way().equals(Constant.DEAL_REJECT)){
            claimVoucher.setStatus(Constant.CLAIMVOUCHER_TERMINATED);
            claimVoucher.setNext_deal_sn(null);

            dealRecord.setDeal_result(Constant.CLAIMVOUCHER_TERMINATED);
        }else if(dealRecord.getDeal_way().equals(Constant.DEAL_PAID)){
            claimVoucher.setStatus(Constant.CLAIMVOUCHER_PAID);
            claimVoucher.setNext_deal_sn(null);

            dealRecord.setDeal_result(Constant.CLAIMVOUCHER_PAID);
        }

        claimVoucherDao.update(claimVoucher);
        dealRecordDao.insert(dealRecord);
    }
}
