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
			<span class="title">老师信息一览表</span>
		</div>
		<div class="main-body">
			<table class="main-table" cellpadding="0" cellspacing="0"
				align="center">
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
							没有任何老师信息，请先添加!
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<t:foot />
	</body>
</html>