package com.fgy.oa.domain;

import java.util.Date;

/**
 * 报销单
 */
public class ClaimVoucher {
    private Integer id;

    private String cause;

    private String create_sn;

    private Date create_time;

    private String next_deal_sn;

    private Double total_amount;

    private String status;

    // 创建者
    private Employee creater;

    // 处理人
    private Employee dealer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCreate_sn() {
        return create_sn;
    }

    public void setCreate_sn(String create_sn) {
        this.create_sn = create_sn;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getNext_deal_sn() {
        return next_deal_sn;
    }

    public void setNext_deal_sn(String next_deal_sn) {
        this.next_deal_sn = next_deal_sn;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getCreater() {
        return creater;
    }

    public void setCreater(Employee creater) {
        this.creater = creater;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "ClaimVoucher{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", create_sn='" + create_sn + '\'' +
                ", create_time=" + create_time +
                ", next_deal_sn='" + next_deal_sn + '\'' +
                ", total_amount=" + total_amount +
                ", status='" + status + '\'' +
                ", creater=" + creater +
                ", dealer=" + dealer +
                '}';
    }
}