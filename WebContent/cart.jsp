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
<title>BuyItem画面</title>

</head>
<body>
	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->


	<div id="main">
		<div>
			<s:form action="PaymentAction">
				<s:iterator value="CartList">
					<s:if test="itemName != null">
						<table>
							<tr>
								<td><span>商品名</span></td>
								<td><s:property value="itemName" /><br></td>
							</tr>
							<tr>
								<td><span>値段</span></td>
								<td><s:property value="price" /><span>円</span></td>
							</tr>
							<tr>
								<td><span>購入個数</span></td>
								<td><s:property value="quantities" /><span>個</span>
							</tr>
							<tr>
								<td><span>購入個数追加</span></td>
								<td><select name="quantities">
										<option value="0">変更</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
								</select></td>
							</tr>
							<tr>
								<td><button class="delete_btn" type="submit"
										name="itemDelete" value="<s:property value="itemId" />">商品削除</button>
								</td>
							</tr>
						</table>
					</s:if>
				</s:iterator>
				<div>
					<p>
						<input type="radio" name="pay" value="現金払い" checked="checked">現金払い
						<input type="radio" name="pay" value="クレジットカード払い">クレジットカード払い
					</p>
					<p class="btn-select position1">
						<button class="btn buy" type="submit">購入</button>
					</p>
					<p>
						前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
					</p>
					<p>
						マイぺージは<a href='<s:url action="MyPageAction" />'>こちら</a>
					</p>
				</div>
			</s:form>
			<s:else>
				<div>
					<h1>カートは空です。</h1>
				</div>
			</s:else>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>