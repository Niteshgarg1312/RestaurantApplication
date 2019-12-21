<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V16</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<script type="text/javascript">
 function validate()
 {   
	 //alert("function is working ppoperly");
	 var pwd=document.getElementById("pwd").value;
	 var cpwd=document.getElementById("cpwd").value;
	 if(pwd==cpwd)
		 {  return true;
		 }
	 else
		 {
		 alert("plse enter password and confirm password equal");
		 return false;
		 }
	 
 }
</script>

<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Please Set Your New Password!!
				</span>
				
				<form class="login100-form validate-form p-b-33 p-t-5" name="form" action="changePassword" onSubmit="return validate()" method="post">
				
				<input type="hidden" id="key" name="key" value="${k }"/>    
                <input type="hidden" id="emailid" name="emailid" value="${emailid }"/>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password"  id="pwd" name="password" placeholder="PASSWORD" required autofocus>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter Confirm password">
						<input class="input100" type="password" id="cpwd" name="confirmpassword" placeholder="CONFIRM PASSWORD" required autofocus>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" type="submit">
							Change Password
						</button>
					</div>
					<span class="login100-form-title p-b-41">
					</span>
				</form>		
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>