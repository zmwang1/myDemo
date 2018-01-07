<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageCourse.js"></script>
		<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">课程信息管理</span>
		</div>
		<div class="main-body">
			<form name="courseForm" method="POST">
				<table  class="main-table" cellpadding="0" cellspacing="0" align="center">
					<input type="hidden" name="teacherid" value="${teacherid }"/>
					<tr class="title">
						<td></td>
						<td>课程号</td>
						<td>课程名</td>
					</tr>
					<c:forEach items="${courselist}" var="course">
						<tr>							
							<td>
								<input type=checkbox id="${course.courseId}"
									value="${course.courseId}">
							</td>
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
							<td colspan=9>
								没有任何课程信息，请先添加!
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan=3 class="ctrl-button">
							<input type=button name="allcheck" value="全选"
								onclick="checkall(courseForm);" />
							<input type=button name="allnotcheck" value="全不选"
								onclick="uncheckall(courseForm);" />
							<input type=button name="delete" value="添加"
								onclick="addcoursetoteacher(courseForm);" />
						</td>
					</tr>
				</table>
				<input type=hidden name="courseids" value="">
			</form>
			</div>
			<t:foot />
		</body>
</html>