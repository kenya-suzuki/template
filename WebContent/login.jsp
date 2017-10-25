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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/login.css">

</head>
<body>

	<div class="rerun">
		<a href="">Rerun Pen</a>
	</div>
	<div class="container">
		<div class="card"></div>
		<div class="card">
			<h1 class="title">Login</h1>
			<form action="LoginAction">
				<div class="input-container">
					<input type="type" name="loginUserId" id="label"
						required="required" /> <label for="label">e-mail</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="type" name="loginPassword" id="label"
						required="required" /> <label for="label">Password</label>
					<div class="bar"></div>
				</div>
				<div class="button-container">
					<button>
						<span>Go</span>
					</button>
				</div>
				<div class="footer">
					<a href="<s:url action="GoHomeAction" />">Back to Home</a>
				</div>
			</form>
		</div>
		<div class="card alt">
			<div class="toggle"></div>
			<h1 class="title">Register</h1>
			<div class="close"></div>
			<form action="UserCreateConfirmAction">
				<div class="input-container">
					<input type="type" name="userName" id="label" required="required" />
					<label for="label">Username</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="type" name="loginUserId" id="label"
						required="required" /> <label for="label">e-mail</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="type" name="loginPassword" id="label"
						required="required" /> <label for="label">Password</label>
					<div class="bar"></div>
				</div>
				<div class="button-container">
					<button>
						<span>Next</span>
					</button>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script src="js/login.js"></script>

</body>
</html>