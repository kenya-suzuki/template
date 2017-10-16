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
<meta charset="utf-8">
<title>Login画面</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<form class="form-signin">
				<span id="reauth-email" class="reauth-email"></span> <input
					type="email" id="inputEmail" class="form-control"
					placeholder="Email address" required autofocus> <input
					type="password" id="inputPassword" class="form-control"
					placeholder="Password" required> <a
					href="<s:url action="UserCreateAction" />" class="forgot-password">
					Account creation </a><br>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<a href="<s:url action="GoHomeAction" />" class="forgot-password">
				Back to Home </a>
		</div>
	</div>
</body>
</html>