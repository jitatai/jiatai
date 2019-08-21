<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="header">
  <nav class="navbar navbar-default" id="navbar">
    <div class="container">
      <div class="header-topbar hidden-xs link-border">
        <ul class="site-nav topmenu">
          <li><a href="tags.html">标签云</a></li>
          <li><a href="readers.html" rel="nofollow">读者墙</a></li>
          <li><a href="links.html" rel="nofollow">友情链接</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" rel="nofollow">关注本站 <span class="caret"></span></a>
            <ul class="dropdown-menu header-topbar-dropdown-menu">
              <li><a data-toggle="modal" data-target="#WeChat" rel="nofollow"><i class="fa fa-weixin"></i> 微信</a></li>
              <li><a href="#" rel="nofollow"><i class="fa fa-weibo"></i> 微博</a></li>
              <li><a data-toggle="modal" data-target="#areDeveloping" rel="nofollow"><i class="fa fa-rss"></i> RSS</a></li>
            </ul>
          </li>
        </ul>
      	  ${loginedUser == null ? '<a data-toggle="modal"  data-target="#loginModal" class="login" rel="nofollow">Hi 请登录</a>' : "欢迎".concat(loginedUser.name) }
        
        
        &nbsp;&nbsp;<a href="javascript:;" class="register" rel="nofollow">
        	我要注册</a>&nbsp;&nbsp;<a href="" rel="nofollow">找回密码</a>
        &nbsp;&nbsp;<a href="toedit" rel="nofollow">博文编辑</a> </div>
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <h1 class="logo hvr-bounce-in"><a href="" title=""><img src="images/logo.png" alt=""></a></h1>
      </div>
      <div class="collapse navbar-collapse" id="header-navbar">
        <ul class="nav navbar-nav navbar-right">
          <li class="hidden-index ${param.id==null?'active':'' }"><a data-cont="异清轩首页" href="index">异清轩首页</a></li>
        
          <c:forEach items="${categoryList }" var="category">
          	<li class="${param.id==category.id?'active':'' }"><a href="catArticle?id=${category.id }&name=${category.name }">${category.name }</a></li>
          </c:forEach>
          
        </ul>
        <form class="navbar-form visible-xs" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
    </div>
  </nav>
</header>

<script>
	function login(){
		$.post("user/login",
			{name:loginModalUserName.value,password:loginModalUserPwd.value},
			function (result){
				if(result.code == 1){
					alert("登陆成功!")
					$(".login").html("欢迎"+result.data);
					$('#loginModal').modal("hide");
				}
			}
		)
	}
</script>