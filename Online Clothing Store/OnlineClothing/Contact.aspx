<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="OnlineClothing.Contact" %>

<asp:Content ID="Content3" ContentPlaceHolderID="navigation" runat="server">

	<link href="css/contactus.css" rel="stylesheet" />
	<form id="form1" runat="server">

        <div>
            <div class="container">
                <div class="social">
                    
                </div>
                <div class="content">
                    <h2 style="color:white; font-size:50px;">Contact us</h2>
              
                    <asp:TextBox ID="name" placeholder="Name" runat="server" CssClass="name"></asp:TextBox><br />
                    <asp:TextBox ID="mail" placeholder="Email" runat="server" CssClass="mail"></asp:TextBox><br />
                    <asp:TextBox ID="msg"  placeholder="Message" runat="server" CssClass="msg" Rows="5"></asp:TextBox><br />
                    <asp:Button ID="send" runat="server" OnClick="send_Click" Text="Send" CssClass="btn" />
					<asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:clothingDatabaseConnectionString %>" SelectCommand="SELECT * FROM [ContactUs]"></asp:SqlDataSource>
					<br />
                    <asp:Label ID="status" Font-Size="Medium" ForeColor="Red" runat="server" CssClass="status"></asp:Label>

                    

                </div>
            </div>
        </div>
    </form>




</asp:Content>
