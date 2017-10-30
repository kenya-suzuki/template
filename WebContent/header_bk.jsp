<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/header.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/my.magicline.1.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".mainnav").my_magicline();
	});
</script>
</head>
<body>
	<s:if test="#session.userId == null">
		<div class="entirebody">
			<ul class="mainnav">
				<li><a href="<s:url action="GoHomeAction" />">Home</a></li>
				<li><a
					href='<s:url action="ItemViewAction"><s:param name="categoryId" value="%{'1'}"/></s:url>'>Product</a></li>
				<li><a href="<s:url action="MyPageAction" />">My page</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</div>
	</s:if>
	<s:else>
		<div class="entirebody">
			<ul class="mainnav">
				<li><a href="<s:url action="GoHomeAction" />">Home</a></li>
				<li><a
					href='<s:url action="ItemViewAction"><s:param name="categoryId" value="%{'1'}"/></s:url>'>Product</a></li>
				<li><a href="<s:url action="MyPageAction" />">My page</a></li>
				<li><a href="<s:url action="LogoutAction" />">Logout</a></li>
			</ul>
		</div>
	</s:else>
</body>
</html>