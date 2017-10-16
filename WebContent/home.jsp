<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Home画面</title>

<link rel="stylesheet" href="css/vegas.min.css">

</head>
<body>
	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->


	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>

		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" />
			</s:form>
			<s:if test="#session.id != null">
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
				</p>
			</s:if>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="js/vegas.min.js"></script>

<script type="text/javascript">
$(function() {
    $('body').vegas({
    	timer : false,
        slides: [
            { src: 'img/home11.jpg' },
            { src: 'img/home12.jpg' },
            { src: 'img/home13.jpg' }
        ]
    });
});
</script>
</body>
</html>