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



<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="js/vegas.min.js"></script>

<script type="text/javascript">
$(function() {
    $('body').vegas({
    	timer : false,
        slides: [
            { src: 'img/home1.jpg' },
            { src: 'img/home2.jpg' },
            { src: 'img/home3.jpg' }
        ]
    });
});
</script>
</body>
</html>