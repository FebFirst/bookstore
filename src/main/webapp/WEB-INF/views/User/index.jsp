<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 11/04/2017
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="xg" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    String lang = (String)request.getAttribute("language");
    ResourceBundle bundle;
    if(lang.equals("zh_CN"))
        bundle = ResourceBundle.getBundle("languages/zh_CN", Locale.CHINA);
    else
        bundle =ResourceBundle.getBundle("languages/en_US", Locale.US);
%>
<html>
<head>
    <title>Read Your Heart</title>

    <link rel="icon" href="http://115.159.118.37/wp-content/uploads/2017/04/WoW.jpg" sizes="32x32" />
    <link rel="icon" href="http://115.159.118.37/wp-content/uploads/2017/04/WoW.jpg" sizes="192x192" />

    <!-- Library - Google Font Familys -->
    <link href="https://fonts.googleapis.com/css?family=Arizonia|Crimson+Text:400,400i,600,600i,700,700i|Lato:100,100i,300,300i,400,400i,700,700i,900,900i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/bookstore/static/revolution/css/settings.css">

    <!-- RS5.0 Layers and Navigation Styles -->
    <link rel="stylesheet" type="text/css" href="/bookstore/static/revolution/css/layers.css">
    <link rel="stylesheet" type="text/css" href="/bookstore/static/revolution/css/navigation.css">

    <!-- Library - Bootstrap v3.3.5 -->
    <link rel="stylesheet" type="text/css" href="/bookstore/static/libraries/lib.css">

    <!-- Custom - Common CSS -->
    <link rel="stylesheet" type="text/css" href="/bookstore/static/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="/bookstore/static/css/navigation-menu.css">
    <link rel="stylesheet" type="text/css" href="/bookstore/static/css/shortcode.css">
    <link rel="stylesheet" type="text/css" href="/bookstore/static/css/style.css">

</head>
<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<div class="main-container">
    <!-- Loader -->
    <div id="site-loader" class="load-complete">
        <div class="loader">
            <div class="loader-inner ball-clip-rotate">
                <div></div>
            </div>
        </div>
    </div><!-- Loader /- -->

    <!-- Header -->
    <header class="header-section container-fluid no-padding">
        <!-- Top Header -->
        <!-- Menu Block -->
        <div class="container-fluid no-padding menu-block">
            <!-- Container -->
            <div class="container">
                <!-- nav -->
                <nav class="navbar navbar-default ow-navigation">
                    <div class="navbar-header">
                        <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="index.html" class="navbar-brand">Read <span>Mind</span></a>
                    </div>
                    <!-- Menu Icon -->
                    <div class="menu-icon">
                        <div class="search">
                            <a href="#" id="search" title="Search"><i class="icon icon-Search"></i></a>
                        </div>
                        <div>
                            <ul class="cart">
                            <li><a aria-expanded="true" aria-haspopup="true" data-toggle="dropdown" id="message" class="btn dropdown-toggle" href="#" title="Like"><i class="icon icon-Message"></i></a>
                                <ul class="dropdown-menu no-padding" id="web-message">
                                    <input class="btn btn-primary" type="submit" id="join" value="Join!" onclick="sendJoin();"/><br/>
                                    <input class="form-control" id="input" disabled="true"
                                           onkeyup="sendMessage(event);"/><br/>
                                    <div class="panel panel-info"  cols="30" rows="20" readonly="true">
                                        <div class="panel-heading">
                                            <h3 class="panel-title"><%=bundle.getString("chatmassages")%></h3>
                                        </div>
                                        <div class="panel-body" id="textarea">
                                        </div>
                                    </div>
                                    <div class="panel panel-info" cols="20" rows="20" readonly="true">
                                        <div class="panel-heading">
                                            <h3 class="panel-title"><%=bundle.getString("user")%></h3>
                                        </div>
                                        <div class="panel-body" id="userlist">
                                        </div>
                                    </div>
                                    <br/><br/><br/>
                                    <input id="showhideconsole" type="checkbox" onclick="showHideConsole();"/>
                                    Show WebSocket console<br/>
                                    <div id="consolediv"><div class="panel panel-info" id="wsconsole" cols="80" rows="8" readonly="true"
                                                              style="font-size:8pt;"></div></div>
                                </ul>
                            </li>
                            </ul>
                        </div>
                        <div>
                        <ul class="cart">
                            <li>
                                <a aria-expanded="true" aria-haspopup="true" data-toggle="dropdown" id="cart" class="btn dropdown-toggle" title="Add To Cart" href="#"><i class="icon icon-ShoppingCart"></i></a>
                                <ul class="dropdown-menu no-padding" id="shopping-cart">
                                    <li class="button">
                                        <a title="View Cart" onclick="refreshCart()"><%=bundle.getString("viewcart")%></a>
                                        <a title="Check Out" onclick="checkoutCart()"><%=bundle.getString("checkout")%></a>
                                    </li>
                                </ul>
                            </li>


                        </ul>
                        </div>
                        <div>
                            <li>
                                <a aria-expanded="true" aria-haspopup="true" data-toggle="dropdown" class="btn dropdown-toggle" title="Add To Cart" href="#"><i class="icon icon-User"></i></a>
                                <ul class="dropdown-menu no-padding" id="language">
                                    <li class="button">
                                        <a title="ENGLISH" onclick="setLanguage('en_US')">ENG</a>
                                        <a title="简体中文" onclick="setLanguage('zh_CN')">中文</a>
                                    </li>
                                </ul>
                            </li>
                        </div>
                    </div><!-- Menu Icon /- -->
                    <div class="navbar-collapse collapse navbar-right" id="navbar">
                        <ul class="nav navbar-nav">
                            <li><a href="index.html"><%=bundle.getString("home")%></a></li>
                            <li><a href="cart.html"><%=bundle.getString("cart")%></a></li>
                            <li><a href="checkout.html"><%=bundle.getString("checkout")%></a></li>
                            <li><a href="about.html"><%=bundle.getString("aboutus")%></a></li>
                            <li><a href="contact-us.html"><%=bundle.getString("contactus")%></a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </nav><!-- nav /- -->
                <!-- Search Box -->
                <div class="search-box">
                    <span><i class="icon_close"></i></span>
                    <form><input type="text" class="form-control" placeholder="Enter a keyword and press enter..." /></form>
                </div><!-- Search Box /- -->
            </div><!-- Container /- -->
        </div><!-- Menu Block /- -->
    </header><!-- Header /- -->

    <main>
        <!-- Slider Section 1 -->
        <div id="home-revslider" class="slider-section container-fluid no-padding">
            <!-- START REVOLUTION SLIDER 5.0 -->
            <div class="rev_slider_wrapper">
                <div id="home-slider1" class="rev_slider" data-version="5.0">
                    <ul>
                        <li data-transition="zoomout" data-slotamount="default"  data-easein="easeInOut" data-easeout="easeInOut" data-masterspeed="2000" data-rotate="0"  data-fstransition="fade" data-fsmasterspeed="1500" data-fsslotamount="7">
                            <img src="/bookstore/static/images/slider-1.jpg" alt="slider" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="10" class="rev-slidebg" data-no-retina>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-1"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-200','-130','-110','-80']"
                                 data-fontsize="['38','30','25','16']"
                                 data-lineheight="['24','24','24','24']"
                                 data-width="none"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="y:-50px;opacity:0;s:1000;e:Power4.easeOut;"
                                 data-transform_out="opacity:0;s:3000;e:Power4.easeIn;s:3000;e:Power4.easeIn;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 3.04px; color:#333; font-weight: 700; font-family: 'Montserrat', sans-serif; text-transform: uppercase;">new way to purchase your lovers
                            </div>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-2"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-135','-80','-60','-50']"
                                 data-fontsize="['18','18','18','14']"
                                 data-lineheight="['26','26','26','26']"
                                 data-width="['750','750','738','450']"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="x:[105%];z:0;rX:45deg;rY:0deg;rZ:90deg;sX:1;sY:1;skX:0;skY:0;s:2000;e:Power4.easeInOut;"
                                 data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 1.5px; color:#777; font-weight: normal; font-family: 'Lato', sans-serif;">The weather started getting rough the tiny ship was tossed. If not for the courage of the fearless
                            </div>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-3"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-110','-50','-35','-30']"
                                 data-fontsize="['18','18','18','14']"
                                 data-lineheight="['26','26','26','26']"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="x:[105%];z:0;rX:45deg;rY:0deg;rZ:90deg;sX:1;sY:1;skX:0;skY:0;s:2000;e:Power4.easeInOut;"
                                 data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 1.5px; color:#777; font-weight: normal; font-family: 'Lato', sans-serif;">crew the Minnow would be lost. our dreams come true for me and you.
                            </div>
                            <div class="tp-caption NotGeneric-Button rev-btn  rs-parallaxlevel-0" id="slide-layer-4"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-30','20','40','30']"
                                 data-fontsize="['14','14','14','12']"
                                 data-lineheight="['24','24','24','24']"
                                 data-width="none"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_hover="o:1;rX:0;rY:0;rZ:0;z:0;s:100;e:Power1.easeInOut;"
                                 data-style_hover="c:rgb(255, 255, 255);bg:rgba(182, 121, 95);"
                                 data-transform_in="x:[-100%];z:0;rX:0deg;rY:0deg;rZ:0deg;sX:1;sY:1;skX:0;skY:0;opacity:0;s:2500;e:Power3.easeInOut;"
                                 data-transform_out="auto:auto;s:1000;e:Power2.easeInOut;"
                                 data-start="2000"
                                 data-splitin="none"
                                 data-splitout="none"
                                 data-actions='[{"event":"click","action":"scrollbelow","offset":"0px"}]'
                                 data-responsive_offset="on"
                                 data-responsive="off"
                                 style="z-index: 10; padding:8px 38px; letter-spacing:0.56px; color: #b6795f; border-color: #b6795f; font-family: 'Montserrat', sans-serif; text-transform:uppercase; background-color:transparent; white-space: nowrap;outline:none;box-shadow:none;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;">Enjoy Now
                            </div>
                        </li>

                        <li data-transition="zoomout" data-slotamount="default"  data-easein="easeInOut" data-easeout="easeInOut" data-masterspeed="2000" data-rotate="0"  data-fstransition="fade" data-fsmasterspeed="1500" data-fsslotamount="7">
                            <img src="/bookstore/static/images/slider-1.jpg" alt="slider" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="10" class="rev-slidebg" data-no-retina>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-5"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-200','-130','-110','-80']"
                                 data-fontsize="['38','30','25','16']"
                                 data-lineheight="['24','24','24','24']"
                                 data-width="none"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="y:-50px;opacity:0;s:1000;e:Power4.easeOut;"
                                 data-transform_out="opacity:0;s:3000;e:Power4.easeIn;s:3000;e:Power4.easeIn;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 3.04px; color:#333; font-weight: 700; font-family: 'Montserrat', sans-serif; text-transform: uppercase;">new way to purchase your products
                            </div>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-6"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-135','-80','-60','-50']"
                                 data-fontsize="['18','18','18','14']"
                                 data-lineheight="['26','26','26','26']"
                                 data-width="['750','750','738','450']"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="x:[105%];z:0;rX:45deg;rY:0deg;rZ:90deg;sX:1;sY:1;skX:0;skY:0;s:2000;e:Power4.easeInOut;"
                                 data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 1.5px; color:#777; font-weight: normal; font-family: 'Lato', sans-serif;">The weather started getting rough the tiny ship was tossed. If not for the courage of the fearless
                            </div>
                            <div class="tp-caption NotGeneric-Title tp-resizeme rs-parallaxlevel-0" id="slide-layer-7"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-110','-50','-35','-30']"
                                 data-fontsize="['18','18','18','14']"
                                 data-lineheight="['26','26','26','26']"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_in="x:[105%];z:0;rX:45deg;rY:0deg;rZ:90deg;sX:1;sY:1;skX:0;skY:0;s:2000;e:Power4.easeInOut;"
                                 data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                                 data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                                 data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                                 data-start="1000"
                                 data-splitin="chars"
                                 data-splitout="none"
                                 data-responsive_offset="on"
                                 data-elementdelay="0.05"
                                 style="z-index: 5; white-space: nowrap; letter-spacing: 1.5px; color:#777; font-weight: normal; font-family: 'Lato', sans-serif;">crew the Minnow would be lost. our dreams come true for me and you.
                            </div>
                            <div class="tp-caption NotGeneric-Button rev-btn  rs-parallaxlevel-0" id="slide-layer-8"
                                 data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
                                 data-y="['middle','middle','middle','middle']" data-voffset="['-30','20','40','30']"
                                 data-fontsize="['14','14','14','12']"
                                 data-lineheight="['24','24','24','24']"
                                 data-width="none"
                                 data-height="none"
                                 data-whitespace="nowrap"
                                 data-transform_idle="o:1;"
                                 data-transform_hover="o:1;rX:0;rY:0;rZ:0;z:0;s:100;e:Power1.easeInOut;"
                                 data-style_hover="c:rgb(255, 255, 255);bg:rgba(182, 121, 95);"
                                 data-transform_in="x:[-100%];z:0;rX:0deg;rY:0deg;rZ:0deg;sX:1;sY:1;skX:0;skY:0;opacity:0;s:2500;e:Power3.easeInOut;"
                                 data-transform_out="auto:auto;s:1000;e:Power2.easeInOut;"
                                 data-start="2000"
                                 data-splitin="none"
                                 data-splitout="none"
                                 data-actions='[{"event":"click","action":"scrollbelow","offset":"0px"}]'
                                 data-responsive_offset="on"
                                 data-responsive="off"
                                 style="z-index: 10; padding:8px 38px; letter-spacing:0.56px; color: #b6795f; border-color: #b6795f; font-family: 'Montserrat', sans-serif; text-transform:uppercase; background-color:transparent; white-space: nowrap;outline:none;box-shadow:none;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;"><%=bundle.getString("shopnow")%>
                            </div>
                        </li>
                    </ul>
                </div><!-- END REVOLUTION SLIDER -->
            </div><!-- END OF SLIDER WRAPPER -->
            <div class="goto-next"><a href="#category-section"><i class="icon icon-Mouse bounce"></i></a></div>
        </div><!-- Slider Section 1 /- -->

        <!-- Services Section -->
        <%--<div class="services-section container-fluid">--%>
            <%--<!-- Container -->--%>
            <%--<div class="container">--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-6">--%>
                    <%--<div class="srv-box">--%>
                        <%--<i class="icon icon-Truck"></i><h5>Free delivery</h5><i class="icon icon-Dollar"></i>--%>
                        <%--<span class="icon_close"></span>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-6">--%>
                    <%--<div class="srv-box">--%>
                        <%--<i class="icon icon-Goto"></i><h5>Money Back</h5><i class="icon icon-Dollars"></i>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-6">--%>
                    <%--<div class="srv-box">--%>
                        <%--<i class="icon icon-Headset"></i><h5>24/7 support</h5><i class="icon icon-Timer"></i>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div><!-- Container /- -->--%>
        <%--</div><!-- Services Section /- -->--%>



        <!-- Product Section -->
        <div id="product-section" class="product-section container-fluid no-padding">
            <!-- Container -->
            <div class="container">
                <div class="row">
                    <!-- Section Header -->
                    <div class="section-header">
                        <h3>Our Products</h3>
                        <p>our vision is to be Earth's most customer centric company</p>
                        <img src="/bookstore/static/images/section-seprator.png" alt="section-seprator" />
                    </div><!-- Section Header /- -->
                    <ul id="filters" class="products-categories no-left-padding">
                        <li><a data-filter="*" class="active" href="#"><%=bundle.getString("allcate")%></a></li>
                        <li><a data-filter=".design" href="#"><%=bundle.getString("edu")%></a></li>
                        <li><a data-filter=".video" href="#"><%=bundle.getString("sci")%></a></li>
                        <li><a data-filter=".photography" href="#"><%=bundle.getString("lit")%></a></li>
                        <li><a data-filter=".web" href="#">read</a></li>
                        <li><a data-filter=".design" href="#">your</a></li>
                        <li><a data-filter=".photography" href="#">heart</a></li>
                        <li><a data-filter=".video" href="#"><%=bundle.getString("other")%><i class="fa fa-angle-down"></i></a></li>
                    </ul>
                    <div class="input-group">
                        <input class="form-control" placeholder="Search You Wants" type="text">
                        <span class="input-group-btn">
								<button class="btn btn-search" title="Search" type="button"><i class="icon icon-Search"></i></button>
							</span>
                    </div>
                    <!-- Products -->
                    <ul class="products">
                        <!-- Product -->

                        <!-- Product -->
                        <xg:forEach items="${books}" var="book">
                        <li class="product video">
                            <a href="#">
                                <img src="/bookstore/static/images/product-2.jpg" alt="Product" />
                                <h5><a href="#" title="${book.name}" onclick="bookDetail('${book.isbn}', this)">${book.name}</a></h5>
                                <h6>-${book.author}</h6>
                                <span class="price">${book.price}</span>
                            </a>
                            <div class="wishlist-box">
                                <a href="#"><i class="fa fa-arrows-alt"></i></a>
                                <a href="#"><i class="fa fa-heart-o"></i></a>
                                <a href="#"><i class="fa fa-search" onclick="bookDetail('${book.isbn}')"></i></a>
                            </div>
                            <a class="addto-cart" title="Add To Cart" onclick="addToCart('${book.isbn}')">Add To Cart</a>
                        </li><!-- Product /- -->
                        </xg:forEach>

                    </ul><!-- Products /- -->
                </div><!-- Row /- -->
                <nav class="ow-pagination">
                    <ul class="pager">
                        <li class="number"><a href="#">4</a></li>
                        <li class="load-more"><a href="#"><%=bundle.getString("loadmore")%></a></li>
                        <li class="previous"><a href="#"><i class="fa fa-angle-right"></i></a></li>
                        <li class="next"><a href="#"><i class="fa fa-angle-left"></i></a></li>
                    </ul>
                </nav>
            </div><!-- Container /- -->
        </div><!-- Product Section /- -->


        <!-- Latest Blog -->
        <div class="blog-section latest-blog container-fluid">
            <!-- Container -->
            <div class="container">
                <!-- Section Header -->
                <div class="section-header">
                    <h3><%=bundle.getString("latestnews")%></h3>
                    <p>our vision is to be Earth's most customer centric company</p>
                    <img src="/bookstore/static/images/section-seprator.png" alt="section-seprator" />
                </div><!-- Section Header /- -->
                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="type-post">
                        <div class="entry-cover">
                            <a href="#"><img src="/bookstore/static/images/blog-1.jpg" alt="blog"></a>
                            <span class="post-date"><a href="#"><i class="fa fa-calendar-o"></i>July 20</a></span>
                        </div>
                        <div class="blog-content">
                            <h3 class="entry-title"><a href="#" title="new Collectios are imported In Our shop.">new Collectios are<span>imported</span> In Our shop.</a></h3>
                            <div class="entry-meta">
                                <span class="post-like"><a href="#" title="224 Likes"><i class="fa fa-heart-o"></i>224 Likes</a></span>
                                <span class="post-admin"><i class="fa fa-user"></i>Posted By <a href="#" title="Max">Max</a></span>
                            </div>
                            <div class="entry-content">
                                <p>The weather started getting rough - the tiny ship was tossed. If not for the courage of the fearless crew the Minnow would be lost.</p>
                                <a href="#" title="Read More" class="read-more"><%=bundle.getString("readmore")%><i class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="type-post">
                        <div class="entry-cover">
                            <a href="#"><img src="/bookstore/static/images/blog-3.jpg" alt="blog"></a>
                            <span class="post-date"><a href="#"><i class="fa fa-calendar-o"></i>march 14</a></span>
                        </div>
                        <div class="blog-content">
                            <h3 class="entry-title"><a href="#" title="buyers are saying it's good shop">buyers are saying it's <span>good shop</span></a></h3>
                            <div class="entry-meta">
                                <span class="post-like"><a href="#" title="150 Likes"><i class="fa fa-heart-o"></i>150 Likes</a></span>
                                <span class="post-admin"><i class="fa fa-user"></i>Posted By <a href="#" title="Max">Max</a></span>
                            </div>
                            <div class="entry-content">
                                <p>The weather started getting rough - the tiny ship was tossed. If not for the courage of the fearless crew the Minnow would be lost.</p>
                                <a href="#" title="Read More" class="read-more"><%=bundle.getString("readmore")%><i class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="type-post">
                        <div class="entry-cover">
                            <a href="#"><img src="/bookstore/static/images/blog-2.jpg" alt="blog"></a>
                            <span class="post-date"><a href="#"><i class="fa fa-calendar-o"></i>june 26</a></span>
                        </div>
                        <div class="blog-content">
                            <h3 class="entry-title"><a title="Best Solds in the this year was watches" href="#">Best Solds in the this year was <span>watches</span></a></h3>
                            <div class="entry-meta">
                                <span class="post-like"><a href="#" title="85 Likes"><i class="fa fa-heart-o"></i>85 Likes</a></span>
                                <span class="post-admin"><i class="fa fa-user"></i>Posted By <a href="#" title="Max">Max</a></span>
                            </div>
                            <div class="entry-content">
                                <p>The weather started getting rough - the tiny ship was tossed. If not for the courage of the fearless crew the Minnow would be lost.</p>
                                <a href="#" title="Read More" class="read-more"><%=bundle.getString("readmore")%><i class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- Container /- -->
        </div><!-- Latest Blog /- -->


    </main>

    <!-- Footer Main -->
    <footer id="footer-main" class="footer-main container-fluid">
        <!-- Container -->
        <div class="container">

            <div class="copyright-section">
                <div class="coyright-content">
                    <p>Copyright &copy; 2017.Leo Xiong All rights reserved.<a target="_blank" href="http://115.159.118.37"></a></p>
                </div>
                <ul>
                    <li><a href="#" title="Delivery Information">Delivery Information</a></li>
                    <li><a href="#" title="Privacy Policy">Privacy Policy</a></li>
                    <li><a href="#" title="Terms & Condition">Terms & Condition</a></li>
                </ul>
            </div>
        </div><!-- Container /- -->
    </footer><!-- Footer Main /- -->

</div>


<!-- JQuery v1.12.4 -->
<script src="/bookstore/static/js/jquery.min.js"></script>

<!-- Library - Js -->
<script src="/bookstore/static/libraries/lib.js"></script>

<script src="/bookstore/static/libraries/jquery.countdown.min.js"></script>

<!-- RS5.0 Core JS Files -->
<script type="text/javascript" src="/bookstore/static/revolution/js/jquery.themepunch.tools.min.js?rev=5.0"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/jquery.themepunch.revolution.min.js?rev=5.0"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="/bookstore/static/revolution/js/extensions/revolution.extension.actions.min.js"></script>

<!-- Library - Theme JS -->
<script src="/bookstore/static/js/functions.js"></script>

<script src="/bookstore/static/js/xg-learning.js"></script>

<script src="/bookstore/static/js/webSocket.js"></script>

<script>
    function bookDetail(isbn, tag) {
        $.ajax({
            "type": "POST",
            "url": "book/detail/" + isbn ,
            "contentType": "application/json",
            "data": JSON.stringify({"isbn":isbn}),
            "dataType": "json",
            "success":function (info) {
                var data = JSON.parse(JSON.stringify(info));
                tag.title = "";
                for(var i in data){
                    tag.title += i + ": " +data[i] + "\r\n";
                }
                //tag.title = JSON.stringify(info.msg);
                //tag.title = info.msg.isbn + "&#13;" + info.msg.name + "&#13;" + info.msg.author +"&#13;" + info.msg.price;
            }
        });
    }

    function setLanguage(flag) {
        if(flag=="zh_CN"){
            window.location.href = "/bookstore/index/zh_CN";
        }
        if(flag=="en_US"){
            window.location.href = "/bookstore/index/en_US";
        }
    }
</script>
</body>
</html>

