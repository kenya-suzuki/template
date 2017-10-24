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

	<!-- header_login -->
	<s:include value="header.jsp" />
	<!-- header_login end -->





	<div class="container">

		<!--<div id="step_bar_box">
			<ol class="step_bar">
				<li class="visited"><s:text name="lang.payment.date" /></li>
				<li class="current"><s:text name="lang.payment.number" /></li>
				<li><s:text name="lang.payment.check" /></li>
				<li><s:text name="lang.payment.completion" /></li>
			</ol>
		</div>-->
		<!-- step_bar_box end -->

		<h1 class="center">クレジット情報を入力してください。</h1>

		<div class="formarea">

			<h3 class="center"><font color="red"><s:property value="errmsg2" /></font></h3>

			<s:form action="CreditAction">
				<table class="payment">
					<tr>
						<td>クレジットカード種類</td>
						<td><input type="radio" name="creditCardType" value="visa"
							checked="checked">visa <input type="radio"
							name="creditCardType" value="mastercard">mastercard <input
							type="radio" name="creditCardType" value="americanexpress"
							checked="checked">americanexpress</td>
					</tr>
					<tr>
						<td>クレジット番号<br> 半角数字
						</td>
						<td><input type="text" name="creditNumber" />
							<div class="example">例）4111111111111112</div></td>
					</tr>
					<tr>
						<td>カード名義</td>
						<td><input type="text" name="nameE" /></td>
					</tr>
					<tr>
						<td>カード期限</td>
						<td><select id="month" name="expirationMonth">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
						</select> 月 <select id="year" name="expirationYear">
								<option value="2017">2017</option>
								<option value="2018">2018</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2023">2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
						</select> 年 <br>
							<div id="dateError"></div></td>
					</tr>
					<tr>
						<td>セキュリティーコード</td>
						<td><input type="password" name="securityCode" size="6" />
							<div class="example">例）123</div></td>
					</tr>
				</table>
				<br>
				<br>
				<input type="submit" value="確認画面" id=" CheckCreditInfomation"
					class="btn back" />
			</s:form>

		</div>

	</div>

</body>
</html>