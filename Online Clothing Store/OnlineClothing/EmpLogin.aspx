<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EmpLogin.aspx.cs" Inherits="OnlineClothing.EmpLogin" %>

<!DOCTYPE html>


<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
    <link href="css/loginStyle.css" rel="stylesheet" />
</head>
<body>
    <form id="form2" runat="server">
       <section>
           <img src="Images/emp.jpg" class="panel" /><asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:clothingDatabaseConnectionString %>" SelectCommand="SELECT * FROM [Employee]"></asp:SqlDataSource>
&nbsp;</section>
        <div class="sec2">
            <div class="container">
                <div class="social">
                    
                </div>
                <div class="content">

                    <h2>Login</h2>
                    <asp:TextBox ID="TextBox1" placeholder="Email" runat="server"></asp:TextBox><br />
                    <asp:TextBox ID="TextBox2" placeholder="Password" TextMode="Password" runat="server"></asp:TextBox><br />
                    <asp:Button ID="Login" runat="server" OnClick="Login_Click" Text="Login" /><br />
                    <asp:Label ID="Label1" Style ="padding-left:4vw;color:red;padding-top:2vw;" Font-Size="Medium" ForeColor="White" runat="server" Text=""></asp:Label>

                </div>
               
            </div>
        </div>
    </form>
    
</body>
</html>
