<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fgy.oa.global.Constant" %>

<%@ include file="top.jsp"%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 待处理报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <a href="${pageContext.request.contextPath}/claim_voucher/deal" type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh"></i>
                                </a>
                                <a href="#" type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/claim_voucher/to_add" type="button" class="btn btn-default light">
                                    <i class="fa fa-plus"></i>
                                </a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">事由</th>
                            <th>状态</th>
                            <th class="hidden-xs">创建人</th>
                            <th class="hidden-xs">金额</th>
                            <th class="hidden-xs">创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="cv">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="mobileos" value="FR">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td>${cv.cause}</td>
                            <td class="hidden-xs">
                                <span class="badge badge-warning mr10 fs11">${cv.status}</span>
                            </td>
                            <td>${cv.creater.name}</td>
                            <td class="fw600">${cv.total_amount}</td>
                            <td><fmt:formatDate value="${cv.create_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                            <td>
                                <c:if test="${cv.status==Constant.CLAIMVOUCHER_CREATED || cv.status==Contant.CLAIMVOUCHER_BACK}">
                                    <a href="${pageContext.request.contextPath}/claim_voucher/to_update/${cv.id}">修改</a>
                                    <a href="${pageContext.request.contextPath}/claim_voucher/submit/${cv.id}">提交</a>
                                </c:if>
                                <c:if test="${cv.status==Constant.CLAIMVOUCHER_SUBMIT || cv.status==Constant.CLAIMVOUCHER_RECHECK}">
                                    <a href="${pageContext.request.contextPath}/claim_voucher/to_check/${cv.id}">审核</a>
                                </c:if>
                                <c:if test="${cv.status==Constant.CLAIMVOUCHER_APPROVED}">
                                    <a href="${pageContext.request.contextPath}/claim_voucher/to_check/${cv.id}">打款</a>
                                </c:if>
                                <a href="${pageContext.request.contextPath}/claim_voucher/detail/${cv.id}">详细信息</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="bottom.jsp"%>
