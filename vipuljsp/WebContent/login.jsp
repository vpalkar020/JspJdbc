<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'><link rel="stylesheet" href="./style.css">
	<script>
	function validateForm(){
		var x=document.forms['SignupForm']['unamesignup'].value;
		if(x==""){
			alert("Name must be filled");
			return false;
		}
		
	}
	</script>

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		
		<div class="login-form">
		<form action="abc" name="SigninForm">
			<div class="sign-in-htm">
			
				<div class="group">
					<label for="user" class="label">Username</label>
					
					<input id="user" type="text" class="input" name="unamesignin">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" class="input" data-type="password" name="passsignin">
				</div>
				
				<div class="group">
					<input id="check" type="checkbox" class="check" checked>
					<label for="check"><span class="icon"></span> Keep me Signed in</label>
				</div>
				<div class="group">
					<input type="submit" class="button" value="SignIn" name="SignInName">
				</div>
				
				<div class="hr"></div>
				<div class="foot-lnk">
					<a href="#forgot">Forgot Password?</a>
				</div>
			</div>
			</form>
			<form action="abc" name="SignupForm" onsubmit="return validateForm()">
			<div class="sign-up-htm">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input id="user" type="text" class="input" name="unamesignup">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" name="passsignup" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">Repeat Password</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">Mobile No.</label>
					<input id="pass" type="text" class="input" name="mob">
				</div>
				<div class="group">
					<input type="submit" class="button" value="SignUp" name="SignUpName">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
					<label for="tab-1">Already Member?</label>
				</div>
				
			</div>
			</form>
		</div>
		
	</div>
</div>
</body>
</html>