<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="register.aspx.cs" Inherits="OnlineClothing.login.register" %>

<!DOCTYPE html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head runat="server">


	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" 
	  integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title></title>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

	<!--Custom styles-->
	<link href="../css/register.css" rel="stylesheet" />

</head>
<body>


<div class="row justify-content-center">
<div class="col-md-6">
<div class="card">
<header class="card-header">
	<h4 class="card-title mt-2" style="color:white">Sign Up</h4>
</header>
	<div class="border-top card-body">
<article class="card-body">
<form runat="server" asp-action="register" asp-controller="Form">
	<div class="form-row">
		<div class="col form-group">
			<label style="color:white">Name</label>
			<asp:Textbox runat="server" CssClass="form-control" ID="Name" AutoCompleteType="DisplayName"></asp:Textbox>
				<asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
	 Text="Required"
	 ControlToValidate="Name"
	 CssClass="ValidationError"
	 ToolTip="Compare Password is a REQUIRED field">
	</asp:RequiredFieldValidator>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->







	<div class="form-group">
		<label style="color:white">Email address</label>
		 <asp:Textbox runat="server" CssClass="form-control" ID="Email" AutoCompleteType="Email" TextMode="Email" OnClientClick="return ValidateRegForm()"></asp:Textbox>
		<script lang="javascript" type="text/javascript">
		function ValidateRegForm() {
		var email = document.getElementById("<%=Email.ClientID%>");
		var filter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
			if (!filter.test(email.value)) {

			document.getElementById("emailConfirm").innerHTML = "Email format incorrect";
			email.focus;
			return false;
		}
			return true;
			 document.getElementById("emailConfirm").innerHTML = "Email format correct";
	}
</script>
		<asp:Label runat="server" ID="emailConfirm" TextColor="white"></asp:Label>
			<asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
	 Text="Required"
	 ControlToValidate="Email"
	 CssClass="ValidationError"
	 ToolTip="Compare Password is a REQUIRED field">
	</asp:RequiredFieldValidator>

	</div> <!-- form-group end.// -->



        	<div class="form-row">
		<div class="col form-group">
			<label style="color:white">Phone Number</label>
			<asp:Textbox runat="server" CssClass="form-control" ID="Phone"></asp:Textbox>
				<asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
	 Text="Required"
	 ControlToValidate="Phone"
	 CssClass="ValidationError"
	 ToolTip="Compare Password is a REQUIRED field">
	</asp:RequiredFieldValidator>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->

   
	<div class="form-group">
		<label style="color:white">Create password</label>
		<br />
		<asp:Label runat="server" CssClass="instruction" >Password must contain Upper Case Lower Case Number and Special Characters</asp:Label>
		<asp:Textbox runat="server" CssClass="form-control" ID="Password" TextMode="Password" onKeyUp="CheckPasswordStrength()" ClientMode="Static" ></asp:Textbox>
	<script type="text/javascript">
	function CheckPasswordStrength() {
		var passwordTextbox = document.getElementById("Password");
		var password = passwordTextbox.value;
		var specialCharacters = "!@#$%^&*_+";
		var passwordScore = 0; 

		for (var i = 0; i < password.length; i++)
		{
			if(specialCharacters.indexOf(password.charAt(i) > -1))
			{
				passwordScore += 20;
			}
		}

		if (/[a-z]/.test(password))
		{
			passwordScore += 20;
		}

		if (/[A-Z]/.test(password)) {
			passwordScore += 20;
		}

		if (password.length >= 8) {
			passwordScore += 20;
		}

		if (/[\d]/.test(password)) {
			passwordScore += 20;
		}

		var strength = "";
		var backgroundColor = "";

		if (passwordScore >= 100)
		{
			strength = "Strong"
			backgroundColor ="green";
		}

		else if (passwordScore >= 80)
		{
			strength = "Medium"
			backgroundColor = "blue";
		}

		else if (passwordScore >= 60) {
			strength = "Weak"
			backgroundColor = "red";
		}

		var passwordLabel = document.getElementById("PasswordStrngth");
		document.getElementById("PasswordStrngth").innerHTML = strength;
		passwordTextbox.style.color = "black";
		passwordTextbox.style.borderColor = backgroundColor;
		passwordLabel.style.color = backgroundColor;
	}
</script>
		
	<asp:Label runat="server" ID="PasswordStrngth"></asp:Label>
	<asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
	 Text="Required"
	 ControlToValidate="Password"
	 CssClass="ValidationError"
	 ToolTip="Compare Password is a REQUIRED field">
	</asp:RequiredFieldValidator>



	<!-- confirm passsword -->
	<br />
	<label style="color:white">Confirm password</label>
	<asp:TextBox ID="ConfirmPass" runat="server" TextMode="Password" CssClass="form-control"></asp:TextBox>
	 <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
	 Text="Compare Password is a REQUIRED field!"  
	 ControlToValidate="ConfirmPass"
	 CssClass="ValidationError"
	 ToolTip="Compare Name is a REQUIRED field">
	</asp:RequiredFieldValidator>

  
	<asp:CompareValidator ID="CompareValidator1" runat="server" 
	 ControlToValidate="ConfirmPass"
	 CssClass="ValidationError"
	 ControlToCompare="Password"
	 ErrorMessage="No Match" 
	 Text="Confirmation Failed"
	 ToolTip="Password must be the same" />



</div> <!-- form-group end.// -->
 <div class="form-group">
 <asp:Button runat="server" CssClass="btn btn-primary btn-block"  OnClick="Submit_Click" Text="Sign Up"/>
</div> <!-- form-group// -->
<small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>
</form>
</article> <!-- card-body end .// -->
		</div>
<div class="border-top card-body text-center" style="color:white">Have an account? <a href="http://localhost:49890/login.aspx">Log In</a></div>
</div> <!-- card.// -->
</div> <!-- col.//-->

</div> <!-- row.//-->
</body>

	</html>
