package com.fgy.oa.test;

import com.fgy.oa.dao.ClaimVoucherDao;
import com.fgy.oa.domain.ClaimVoucher;
import com.fgy.oa.global.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class ClaimVoucherDaoTest {

    @Autowired
    private ClaimVoucherDao claimVoucherDao;

    @Test
    public void testInsert() {
        ClaimVoucher claimVoucher = new ClaimVoucher();
        claimVoucher.setCreate_time(new Date());
        claimVoucher.setCause(Constant.CLAIMVOUCHER_CREATED);
        claimVoucher.setCreate_sn("10001");
        claimVoucher.setNext_deal_sn("10003");
        claimVoucher.setTotal_amount(6000.0);
        claimVoucher.setStatus(Constant.DEAL_CREATE);
        claimVoucherDao.insert(claimVoucher);

        System.out.println(claimVoucher);
    }

    @Test
    public void testDelete() {
        claimVoucherDao.delete(2);
    }

    @Test
    public void testSelect() {
        ClaimVoucher claimVoucher = claimVoucherDao.select(3);
        System.out.println(claimVoucher);
    }

    @Test
    public void testUpdate() {
        ClaimVoucher claimVoucher = claimVoucherDao.select(3);
        claimVoucher.setTotal_amount(6099.9);
        claimVoucherDao.update(claimVoucher);
    }

    @Test
    public void testSelectByCreateSn() {
        List<ClaimVoucher> claimVouchers = claimVoucherDao.selectByCreateSn("10001");
        for (ClaimVoucher claimVoucher : claimVouchers) {
            System.out.println(claimVoucher);
        }
    }

    @Test
    public void testSelectByNextDealSn() {
        List<ClaimVoucher> claimVouchers = claimVoucherDao.selectByNextDealSn("10003");
        for (ClaimVoucher claimVoucher : claimVouchers) {
            System.out.println(claimVoucher);
        }
    }
}
