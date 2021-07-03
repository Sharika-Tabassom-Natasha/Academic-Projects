<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="profile.aspx.cs" Inherits="OnlineClothing.login.profile" %>

<asp:Content ID="Content1" ContentPlaceHolderID="profile" runat="server">
    <link href="../css/profile.css" rel="stylesheet" />
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="navigation" runat="server">


<div class="row" id="table1">
    <div class="col s12 m7">
     <a href="OrderDetails.aspx">
         <div class="card">
        <div class="card-image">
          <span class="card-title">Orders</span>
        </div>
          <hr>
        <div class="card-content">
          <p class="card-writing" style="text-align:center">Check your Order Status</p>
        </div>
        <div class="card-action">
        </div>
      </div>
           </a>
    </div>

  </div>


    <div class="row" id="table2">
    <div class="col s12 m7">
   <a href="wishlist.aspx" ><div class="card">
        <div class="card-image">
          <span class="card-title" style="text-align:center">Wishlist</span>
        </div>
          <hr>
        <div class="card-content">
          <p class="card-writing" style="text-align:center">All your curated Product Contents</p>
        </div>
        <div class="card-action">
        </div>
      </div></a>
    </div>
  </div>

    <div class="row" id="table3">
    <div class="col s12 m7">
      <a href="cart.aspx"><div class="card">
        <div class="card-image">
          <span class="card-title" style="text-align:center">Cart</span>
        </div>
          <hr>
        <div class="card-content">
          <p class="card-writing" style="text-align:center">Manage all Cart Contents</p>
        </div>
        <div class="card-action">
        </div>
      </div></a>
    </div>
  </div>
        

     <div class="row" id="table4">
    <div class="col s12 m7">
      <a href="blogHome.aspx"><div class="card">
        <div class="card-image">
          <span class="card-title" style="text-align:center">Blog</span>
        </div>
          <hr>
        <div class="card-content">
          <p class="card-writing" style="text-align:center">Manage blog post</p>
        </div>
        <div class="card-action">
        </div>
      </div></a>
    </div>
  </div>
         
    
<!-- Side navigation -->
<div class="sidenav">
    <div class="ikon">
  <asp:Label runat="server" CssClass="label" ID="username">User Name</asp:Label>
  </div>
  <div class="ikon">
  <asp:Label runat="server" CssClass="label" ID="fullname">Name</asp:Label>
  </div>
  <div class="ikon">
  <asp:Label runat="server" CssClass="label" ID="gender">Gender</asp:Label>
  </div>
  <div class="ikon">
  <asp:Label runat="server" CssClass="label" ID="phone">Phone</asp:Label>
      </div>
  <div class="ikon">
  <asp:Label runat="server" CssClass="label" ID="address">Address</asp:Label>
</div>
 

<a href="http://localhost:49890/editprofile.aspx"><button type="button" class="btn btn-default" id="editButton">Edit</button></a>  
    
</div>
	
	<a href="profile.aspx?logout=1" class="btn btn-dark" id="logButton">Logout</a>

</asp:Content>
