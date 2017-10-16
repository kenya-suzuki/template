<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src='js/tabtab.js'></script>
<script>
$(document).ready( function() {
  tabify( '#tabs' );
});
</script>


</head>
<body>





<div class="tabs">

<ul class="tabs__menu">
	<li><a href="#">メニュー１</a></li>
	<li><a href="#">メニュー２</a></li>
	<li><a href="#">メニュー３</a></li>
	<li><a href="#">メニュー４</a></li>
</ul>

<div class="tabs__content">
	<div class="tabs-item">
		コンテンツ１
	</div>
	<div class="tabs-item">
		コンテンツ２
	</div>
	<div class="tabs-item">
		コンテンツ３
	</div>
	<div class="tabs-item">
		コンテンツ４
	</div>
</div>

</div>

</body>
</html>