
function mydeleteteacher(tid){
	//alert(tid);
	location.href = "deleteTeacher.do?teachids=" + tid;
}

function myeditteacher(tid){
	location.href = "editTeacher.do?teachid=" + tid;
}


function mymodifycourse(tid){
	location.href = "listteachCourse.do?teacherid=" + tid;
}
