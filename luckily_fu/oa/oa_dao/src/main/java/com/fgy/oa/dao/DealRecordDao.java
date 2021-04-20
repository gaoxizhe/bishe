package com.fgy.oa.dao;

import com.fgy.oa.domain.DealRecord;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理记录持久层接口
 */
@Repository("dealRecordDao")
public interface DealRecordDao {

    /**
     * 插入处理记录
     * @param dealRecord
     */
    @Insert("insert into deal_record(claim_voucher_id,deal_sn,deal_time,deal_way,deal_result,comment)" +
            "        values(#{claim_voucher_id},#{deal_sn},#{deal_time},#{deal_way},#{deal_result},#{comment})")
    void insert(DealRecord dealRecord);

    /**
     * 根据报销单编号查询处理记录
     * @param cvid
     * @return
     */
    List<DealRecord> selectByClaimVoucher(int cvid);
}
