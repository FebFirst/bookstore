<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 23/03/2017
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Read Your Heart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="book store" />
    <meta name="keywords" content="casualxg, casuature, bookstore" />




    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="/bookstore/static/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="/bookstore/static/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="/bookstore/static/css/bootstrap.css">

    <link rel="stylesheet" href="/bookstore/static/css/style.css">

    <link href="/bookstore/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Modernizr JS -->
    <script src="/bookstore/static/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="/bookstore/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Close</span></span></a>
    <div class="fh5co-bio">
        <figure>
            <img src="/bookstore/static/images/person1.jpg" alt="read your heart" class="img-responsive">
        </figure>
        <h3 class="heading">Profile</h3>
        <h2>Casuature</h2>
        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
        <ul class="fh5co-social">
            <li><a href="http://115.159.118.37"><i class="icon-email">About Me</i></a></li>
        </ul>
    </div>

    <div class="fh5co-menu">
        <div class="fh5co-box">
            <h3 class="heading">Shopping Cart</h3>
            <ul id="shopping-cart">
                <li><a href="#">Travel</a></li>
                <li><a href="#">Style</a></li>
                <li><a href="#">Photography</a></li>
                <li><a href="#">Food &amp; Drinks</a></li>
                <li><a href="#">Culture</a></li>
                <li><a href="#">none of above available</a></li>
            </ul>
        </div>
        <div class="fh5co-box">
            <h3 class="heading">Operation</h3>
            <form action="#">
                <div class="form-group">
                    <input readonly="readonly" class="form-control" placeholder="click to refresh" onclick="refreshCart()"/>
                    <input readonly="readonly" class="form-control" placeholder="click to clear" onclick="checkoutCart()"/>
                    <input readonly="readonly" class="form-control" placeholder="click to pay" onclick="payCart()"/>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">

    <div class="container-fluid">

        <div class="row">
            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
            <ul class="fh5co-social">
                <li><a href="#"><i class="icon-shopping-cart"></i></a></li>
            </ul>
            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="/bookstore/static/home">Read Your Heart <sup>TM</sup></a></h1>
            </div>

        </div>

    </div>

</header>
<%--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>--%>
<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry">
        <c:forEach items="${books}" var="book">
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_1.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">${book.name}</a></span>
            <h2 class="fh5co-article-title"><a href="#">${book.author}</a></h2>
            <span class="fh5co-meta fh5co-date">${book.price}<button class="icon-shopping-cart" onclick="addToCart('${book.isbn}')">Add to cart</button></span>
        </article>
        </c:forEach>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_2.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Food &amp; Drink</a></span>
            <h2 class="fh5co-article-title"><a href="#">Beef Steak at Guatian Restaurant</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_3.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">An Overlooking River at the East Cost</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_4.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">A Wildlife In The Mountain of India</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-lg-block visible-md-block visible-sm-block visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_5.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Photography</a></span>
            <h2 class="fh5co-article-title"><a href="#">We Took A Photo</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_6.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">A Modernize Huge and Beautiful Building</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_7.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Food &amp; Drinks</a></span>
            <h2 class="fh5co-article-title"><a href="#">Enjoying the Native Juice Drink in Brazil</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_8.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">Boat Travel in The Vietnam River</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-lg-block visible-md-block visible-sm-block visible-xs-block"></div>



        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_1.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Food &amp; Drink</a></span>
            <h2 class="fh5co-article-title"><a href="#">We Eat and Drink All Night</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_2.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Food &amp; Drink</a></span>
            <h2 class="fh5co-article-title"><a href="#">Beef Steak at Guatian Restaurant</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_3.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">An Overlooking River at the East Cost</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_4.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">A Wildlife In The Mountain of India</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-lg-block visible-md-block visible-sm-block visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_5.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Photography</a></span>
            <h2 class="fh5co-article-title"><a href="#">We Took A Photo</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_6.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">A Modernize Huge and Beautiful Building</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-xs-block"></div>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_7.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Food &amp; Drinks</a></span>
            <h2 class="fh5co-article-title"><a href="#">Enjoying the Native Juice Drink in Brazil</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
            <figure>
                <a href="#"><img src="/bookstore/static/images/pic_8.jpg" alt="Image" class="img-responsive"></a>
            </figure>
            <span class="fh5co-meta"><a href="#">Travel</a>, <a href="#">Style</a></span>
            <h2 class="fh5co-article-title"><a href="#">Boat Travel in The Vietnam River</a></h2>
            <span class="fh5co-meta fh5co-date">March 6th, 2016</span>
        </article>
        <div class="clearfix visible-xs-block"></div>
    </div>
</div>

<footer id="fh5co-footer">
    <p><small>&copy; 2017. Read Your Heart. All Rights Reserved. <br> About Me <a href="http://115.159.118.37/" target="_blank" title="Leo Xiong">Leo Xiong</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small></p>
</footer>

<div class="modal fade" id="alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="alertModal">服务器消息</h4>
            </div>
            <div class="modal-body">
                <center><p id="msg"></p></center>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- jQuery -->
<script src="/bookstore/static/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="/bookstore/static/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="/bookstore/static/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="/bookstore/static/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="/bookstore/static/js/main.js"></script>

<script src="/bookstore/static/js/xg-learning.js"></script>
<script>
    function addToCart(id) {
        var url = "cart/add/" + id;
        ajaxPost(url,{});
    }
    
    function refreshCart() {
        $.ajax({
            "type": "POST",
            "url": "cart",
            "contentType": "application/json",
            "dataType": "json",
            "success":function (info) {
                if(info.msg == -1){
                    document.getElementById("msg").innerHTML = "刷新失败!";
                    $('#alert').modal('show');
                }else {
                    var data = JSON.parse(JSON.stringify(info));
                    var cart = document.getElementById("shopping-cart");
                    cart.innerHTML = "";
                    for(var i in data){
                        cart.innerHTML = cart.innerHTML + "<li><a href='#'>" + i + "</a><a class='icon-book'>" + data[i] + "</a></li>";

                    }
                }
            }
        })
    }

    function checkoutCart() {
        var url = "cart/checkout";
        ajaxPost(url,{});
    }

    function payCart() {
        var url = "cart/pay";
        ajaxPost(url,{});
    }
</script>
</body>
</html>
