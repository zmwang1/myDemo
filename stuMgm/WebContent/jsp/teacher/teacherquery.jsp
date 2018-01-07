<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<link rel="stylesheet" href="html/css/editStudent.css"
			type="text/css"></link>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">学生信息查询</span>
		</div>
		<div class="main-body">
			<form name="teacherForm" method="POST" action="teacherSearchquery.do">
				<table class="main-table" cellpadding="0" cellspacing="0"
					align="center">
					<tr class="search-line">
						<td align="left" colspan="8">
							<font size=2>请输入需要查询的老师的教工号、姓名、电话、电子邮箱或信息中的任何关键字：
							<input type="text" name="querystring"> </font>
							<input type="submit" name="querybtn" value="查 询">
						</td>
					</tr>
					<tr class="title">
							<td>教工号</td>
							<td>姓名</td>
							<td>性别</td>					
							<td>电话</td>
							<td>电子邮件</td>
					</tr>
					<c:forEach items="${teacherlist}" var="teacher">
					<tr>
						<td>
							<c:out value="${teacher.id}"></c:out>
						</td>
						<td>
							<c:out value="${teacher.name}" />
						</td>
						<td>
							<c:if test="${teacher.gender eq '1'}">男</c:if>
							<c:if test="${teacher.gender eq '0'}">女</c:if>
						</td>
						<td>
							<c:out value="${teacher.phone}" />
						</td>
						<td>
							<c:out value="${teacher.email}" />
						</td>
					</tr>
					</c:forEach>
					<c:if test="${empty teacherlist}">
						<tr>
							<td colspan=8>
								<span class="error">没有任何老师信息!</span>
							</td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
		<t:foot />
	</body>
</html>