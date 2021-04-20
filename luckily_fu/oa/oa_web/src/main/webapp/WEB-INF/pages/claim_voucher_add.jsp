<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="top.jsp"%>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 填写报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="${pageContext.request.contextPath}/claim_voucher/add">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section">
                            <label for="claimVoucher" class="field prepend-icon">
                                <input id="claimVoucher" name="claimVoucher.cause" class="gui-input" placeholder="事由..."/>
                                <label for="claimVoucher" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> 费用明细 </span>
                        </div>
                        <div class="section row" id="items">
                            <div>
                                <div class="col-md-3">
                                    <label for="claimVoucherItem" class="field prepend-icon">
                                        <select id="claimVoucherItem" name="items[0].item" class="gui-input" placeholder="花销类型...">
                                            <option value="">--请选择--</option>
                                            <c:forEach items="${items}" var="item">
                                                <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label for="amount" class="field prepend-icon">
                                        <input id="amount" name="items[0].amount" class="gui-input money" placeholder="金额..."/>
                                        <label for="amount" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-5">
                                    <label for="comment" class="field prepend-icon">
                                        <input id="comment" name="items[0].comment" class="gui-input" placeholder="备注..." />
                                        <label for="comment" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button"> X </button>
                                </div>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-3">
                                <label for="totalMoney" class="field prepend-icon">
                                    <input id="totalMoney" name="claimVoucher.total_amount" value="0.00" class="gui-input" placeholder="总金额..." readonly="true"/>
                                    <label for="totalMoney" class="field-icon">
                                        <i class="fa fa-glass"></i>
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