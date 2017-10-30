<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/itemView.css">

</head>
<body>

	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->

	<!--<script type="text/javascript" src="js/jquery.adaptive-backgrounds.js"></script>
	<script>
		$(document).ready(function() {
			$.adaptiveBackground.run();
		});
	</script>-->

	<s:iterator value="searchList">
		<!--　商品１　-->
		<div class="itemBox">
			<ul class="item_img" id="nav">
				<li data-ab-css-background='1'><a
					href="<s:url action="ItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>">
						<img src="img/<s:property value="itemImage"/>" alt=""
						data-adaptive-background='1' />
				</a></li>
				<li>
					<h4>
						<s:property value="itemName" />
						/
						<s:property value="author" />
					</h4>
				</li>
			</ul>
		</div>
	</s:iterator>


	<script src="js/jquery.fadethis.min.js"></script>
	<script>
		$(function() {
			$(window).load(function() {
				var delaySpeed = 100;
				var fadeSpeed = 1000;
				$('ul li').each(function(i) {
					$(this).delay(i * (delaySpeed)).css({
						display : 'block',
						opacity : '0'
					}).animate({
						opacity : '1'
					}, fadeSpeed);
				});
			});
		});
	</script>

</body>
</html>