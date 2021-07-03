<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="OnlineClothing.login.login" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html runat="server">
<head>
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->

	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

	<!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link href="../css/login.css" rel="stylesheet" />


   <!-- Add icon library -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	


</head>
<body>
<div class="container">
		 <a class="navbar-brand" href="home.aspx" >
			 <img src="Images/logologo.png" />
          </a>

	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Log In</h3>
			</div>
			<div class="card-body">
				<form runat="server" asp-action="register" asp-controller="Form">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<asp:TextBox runat="server" CssClass="form-control" ID="email" placeholder="Email"></asp:TextBox>
						

					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<asp:TextBox runat="server" CssClass="form-control" ID="password" placeholder="Password" TextMode="Password"></asp:TextBox>
					</div>
					<div class="form-group">
						
						<asp:Button runat="server" class="btn float-right login_btn" ID="submitbtn" OnClick="Submit_Click" Text="Login"/>
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div>
						  <!-- Add font awesome icons -->
						 <a href="#" class="fa fa-facebook"></a>
						 <a href="#" class="fa fa-twitter"></a>
						  <a href="#" class="fa fa-google"></a>
				</div>
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="http://localhost:49890/register.aspx">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
