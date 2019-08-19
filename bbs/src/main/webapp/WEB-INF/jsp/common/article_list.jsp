<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="title">
	<h3>${param.name == null ? '最新发布' : param.name }</h3>
	<div class="more">
		<a href="">PHP</a><a href="">JavaScript</a><a href="">EmpireCMS</a><a
			href="">Apache</a><a href="">MySQL</a>
	</div>
</div>

<c:forEach items="${latestArticleList }" var="article">
	<article class="excerpt excerpt-1">
		<a class="focus" href="article?id=${article.id}" title=""><img class="thumb"
			data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></a>
		<header>
			<a class="cat" href="catArticle?id=${article.categoryid }">${article.category.name }<i></i></a>
			<h2>
				<a href="article?id=${article.id}" title="">${article.title }</a>
			</h2>
		</header>
		<p class="meta">
			<time class="time">
				<i class="glyphicon glyphicon-time"></i> ${article.createtime }
			</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i>
				共${article.readcnt }人围观</span> <a class="comment"
				href="article?id=${article.id}#comment"><i
				class="glyphicon glyphicon-comment"></i> 0个不明物体</a>
		</p>

		<p id="p${article.id}"></p>
		<div id="div${article.id}" style="display: none;">
			${article.content.substring(0,20)}</div>
		

		<script type="text/javascript">
			var div = div${article.id};
			var p = p${article.id};
			p.innerText = div.innerText;
		</script>

		<%-- <p class="note"><c:out value="${article.content.substring(0,20) }"  escapeXml="false" /></p> --%>
	</article>
</c:forEach>
<nav class="pagination" style="display: none;">
	<ul>
		<li class="prev-page"></li>
		<li class="active"><span>1</span></li>
		<li><a href="?page=2&id=${param.id }">2</a></li>
		<li class="next-page"><a href="?id=${param.id }">下一页</a></li>
		<li><span>共 2 页</span></li>
	</ul>
</nav>