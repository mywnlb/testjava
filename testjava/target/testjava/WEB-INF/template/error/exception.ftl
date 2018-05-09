<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="boil">
    <!--<link rel="shortcut icon" href="assets/images/favicon.png" type="image/png">-->
    <title>${setting.siteName}</title>
    <!-- BEGIN PAGE STYLE -->
    <link href="${base}/public/css/main.min.css" rel="stylesheet">
    <!-- END PAGE STYLE -->
</head>
<!-- BEGIN BODY -->
<body class="fixed-topbar fixed-sidebar theme-sltd color-primary"
      ng-class="{'sidebar-collapsed':sidebarcollapsed}"><!--{{bodyClasses}}--><!--[if lt IE 8]>
<p class="browsehappy">
    亲爱的用户您用的浏览器 <strong>太旧了</strong>. 请到
    <a href="http://browsehappy.com/">这个网站</a>
    升级您的浏览器
</p><![endif]-->
<!-- BEGIN TOPBAR -->
<div class="topbar anjian-topbar topbar-bgcolor">
    <div class="header-left">
        <div class="topnav">
            <menutoggle sidebarcollapsed="sidebarcollapsed"></menutoggle>

            <a class="mainLogo" href="#">
            ${setting.siteName}
            </a>
        </div>
    </div>

</div>
<!-- END TOPBAR -->
<div class="pos-abs w-100p h-100p flex-box">
    <div class="item one  flex-box column flex col-center row-center m-t-50">
        <img src="${base}/public/images/unauthorized.png" alt="">
        <div class="f-16 m-t-50">
            <p class="t-center">${error.message}</p>
            <div class="t-center m-t-20">
                <a href="${base}/logout" class="btn btn-primary">返回登录界面</a>
            </div>
        </div>
    </div>
    <!-- END MAIN CONTENT -->
</div>
</body>
</html>
