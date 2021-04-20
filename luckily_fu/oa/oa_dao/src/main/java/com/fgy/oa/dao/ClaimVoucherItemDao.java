package com.fgy.oa.dao;

import com.fgy.oa.domain.ClaimVoucherItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 报销单条目持久层接口
 */
@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {

    /**
     * 插入报销单条目
     * @param claimVoucherItem
     */
    @Insert("insert into claim_voucher_item(claim_voucher_id,item,amount,comment)" +
            "values(#{claim_voucher_id},#{item},#{amount},#{comment})")
    void insert(ClaimVoucherItem claimVoucherItem);

    /**
     * 更新报销单条目
     * @param claimVoucherItem
     */
    @Update("update  claim_voucher_item set claim_voucher_id=#{claim_voucher_id},item=#{item},amount=#{amount},comment=#{comment} where id=#{id}")
    void update(ClaimVoucherItem claimVoucherItem);

    /**
     * 删除报销单条目
     * @param id
     */
    @Delete("delete from claim_voucher_item where id=#{id}")
    void delete(int id);

    /**
     * 根据报销单编号查询报销单条目
     * @param cvid
     * @return
     */
    @Select("select * from claim_voucher_item where claim_voucher_id=#{cvid} order by id")
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
