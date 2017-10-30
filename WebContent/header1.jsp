<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/header1.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/my.magicline.1.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var $el, leftPos, newWidth;
				$mainNav2 = $("#example-one");

				/*
				      EXAMPLE ONE
				 */

				/* Add Magic Line markup via JavaScript, because it ain't gonna work without */
				$("#example-one").append("<li id='magic-line'></li>");

				/* Cache it */
				var $magicLine = $("#magic-line");

				$magicLine.width($(".current_page_item").width()).css("left",
						$(".current_page_item a").position().left).data(
						"origLeft", $magicLine.position().left).data(
						"origWidth", $magicLine.width());

				$("#example-one li").find("a").hover(function() {
					$el = $(this);
					leftPos = $el.position().left;
					newWidth = $el.width();

					$magicLine.stop().animate({
						left : leftPos,
						width : newWidth
					});
				}, function() {
					$magicLine.stop().animate({
						left : $magicLine.data("origLeft"),
						width : $magicLine.data("origWidth")
					});
				});
			});
</script>

</head>
<body>

	<div class="nav-wrap">
		<ul class="group" id="example-one">
			<li class="current_page_item"><a href="<s:url action="GoHomeAction" />">Home</a></li>
			<li><a href="<s:url action="GoHomeAction" />">Home</a></li>
			<li><a href="<s:url action="ItemViewAction"><s:param name="categoryId" value="%{'1'}"/></s:url>">Product</a></li>
			<li><a href="<s:url action="MyPageAction" />">My page</a></li>
			<li><a href="login.jsp">Login</a></li>
		</ul>
	</div>


</body>
</html>