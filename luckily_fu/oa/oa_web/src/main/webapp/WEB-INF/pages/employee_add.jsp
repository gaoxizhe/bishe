<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="top.jsp" %>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加员工 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form action="${pageContext.request.contextPath}/employee/save"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="sn" class="field prepend-icon">
                                    <input id="sn" name="sn" class="gui-input" placeholder="工号..." />
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <input id="name" name="name" class="gui-input" placeholder="姓名..."/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="departmentSn" class="field select">
                                    <select id="departmentSn" name="department_sn" class="gui-input" placeholder="所属部门...">
                                        <option value="">--请选择--</option>
                                        <c:forEach items="${departments}" var="dept">
                                            <option value="${dept.sn}">${dept.name}</option>
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
                                            <option value="${post}">${post}</option>
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

<%@ include file="bottom.jsp"%>