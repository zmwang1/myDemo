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
			<form name="courseForm" method="POST" action="courseSearchquery.do">
				<table class="main-table" cellpadding="0" cellspacing="0"
					align="center">
					<tr class="search-line">
						<td align="left" colspan="8">
							<font size=2>请输入需要查询的课程号或课程名关键字：
							<input type="text" name="querystring"> </font>
							<input type="submit" name="querybtn" value="查 询">
						</td>
					</tr>
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
								<span class="error">没有任何课程信息!</span>
							</td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
		<t:foot />
	</body>
</html>