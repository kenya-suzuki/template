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

	<!-- header -->
	<s:include value="header.jsp" />
	<!-- header end -->

	<div>
		<s:iterator value="displayList">

			<div class="img">
				<a
					href="<s:url action="ItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>">
					<img src="img/<s:property value="itemImage"/>" alt="" />
				</a>
			</div>
			<div class="itemName">
				<s:property value="itemName" />
			</div>
			<div class="itemPrice">
				<fmt:formatNumber value="${price}" pattern="###,###,###" />
			</div>

			<div class="tabs">

				<ul class="tabs__menu">
					<li><a href="#tab1">Product Information</a></li>
					<li><a href="#tab2">comment</a></li>
				</ul>

				<div class="tabs__content">
					<div class="tabs-item" id="tab1">
						<s:property escape="false" value="itemDetail" />
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
							<button type="submit" class="hvr-grow btn btn-success"
								style="margin-top: 10px;" id="comentBtn">コメントする</button>
							<s:token />
						</s:form>

						<div class="panel panel-primary" id="commentarea">
							<div class="panel-heading" id="commenttitle">コメント</div>
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