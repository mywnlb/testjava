<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="admin-themes-lab">
    <meta name="author" content="boil">
    <title>${setting.siteName}</title>
    <link href="${base}/admin/assets/css/main.css" rel="stylesheet">
</head>

<body class="fixed-topbar fixed-sidebar theme-sltd color-primary">
<!--[if lt IE 8]>
<p class="browsehappy">
    亲爱的用户您用的浏览器 <strong>太旧了</strong>. 请到 <a href="http://browsehappy.com/">这个网站</a>升级您的浏览器
</p>
<![endif]-->
<!-- BEGIN TOPBAR -->
<div class="topbar anjian-topbar topbar-bgcolor">
    <div class="header-left">
        <div class="topnav">
            <a class="mainLogo" href="#"><i class="fa fa-pie-chart"></i> 博益安全云</a>
            <div  class="btn-group dropdown">
                <button dropdown-toggle="" style="background:#529BCB;border:none;line-height:45px; height:50px;padding:0 10px 0 15px;color: #ddd;" type="button" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">

                    <span class="caret"></span>
                </button>
            </div>
        </div>
    </div>
</div>
<!-- END TOPBAR -->
    <!-- BEGIN SIDEBAR -->
    <div class="sidebar">
        <div class="sidebar-inner">

        </div>
    </div>


    <div class="main-content">
        <div class="page-content" >
            <div class="error-container ">
                <div class="error-main m-t-60">
                    <h1 class="f-40">访问出错</h1>
                    <h3><span id="404-txt">很抱歉${error.message}</span><span class="typed-cursor" style="opacity: 0;">|</span></h3>
                    <a class="btn btn-primary btn-lg" href="${base}/logout">返回登录页面</a>
                </div>
            </div>
        </div>

    </div>

<a href="#" class="scrollup"><i class="fa fa-angle-up"></i></a>

</body>
</html>
