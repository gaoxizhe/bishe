package com.fgy.oa.dao;

import com.fgy.oa.domain.ClaimVoucher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 报销单持久层接口
 */
@Repository("claimVoucherDao")
public interface ClaimVoucherDao {

    /**
     * 插入报销单
     * @param claimVoucher
     */
    @Insert("insert into claim_voucher(cause,create_sn,create_time,next_deal_sn,total_amount,status)" +
            "values(#{cause},#{create_sn},#{create_time},#{next_deal_sn},#{total_amount},#{status})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false,
            statement = "select last_insert_id()")
    void insert(ClaimVoucher claimVoucher);

    /**
     * 更新报销单
     * @param claimVoucher
     */
    @Update("update claim_voucher set cause=#{cause},next_deal_sn=#{next_deal_sn},total_amount=#{total_amount},status=#{status} where id=#{id}")
    void update(ClaimVoucher claimVoucher);

    /**
     * 删除报销单
     * @param id
     */
    @Delete("delete from claim_voucher where id=#{id}")
    void delete(int id);

    /**
     * 根据id查询报销单
     * @param id
     * @return
     */
    ClaimVoucher select(int id);

    /**
     * 根据创建人编号查询报销单
     * @param csn
     * @return
     */
    List<ClaimVoucher> selectByCreateSn(String csn);

    /**
     * 根据待处理人编号查询报销单
     * @param ndsn
     * @return
     */
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
