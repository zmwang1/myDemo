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
					<input type="hidden" name="studentid" value="${studentid}"/>
					<tr class="title">
						<td></td>
						<td>课程号</td>
						<td>课程名</td>
						<td>课程老师</td>
						<td>老师电话</td>
						<td>老师邮箱</td>
					</tr>
					<c:forEach items="${stuCoulist}" var="stuCou">
						<tr>							
							<td>
								<input type=checkbox id="${stuCou.id}"
									value="${stuCou.id}">
							</td>
							<td>
								<c:out value="${stuCou.teacCou.course.courseId}"></c:out>
							</td>
							<td>
								<c:out value="${stuCou.teacCou.course.courseName}" />
							</td>
							<td>
								<c:out value="${stuCou.teacCou.teacher.name}" />
							</td>
							<td>
								<c:out value="${stuCou.teacCou.teacher.phone}" />
							</td>
							<td>
								<c:out value="${stuCou.teacCou.teacher.email}" />
							</td>
						</tr>
					</c:forEach>

					<c:if test="${empty stuCoulist}">
						<tr>
							<td colspan=9>
								网上选课还没开始，请先等候!
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan=9 class="ctrl-button">
							<input type=button name="allcheck" value="全选"
								onclick="checkall(courseForm);" />
							<input type=button name="allnotcheck" value="全不选"
								onclick="uncheckall(courseForm);" />
							<input type=button name="addgrade" value="取消选课选课"
								onclick="deletecoursetostudent(courseForm);" />
						</td>
					</tr>
				</table>
				<input type=hidden name="courseids" value="">
			</form>
			</div>
			<t:foot />
		</body>
</html>