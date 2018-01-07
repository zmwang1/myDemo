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
			<span class="title">课程信息一览表</span>
		</div>
		<div class="main-body">
			<table class="main-table" cellpadding="0" cellspacing="0"
				align="center">
				<tr class="title">
					<td>课程号</td>
					<td>课程名</td>
				</tr>
				<c:forEach items="${courselist}" var="course">
						<tr>							
							<td>
								<c:out value="${course.courseId}"></c:out>
							</td>
							<td>
								<c:out value="${course.courseName}" />
							</td>
						</tr>
					</c:forEach>

				<c:if test="${empty courselist}">
					<tr>
						<td colspan=8>
							没有任何课程信息，请先添加!
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<t:foot />
	</body>
</html>