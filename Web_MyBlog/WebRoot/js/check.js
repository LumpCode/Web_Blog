$(function() {
	// 验证用户名
	$("#userName").blur(function() {
		var str = $("#userName").val();
		var ret = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
		if (ret.test(str)) {
			$("#uName").html("用户名格式正确").css("color", "black");
		} else {
			$("#uName").html("用户名格式有误").css("color", "red");
		}
	});
	//验证密码
	$("#password").blur(function() {
		var str = $("#password").val();
		var ret = /(\d{6,32})|(\w{6,32})$/;
		if (ret.test(str)) {
			$("#pwsd").html("密码格式正确").css("color", "black");
		} else {
			$("#pwsd").html("密码格式错误").css("color", "red");
		}
	});
	//重复输入密码验证
	$("#repassword").blur(function() {
		var str = $("#repassword").val();
		var rstr = $("#password").val();
		if (rstr!="" && str==rstr) {
			$("#repwsd").html("重复输入密码正确").css("color", "black");
		} else {
			$("#repwsd").html("两次输入的密码不一致").css("color", "red");
		}
	});
	//验证昵称
	$("#nickName").blur(function() {
		var str = $("#nickName").val();
		if (str!="") {
			$("#nName").html("昵称可用").css("color", "black");
		} else {
			$("#nName").html("昵称不能为空").css("color", "red");
		}
	});
	
	//验证邮箱
	$("#email").blur(function() {
		var email = $("#email").val();
		var ret = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+(\.[a-zA-Z]{2,3})+$/;
		if (ret.test(email)) {
			$("#email_1").html("邮箱格式正确!").css("color", "black");
		} else {
			$("#email_1").html("邮箱格式有误!").css("color", "red");
		}
	});
	
});