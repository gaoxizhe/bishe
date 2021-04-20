package com.fgy.oa.domain;

import java.util.Date;

/**
 * 处理记录
 */
public class DealRecord {
    private Integer id;

    private Integer claim_voucher_id;

    private String deal_sn;

    private Date deal_time;

    private String deal_way;

    private String deal_result;

    private String comment;

    // 处理人
    private Employee dealer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClaim_voucher_id() {
        return claim_voucher_id;
    }

    public void setClaim_voucher_id(Integer claim_voucher_id) {
        this.claim_voucher_id = claim_voucher_id;
    }

    public String getDeal_sn() {
        return deal_sn;
    }

    public void setDeal_sn(String deal_sn) {
        this.deal_sn = deal_sn;
    }

    public Date getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(Date deal_time) {
        this.deal_time = deal_time;
    }

    public String getDeal_way() {
        return deal_way;
    }

    public void setDeal_way(String deal_way) {
        this.deal_way = deal_way;
    }

    public String getDeal_result() {
        return deal_result;
    }

    public void setDeal_result(String deal_result) {
        this.deal_result = deal_result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "DealRecord{" +
                "id=" + id +
                ", claim_voucher_id=" + claim_voucher_id +
                ", deal_sn='" + deal_sn + '\'' +
                ", deal_time=" + deal_time +
                ", deal_way='" + deal_way + '\'' +
                ", deal_result='" + deal_result + '\'' +
                ", comment='" + comment + '\'' +
                ", dealer=" + dealer +
                '}';
    }
}