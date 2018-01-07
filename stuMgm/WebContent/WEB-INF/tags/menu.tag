<%@tag pageEncoding="utf-8" body-content="empty"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
<!--
body,ul,li{
	margin:0;padding:0;
	}
ul,li{
	list-style:none;
	}

.menu>ul{
	width:780px;
	height:28px;
	background-color:white;
}
.menu ul li{
	float:left;
	height:28px;
	line-height:28px;
	}
.menu ul li a{
	text-decoration:none;
	display:block;
	text-align:center;
	}
.menu ul li a:hover{
	color:blue;
	}
.menu ul .add{
	width:70px;
}
.menu ul>li .list{
	background-color:green;
	position:absolute;
	display:none;
	}
.menu ul li .list li{
	float:none;
	}
.menu ul li:hover ul{
	display:block;
	}
.one{
	width:60px;
}
.two{
	width:120px;
}
-->
</style>
<div class="top">
	<div class="logo"></div>
	<div class="welcome">
		<span style="color: green">欢迎 <span
			style="color: red; font-weight: bold">${user.username}</span>使用大学学籍管理系统
		</span>
	</div>
	<div class="menu">
		<c:if test="${empty user}">
			<ul>
				<li><a class="menu-link" href="#">学籍管理首页 |</a></li>
				<!-- <li class="add"><a class="menu-link" href="#">添加 |</a>
					<ul class="list">
						<li><a class="menu-link" href="#">添加学生</a></li>
						<li><a class="menu-link" href="#">添加老师</a></li>
						<li><a class="menu-link" href="#">添加课程</a></li>
					</ul>
				</li>
				<li><a class="menu-link" href="#">基本信息管理 |</a>
					<ul class="list">
						<li><a class="menu-link" href="#">学生信息管理</a></li>
						<li><a class="menu-link" href="#">老师信息管理</a></li>
						<li><a class="menu-link" href="#">课程管理</a></li>
					</ul>
				</li>
				<li class="one"><a class="menu-link" href="#">一览表 |</a>
					<ul class="list">
						<li><a class="menu-link" href="#">学生一览表</a></li>
						<li><a class="menu-link" href="#">老师一览表</a></li>
						<li><a class="menu-link" href="#">课程一览表</a></li>
					</ul>
				</li>
				<li class="two"><a class="menu-link" href="#">基本信息查询 |</a>
					<ul class="list">
						<li><a class="menu-link" href="#">学生基本信息查询</a></li>
						<li><a class="menu-link" href="#">老师基本信息查询</a></li>
						<li><a class="menu-link" href="#">课程基本信息查询</a></li>
					</ul>				
				</li>
				<li><a class="menu-link" href="#">学生成绩管理|</a></li>
				<li><a class="menu-link" href="#">学生成绩一览表 |</a></li>
				<li><a class="menu-link" href="#">学生成绩查询</a></li>
				<li><a class="menu-link" href="#">| 登录系统</a>
					<ul class="list">
						<li><a class="menu-link" href="login.do">用户登录</a></li>
						<li><a class="menu-link" href="studentlogin.do">学生登录</a></li>
					</ul>	
				</li> -->
				<li><a class="menu-link" href="studentlogin.do">学生登录入口</a></li>
				<!-- <li><a class="menu-link" href="studentlogin.do">学生登录入口</a></li> -->
			</ul>
			
		</c:if>
		<c:if test="${not empty user}">
		    <c:if test="${not empty isuser && isuser}">
			<ul>
				<li><a class="menu-link" href="login.do">学籍管理首页 |</a></li>
				<li class="one"><a class="menu-link" href="#">一览表 |</a>
					<ul class="list">
						<li><a class="menu-link" href="studentList.do">学生一览表</a></li>
						<li><a class="menu-link" href="teacherList.do">老师一览表</a></li>
						<li><a class="menu-link" href="courseList.do">课程一览表</a></li>
					</ul>
				</li>
				<li class="two"><a class="menu-link" href="#">基本信息查询 |</a>
					<ul class="list">
						<li><a class="menu-link" href="studentSearchall.do">学生基本信息查询</a></li>
						<li><a class="menu-link" href="teacherSearch.do">老师基本信息查询</a></li>
						<li><a class="menu-link" href="courseSearch.do">课程基本信息查询</a></li>
					</ul>	
				</li>
				<c:if test="${not empty isAdmin && isAdmin}">
					<li><a class="menu-link" href="gradeAdmin.do">学生成绩管理|</a></li>
				</c:if>
				<li><a class="menu-link" href="gradeList.do">学生成绩一览表 |</a></li>
				<li><a class="menu-link" href="gradeSearch.do">学生成绩查询 |</a></li>
								<c:if test="${not empty isAdmin && isAdmin}">
					<li class="add"><a class="menu-link" href="#">学生 |</a>
						<ul class="list">
						    <li><a class="menu-link" href="studentAdmin.do">学生列表</a></li>
							<li><a class="menu-link" href="addStudent.do">添加学生</a></li>
						</ul>
					</li>
										
					<li><a class="menu-link" href="#">老师  |</a>
						<ul class="list">
							<li><a class="menu-link" href="teacherAdmin.do">老师列表</a></li>
							<li><a class="menu-link" href="addTeacher.do">添加老师</a></li>
						</ul>
					</li>
					
					<li><a class="menu-link" href="#"> 课程   </a>
						<ul class="list">
							<li><a class="menu-link" href="courseAdmin.do">课程列表</a></li>
							<li><a class="menu-link" href="addCourse.do">添加课程</a></li>
						</ul>
					</li>
				</c:if> 
				<li><a class="menu-link" href="javascript:exit();">| 退出系统</a></li>
			</ul>
			</c:if>
			    <c:if test="${not empty isstudent && isstudent}">
				<ul>
					<li class="two"><a class="menu-link" href="studentCourse.do?studentid=${user.getStuNumber()}">选课&nbsp;</a>
					</li>
					<li><a class="menu-link" href="gradestuList.do?studentid=${user.getStuNumber()}">成绩查看</a></li>
					<li><a class="menu-link" href="javascript:exit();">&nbsp; 退出系统</a></li>
				</ul>
				</c:if>
			</c:if>
	</div>
</div>


<script language="javascript">
	function exit() {
		alert("欢迎你下次继续登录本网站！");
		location.href = "logout.do?rnd=" + new Date().getTime();
	}
</script>