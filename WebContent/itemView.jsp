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

	<s:iterator value="#">
		<!--　商品１　-->
		<div class="picture1">


			<div class="price">

				<strong><s:property value="itemName" /></strong>
			</div>
			<!-- price end -->

			<a
				href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>">

				<img class="item_img" src="<s:property value="image"/>">
			</a>
			<div class="price2">
				<span><s:hidden value="itemId" /></span><span class="font_en"><s:text
						name="lang.itemview.doru" /> <fmt:formatNumber value="${price}"
						pattern="###,###,###" /></span><strong><s:text
						name="lang.itemview.price" /></strong>
			</div>
		</div>
		<!--picture1 end  -->


	</s:iterator>

</body>
</html>