function checkall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			cbxoption[i].checked = true;
		}
	}
}
function uncheckall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			cbxoption[i].checked = false;
		}
	}
}
function deletecourse(form) {
	var courseids;
	var cbxoption;
	var m = 0;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					courseids = cbxoption[i].id;
				else
					courseids += "," + cbxoption[i].id;
			}
		}

		form.courseids.value = courseids;
	}
	if (m == 0) {
		alert("你没有选中需要删除的课程，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的课程信息删除?")){
	   	  	return; 
	   }
	}
	
	location.href = "deleteCourse.do?courseids=" + courseids;
}

function editcourse(form) {
	var cbxoption, courseid;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m > 1) {
					alert("一次只能修改一个课程的信息，请重选！");
					return;
				}
				courseid = cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要修改的课程，请重选！");
		return;
	}

	location.href = "editCourse.do?courseid=" + courseid;
}
function modifycourse(form) {
	var teacherid;
	teacherid=form.teacherid.value;
	//alert("教工号"+teacherid);
	location.href = "addteachCourse.do?teacherid=" + teacherid+"&flag=add";
}

function addcoursetoteacher(form) {
	var cbxoption, courseids,teacherid;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					courseids = cbxoption[i].id;
				else
					courseids += "," + cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要添加的课程，请重选！");
		return;
	}
	teacherid=form.teacherid.value;
	//alert("teacherid"+teacherid);
	//alert("courseids"+courseids);
	location.href = "addCourseToTeacher.do?courseids=" + courseids+"&teacherid="+teacherid;
}

function deleteteachercourse(form) {
	var courseids,teacherid;
	var cbxoption;
	var m = 0;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					courseids = cbxoption[i].id;
				else
					courseids += "," + cbxoption[i].id;
			}
		}

		form.courseids.value = courseids;
	}
	if (m == 0) {
		alert("你没有选中需要删除的课程，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的课程信息删除?")){
	   	  	return; 
	   }
	}
	teacherid=form.teacherid.value;
	location.href = "deleteCourseToTeacher.do?courseids=" + courseids+"&teacherid="+teacherid;
}

function addcoursetostudent(form) {
	var cbxoption, TeacCouids,studentid;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					TeacCouids = cbxoption[i].id;
				else
					TeacCouids += "," + cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要选修的课程，请重选！");
		return;
	}
	studentid=form.studentid.value;
	//alert("studentid"+studentid);
	//alert("TeacCouids"+TeacCouids);
	location.href = "addCourseToStudent.do?TeacCouids="+TeacCouids+"&studentid="+studentid;
}
function deletecoursetostudent(form) {
	var cbxoption, stuCouids,studentid;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					stuCouids = cbxoption[i].id;
				else
					stuCouids += "," + cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要取消的课程，请重选！");
		return;
	}
	studentid=form.studentid.value;
	//alert("studentid"+studentid);
	//alert("TeacCouids"+stuCouids);
	location.href = "deleteCourseToStudent.do?stuCouids="+stuCouids+"&studentid="+studentid;
}