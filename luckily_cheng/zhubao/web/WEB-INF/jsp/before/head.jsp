<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <link href="css/before/daohang.css" rel="stylesheet" type="text/css"/>
    <link href="css/before/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/before/style.css" rel="stylesheet" type="text/css"/>

    <!-- 引入样式 -->
    <link rel="stylesheet" href="css/element-ui.css">
    <script type="text/javascript">
        function clearValue() {
            document.myForm.mykey.value = "";
        }
    </script>
</head>
<body>
<div class="all_zong" id="app-head">
    <!--最上面 灰色条部分-->
    <div class="all_zong_top">
        <div class="all_zong_top_right a8c">
            <table border="0" cellspacing="0" cellpadding="0" class="main_login">
                <tr>
                    <td>
                        <p id="content">
                            <c:if test="${bruser!=null}">欢迎 ${bruser.bemail }</c:if>
                            <c:if test="${bruser==null}"><a href="toLogin">登录</a></c:if>
                        </p>
                    </td>
                    <td>
                        <p>
                            <a href="toRegister">注册</a>
                        </p>
                    </td>
                    <td><span class="xx">|</span><a href="userCenter">用户中心</a><span
                            class="xx">|</span></td>
                    <!-- 没有登录 -->
                    <c:if test="${bruser!= null}">
                        <td><a href="user/exit">退出</a><span
                                class="xx">|</span></td>
                    </c:if>
                </tr>
            </table>
        </div>
    </div>
    <!--end-->
    <!--logo 搜索-->
    <div class="all_zong_logo">
        <div class="all_zong_logo2" style="height: 50px">
            <img src="images/before/logo.png" height="100%"/>
        </div>
        <div class="back_search">
            <div class="back_search_red" style="height: 50px;float:  right">
                <el-form :inline="true" class="demo-form-inline"   action="search" method="post" >
                    <el-form-item  label-width="120px">
                        <el-input v-model="input" placeholder="请输入您要查询的内容"
                                  prefix-icon="el-icon-search" style="width:400px" name="mykey"
                        ></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-input type="submit"   style="width: 60px;color: #409EFF" value="查询">查询</el-input>
                    </el-form-item>
                </el-form>
<%--                <form action="search" name="myForm" method="post">--%>
<%--                    &lt;%&ndash;                    <div class="div2">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="text" name="mykey" class="txt" value="请输入您要查询的内容" onfocus="clearValue()"/>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <div class="div1">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="submit" class="an" value="搜索"/>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    <span>--%>
<%--                          <el-input--%>
<%--                                  placeholder="请输入搜索内容"--%>
<%--                                  v-model="input"--%>
<%--                                  prefix-icon="el-icon-search"--%>
<%--                                  @focus="clearValue">--%>
<%--                        </el-input>--%>
<%--                    </span>--%>
<%--                    <span>--%>
<%--                             <el-input slot="append" type="submit" value="搜索"></el-input>--%>
<%--                        </span>--%>


<%--                </form>--%>
            </div>
        </div>
        <!--end-->
    </div>
    <!--红色 导航-->
    <div class="skin_a">
        <div class="front_daohangbj">
            <div class="all_zong">
                <div class="front_daohang">
                    <ul>
                        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
                                 @select="handleSelect" active-text-color="#409EFF">
                            <a href="before?id=0&activeIndex=1">
                                <el-menu-item index="1">首页</el-menu-item>
                            </a>
                            <c:forEach items="${goodsType}" var="g" varStatus="idxStatus">
                                <a href="before?id=${g.id}&activeIndex=${idxStatus.index + 2}">
                                    <el-menu-item index="${idxStatus.index + 2}">
                                            ${g.typename}
                                    </el-menu-item>
                                </a>
                            </c:forEach>


                            <p class="car">
                                <a href="cart/selectCart">
                                    <el-menu-item index="0" style="float: right">购物车</el-menu-item>
                                </a>
                            </p>


                        </el-menu>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--红色 导航 end-->
</div>
</body>

<style>
    .el-input {
        width: 130px;
    }
</style>


<!-- 先引入 Vue -->
<!-- 引入组件库 -->
<script src="css/vue.js"></script>
<script src="css/element-ui.js"></script>
<script src="css/vue-resource.js"></script>
<script>
    new Vue({
        el: '#app-head',
        data: function () {
            return {
                visible: false,
                activeIndex: this.getUrlKey('activeIndex'),
                input: ''
            }
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            getUrlKey(name) {
                let newVar = decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null;
                return newVar == null || newVar == '' ? '1' : newVar;
            },
            clearValue() {
                this.input = "";
            },
            onSubmit() {
                this.$http.post('search?mykey=' + this.input)
                    .then((success) => {
                        console.log(success);
                        // this.$notify({
                        //     title: success.body.ntitle,
                        //     dangerouslyUseHTMLString: true,
                        //     message: h('i', {style: 'color: teal'}, success.body.ncontent + success.body.ntime)
                        // });
                    }, (error) => {
                        console.log(error);
                    })
            }

        }
    })
</script>
</html>
