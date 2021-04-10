<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html" %>
<%
    String pageurl = request.getRequestURL().toString();
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html class="no-js top-block style-body dark orange-yellow pretty mdf simple-breaker">
<head>
    <script type="text/javascript">with (document.documentElement) {
        className = className.replace(/\bno-js\b/, 'js');
    }</script>
    <meta charset="utf-8"/>
    <title>“山西应用科技学院”绩效考核系统</title>

    <!-- Meta data -->
    <meta name="description" content=""/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="css/ie7.css"/>
    <![endif]-->
    <!--[if IE]>
    <link rel="stylesheet" type="text/css" href="css/ie.css"/>
    <![endif]-->

    <!-- Skin -->
    <style type="text/css">
        body {
            background-image: url(img/bj.png) ;
            background-color: #f5f5f5;
            background-size: 100% 100%;
            background-repeat:no-repeat;
        }

        .form-signin {
            width: 200px;
            padding: 19px 10px 29px;
            margin: 0 0 0px 80px;

            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

        .bg-translucent {
            background: rgba(255, 255, 255, 0.5); /*前三个参数为rgb颜色，第四个参数为透明度*/
            filter: progid:DXImageTransform.Microsoft.gradient(startcolorstr=#7F000000, endcolorstr=#7F000000); /*#7F000000的前两位为16进制透明度，后六位为16进制颜色*/
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="ico/favicon.png">

</head>
<!-- MAIN BODY -->
<body>

<div class="container">
    <div class="row">
        <div class="span12" style="">
            <br><br><br>
            <div class="row">

                <div class="span4 offset8">
                    <form method="post" class="form-signin bg-translucent" action="LoginServlet">
                        <h3 class="form-signin-heading"><img alt="战梦" height="30" width="30" src="img/2.png"> 绩效考核系统
                        </h3>
                        <input type="text" name="username" class="input-block-level" placeholder="Username">
                        <input type="password" name="password" class="input-block-level" placeholder="Password">
                        <label class="med-dark-link follow"
                               style="font-family:Bitter;font-size: 20px;margin-bottom: 10px">
                            <img class="img-rounded" src="AuthImage" title="点击更换" name="safecode" id="safecode"
                                 border="0"/></label>
                        <input type="text" name="auth_code" class="input-block-level" placeholder="SafeCode">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="remember-me">记住我
                        </label>

                        <label class="radio">
                            <input type="radio" name="roles" id="optionsRadios1" value="roles1" checked>
                            学生
                        </label>
                        <label class="radio">
                            <input type="radio" name="roles" id="optionsRadios2" value="roles2">
                            教师
                        </label>
                        <label class="radio">
                            <input type="radio" name="roles" id="optionsRadios3" value="roles3">
                            管理员
                        </label>

                        <button class="btn btn-primary text-right" type="submit"> 登 录</button>


                        <%
                            if (request.getAttribute("err") != null) {
                        %>
                        <div class="text-center alert alert-error fade in">
                            <button type="button" class="close in fade" data-dismiss="alert">&times;</button>
                            <b><%out.print(request.getAttribute("err").toString());%></b>
                        </div>
                        <% } %>
<%--                        <img src="img/url.png">--%>
<%--                        <div class="text-center alert alert-success fade in">--%>
<%--                            <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#"--%>
<%--                                                                                                              class="bds_qzone"--%>
<%--                                                                                                              data-cmd="qzone"></a><a--%>
<%--                                    href="#" class="bds_tsina" data-cmd="tsina"></a><a href="#" class="bds_tqq"--%>
<%--                                                                                       data-cmd="tqq"></a><a href="#"--%>
<%--                                                                                                             class="bds_renren"--%>
<%--                                                                                                             data-cmd="renren"></a><a--%>
<%--                                    href="#" class="bds_weixin" data-cmd="weixin"></a></div>--%>
<%--                            <script>window._bd_share_config = {--%>
<%--                                "common": {--%>
<%--                                    "bdSnsKey": {},--%>
<%--                                    "bdText": "",--%>
<%--                                    "bdMini": "2",--%>
<%--                                    "bdPic": "",--%>
<%--                                    "bdStyle": "0",--%>
<%--                                    "bdSize": "16"--%>
<%--                                },--%>
<%--                                "share": {},--%>
<%--                                "image": {--%>
<%--                                    "viewList": ["qzone", "tsina", "tqq", "renren", "weixin"],--%>
<%--                                    "viewText": "分享到：",--%>
<%--                                    "viewSize": "16"--%>
<%--                                },--%>
<%--                                "selectShare": {--%>
<%--                                    "bdContainerClass": null,--%>
<%--                                    "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"]--%>
<%--                                }--%>
<%--                            };--%>
<%--                            with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>--%>
<%--                        </div>--%>

                    </form>

                    <br><br><br><br><br><br><br><br><br><br>
                </div>
            </div>
        </div>
    </div>

</div> <!-- /container -->
<!-- jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/google-code-prettify/prettify.js"></script>
<script src="js/application.js"></script>
<script type="text/javascript">

    !function ($) {
        $(function () {
            $('#safecode').click(function () {
                $('#safecode').eq(0).attr('src', "AuthImage?id=" + Math.random());

            })
        })
    }(window.jQuery)
</script>
</body>
</html>
