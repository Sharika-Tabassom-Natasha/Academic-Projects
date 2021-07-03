<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="verification.aspx.cs" Inherits="OnlineClothing.login.verification" %>

<!DOCTYPE html>

<link href="../css/verification.css" rel="stylesheet" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">

        <div>A verification code has been sent to your email address. Please enter the code to proceed registration!</div>
        <br />
        <div class="back">
            <div>
            <asp:TextBox runat="server" placeholder="Enter Verification Code" CSSClass="Text" ID="verificatonText"></asp:TextBox>
                </div>
            <div>
            <asp:Button runat="server" OnClick="Unnamed_Click" CSSClass="Button" Text="VERIFY"/>
                </div>
        </div>
        <asp:Label ID="Label1" runat="server"></asp:Label>
        <asp:Label ID="Label2" runat="server"></asp:Label>
    </form>
</body>
</html>
