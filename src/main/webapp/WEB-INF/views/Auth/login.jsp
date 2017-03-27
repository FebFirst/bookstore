<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 24/03/2017
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>BookStore</title>
    <link href="/bookstore/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/bookstore/static/css/style.css">
    <script type="text/javascript" src="/bookstore/static/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="/bookstore/static/js/xg-learning.js"></script>
    <style>
        .form-bg{
            background: #00b4ef;
        }
        .form-horizontal{
            margin-top: 20%;
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body class="form-bg">
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <!--<button onclick="test()" class="btn btn-default">登录</button>-->
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="邮箱"/>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="code" name="code" placeholder="密　码"/>
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住密码</span>
                    <input onclick="submitUser()" class="btn btn-default" value="登录" readonly="readonly"/>
                </div>
                <center><p id="msg"></p></center>
            </form>
        </div>
    </div>
</div>
<footer id="fh5co-footer">
    <p><small>&copy; 2017. Read Your Heart. All Rights Reserved. <br> About Me <a href="http://115.159.118.37/" target="_blank" title="Leo Xiong">Leo Xiong</a></small></p>
</footer>
<script type="text/javascript">
    function submitUser() {
        var name = document.getElementById("name").value;
        var code = document.getElementById("code").value;
        var user = {email:name, code:code};
        var url = "auth/login";
        $.ajax({
            "type": "POST",
            "url": url,
            "contentType": "application/json",
            "data": JSON.stringify(user),
            "dataType": "json",
            "success":function (info) {
                alert(JSON.stringify(info));
                window.location.href = "home";
            }
        });
    }
</script>

</body>
</html>
