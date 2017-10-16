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
<title>UserCreate画面</title>
<link rel="stylesheet" href="css/userCreate.css">
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<form class="form-signin" action="UserCreateConfirmAction">
				<h3>登録する情報を入力してください。</h3>
				<span id="reauth-email" class="reauth-email"></span> <input
					type="text" id="inputEmail" name="loginUserId" class="form-control"
					placeholder="Email address" required autofocus> <input
					type="text" id="inputPassword" name="loginPassword"
					class="form-control" placeholder="Password" required> <input
					type="text" id="inputUsername" name="userName" class="form-control"
					placeholder="User name" required>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">登録</button>
			</form>
			<a href="<s:url action="GoHomeAction" />" class="forgot-password">
				Back to Home </a>
		</div>
	</div>
</body>
</html>