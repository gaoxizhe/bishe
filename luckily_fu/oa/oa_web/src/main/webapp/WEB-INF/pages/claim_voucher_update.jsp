<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="top.jsp"%>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="${pageContext.request.contextPath}/claim_voucher/update">
                    <input type="hidden" name="claimVoucher.id" value="${info.claimVoucher.id}"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section">
                            <label for="cause" class="field prepend-icon">
                                <input id="cause" value="${info.claimVoucher.cause}" name="claimVoucher.cause" class="gui-input" placeholder="事由..."/>
                                <label for="cause" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> 费用明细 </span>
                        </div>
                        <div class="section row" id="items">
                            <c:forEach items="${info.items}" var="item" varStatus="sta">
                            <div>
                                <div class="col-md-3">
                                    <label class="field prepend-icon">
                                        <input type="hidden" name="items[${sta.index}].id" value="${item.id}"/>
                                        <input type="hidden" name="items[${sta.index}].claim_voucher_id" value="${item.claim_voucher_id}"/>
                                        <select name="items[${sta.index}].item" class="gui-input" placeholder="花销类型...">
                                            <c:forEach items="${items}" var="cvitem">
                                                <option value="${cvitem}" ${cvitem == item.item ? "selected" : ""}>${cvitem}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label for="amount" class="field prepend-icon">
                                        <input id="amount" value="${item.amount}" name="items[${sta.index}].amount" class="gui-input money" placeholder="金额..."/>
                                        <label for="amount" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-5">
                                    <label for="comment" class="field prepend-icon">
                                        <input id="comment" value="${item.comment}" name="items[${sta.index}].comment" class="gui-input" placeholder="备注..." />
                                        <label for="comment" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button"> X </button>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                        <div class="section row">
                            <div class="col-md-3">
                                <label for="totalMoney" class="field prepend-icon">
                                    <input id="totalMoney" value="0.00" name="claimVoucher.total_amount" class="gui-input" placeholder="总金额..." readonly="true"/>
                                    <label for="totalMoney" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="text-align:right;">
                                <div class="col-md-9">
                                    <button type="button" class="button" id="addItemButton"> + </button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<%@ include file="bottom.jsp"%>