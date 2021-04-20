package com.fgy.oa.service;

import com.fgy.oa.domain.ClaimVoucher;
import com.fgy.oa.domain.ClaimVoucherItem;
import com.fgy.oa.domain.DealRecord;

import java.util.List;

/**
 * 报销单业务层接口
 */
public interface ClaimVoucherService {

    /**
     * 保存报销单
     * @param claimVoucher
     * @param items
     */
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    /**
     * 根据报销单id获取报销单信息
     * @param id
     * @return
     */
    ClaimVoucher get(int id);

    /**
     * 根据报销单编号获取报销单条目信息
     * @param cvid
     * @return
     */
    List<ClaimVoucherItem> getItems(int cvid);

    /**
     * 根据报销单编号获取处理记录
     * @param cvid
     * @return
     */
    List<DealRecord> getRecords(int cvid);

    /**
     * 获取个人报销单
     * @param sn
     * @return
     */
    List<ClaimVoucher> getForSelf(String sn);

    /**
     * 获取待处理报销单
     * @param sn
     * @return
     */
    List<ClaimVoucher> getForDeal(String sn);

    /**
     * 更新报销单
     * @param claimVoucher
     * @param items
     */
    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    /**
     * 提交报销单
     * @param id
     */
    void submit(int id);

    /**
     * 处理报销单（审核，打款）
     * @param dealRecord
     */
    void deal(DealRecord dealRecord);
}
