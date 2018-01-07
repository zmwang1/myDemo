function validateTeacherForm(){
	var form = document.teacherForm;
	if (form["teacher.id"].value.trim() == "") {
		alert("请输入教工号.");
		form["teacher.id"].focus();
		return false;
	}
	if (form["teacher.name"].value.trim() == "") {
		alert("请输入老师姓名.");
		form["teacher.name"].focus();
		return false;
	}	
	if ((form["teacher.phone"].value.trim() != "") && !isValidNumber(form["teacher.phone"].value)) {
		alert("电话号码错，只能输入数字，区号中间可用-分隔，不能少于７位，也可以用手机号码.");
		form["teacher.phone"].focus();
		return false;
	}
	if ((form["teacher.email"].value.trim() != "") && !form["teacher.email"].value.match( /^.+@.+$/ ) ) {
		alert("Email 错误！请重新输入");
		form["teacher.email"].focus();
		return false;
	}
	return true;
}