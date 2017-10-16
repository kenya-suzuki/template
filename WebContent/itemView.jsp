<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->

	<s:iterator value="searchList">
		<!--　商品１　-->
		<div class="picture1">
			<a
				href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>">

				<img class="item_img" src="img/<s:property value="itemImage"/>">
			</a>

			<div class="itemName">
				<strong><s:property value="itemName" /></strong>
			</div>
			<div class="author">
				<strong><s:property value="author" /></strong>
			</div>
		</div>
	</s:iterator>

</body>
</html>