<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="top.jsp"%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑员工信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form action="${pageContext.request.contextPath}/employee/update" id="admin-form" name="addForm">
                    <input type="hidden" name="password" value="${employee.password}"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="sn" class="field prepend-icon">
                                    <input id="sn" name="sn" class="gui-input" value="${employee.sn}" placeholder="工号..." readonly="true" />
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <input id="name" name="name" class="gui-input" value="${employee.name}" placeholder="姓名..."/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="sn" class="field select">
                                    <select id="departmentSn" name="department_sn" class="gui-input" placeholder="所属部门...">
                                        <c:forEach items="${departments}" var="dept">
                                            <option value="${dept.sn}" ${dept.sn == employee.department_sn ? "selected" : ""}>${dept.name}</option>
                                        </c:forEach>
                                    </select>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="post" class="field select">
                                    <select id="post" name="post" class="gui-input" placeholder="职务...">
                                        <option value="">--请选择--</option>
                                        <c:forEach items="${posts}" var="post">
                                            <option value="${post}" ${post == employee.post ? "selected" : ""}>${post}</option>
                                        </c:forEach>
                                    </select>
                                    <i class="arrow double"></i>
                                </label>
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

<%@ include file="bottom.jsp" %>