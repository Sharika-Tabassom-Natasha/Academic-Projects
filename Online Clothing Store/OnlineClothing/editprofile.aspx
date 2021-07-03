<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="editprofile.aspx.cs" Inherits="OnlineClothing.login.editprofile" %>

<asp:Content ID="Content1" ContentPlaceHolderID="editprofile" runat="server">
    <link href="../css/editprofile.css" rel="stylesheet" />
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="navigation" runat="server">

    
    <form runat="server">
        
    <div class="card">
    <h2 class="title">Edit Profile</h2>
        <hr />
        <br />
    <div>
    <asp:Label runat="server" CSSClass="epLabel1">Email</asp:Label>
    <asp:Label runat="server" CSSClass="epLabel2" >Password</asp:Label>
    </div>
    <div>
        <asp:Textbox runat="server" CSSClass="epText" ReadOnly="true" ID="username"></asp:Textbox>
        <asp:Textbox runat="server" CSSClass="epText" TextMode="Password" ID="pwd" ReadOnly="true"></asp:Textbox>
    </div>
        <asp:Label runat="server" CSSClass="epLabel1">Full Name</asp:Label>
        <div> <asp:Textbox runat="server" CSSClass="bdText" id="fullname"></asp:Textbox></div>
        <asp:Label runat="server" CSSClass="epLabel1">Mobile Number</asp:Label>

        <div><asp:TextBox runat="server" CssClass="bdText" ID="num"></asp:TextBox></div>

       <asp:Label runat="server" CSSClass="epLabel1">Location</asp:Label>
       <div>  <asp:Textbox runat="server" CSSClass="bdText" ID="loc"></asp:Textbox></div>
        <asp:Label runat="server" CSSClass="epLabel1">Gender</asp:Label>
       <div>  <asp:RadioButton GroupName="Gender" runat="server" Text="Male" CSSClass="bdText" id="male"/>
       <asp:RadioButton GroupName="Gender" runat="server" Text="Female" CSSClass="bdText" ID="female"/></div>
        <br />
        <hr />
        
       <asp:Button runat="server" cssclass="button1" Text="Cancel"/>
       <asp:Button runat="server" cssclass="button2" Text="Confirm" OnClick="Confirm_Click"/>

    </div>
</form>

    <asp:Label runat="server" ID="Label1"></asp:Label>
    <asp:Label runat="server" ID="Label2"></asp:Label>

</asp:Content>
