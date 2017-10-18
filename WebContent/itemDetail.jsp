<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/itemDetail.css">
<link rel="stylesheet" href="css/tab.css">

</head>
<body>

	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->

	<div>
		<s:iterator value="displayList">

			<div class="item-imgs">
				<a
					href="<s:url action="ItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>">
					<img class="item-img" src="img/<s:property value="itemImage"/>"
					alt="" />
				</a>
			</div>
			<div class="itemName">
				<h4>
					<s:property value="itemName" />
				</h4>
			</div>
			<div class="itemAuthor">
				<h4>
					<s:property value="author" />
				</h4>
			</div>
			<div class="itemPrice">
				<s:property value="price" />
				<!--<fmt:formatNumber value="${price}" pattern="###,###,###" />-->
			</div>

			<s:form action="GoCartAction">
				<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
				<s:hidden name="price" value="%{price}"></s:hidden>
				<s:hidden name="stock" value="%{stock}"></s:hidden>
				<s:token />
				<input class="goCart-btn" type="submit" value="カートに入れる">
						個数選択：
		<select name="quantities" size="1">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
				</select>

			</s:form>

			<div class="tabs">

				<ul class="tabs__menu">
					<li class="tabs__menu_li"><a href="#tab1">Product
							Information</a></li>
					<li class="tabs__menu_li"><a href="#tab2">comment</a></li>
				</ul>

				<div class="tabs__content">

					<div class="tabs-item" id="tab1">
						<s:property value="itemddd" />
					</div>

					<div class="tabs-item" id="tab2">

						<s:form action="ItemCommentAction" method="get" name="comments"
							onClick="return check()">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<textarea name="comment" class="form-control" rows="5" required
									maxlength="100"></textarea>
							</div>
							<s:hidden name="itemId" value="%{displayList.get(0).getItemId()}" />
							<button type="submit" class="comment-button" id="comentBtn">コメントする</button>
							<s:token />
						</s:form>

						<div class="panel panel-primary" id="commentarea">
							<div class="panel-heading" id="commenttitle">comments</div>
							<s:iterator value="commentttt">
								<ul class="list-group">
									<!--style="text-align: left">-->
									<li class="list-group-item">
										<div style="font-weight: bold">
											<s:property value="userName" />
										</div>
										<div style="word-wrap: break-word;">
											<s:property value="comment" />
										</div>
										<div>
											<s:property value="registrationDate" />
										</div>
									</li>
								</ul>
							</s:iterator>
						</div>

					</div>

				</div>

			</div>

		</s:iterator>
	</div>

	<script src="js/velocity.min.js"></script>
	<script src="js/tabtab.min.js"></script>
	<script>
		$('.tabs').tabtab();
	</script>
</body>
</html>