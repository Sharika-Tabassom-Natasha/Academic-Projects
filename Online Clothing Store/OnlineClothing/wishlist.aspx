<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="wishlist.aspx.cs" Inherits="OnlineClothing.wishlist" %>
<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">

	<style>
    .card{
        width:300px;
        height:345px;
        background:white;
        box-shadow: 5px 10px 8px 10px rgba(0, 0, 0, 0.52);
    }
    #cross{
    
        background-color:darkgray;
        margin-left:275px;
        opacity:0.4;
        position:absolute;
        color:black;
        padding-left:10px;
        padding-right:5px;
        text-decoration:none

    }
    #cross:hover{
        background-color:red;
        opacity:0.4;
    }
    #wishlistImg{
        height:300px;
        width:298px;
    }
    #wishlistImg:hover{
     
    }
    .a{
        text-decoration:none;
    }
    #cart{
        text-decoration:none;
        width:500px;
        background-color:#f75167;
        color:white;
        height:50px;
        margin-left:-1px;
        padding-top:20px;
        padding-left:97px;
        padding-right:97px;
        padding-bottom:20px;
    }
    #cart:hover{
        background-color:black;
    }
</style>
    <div class="showLink">
        <a href="home.aspx">Home</a> /
        <a href="wishlist.aspx">Wishlist</a>
    </div>
    <div class="col-sm-12"><p class="fancy"><span>WISHLIST</span></p></div>
<br />
<br />
<form runat="server">
<div class="row">
    <%if (product.Count.ToString() != "")
        {%>
    <%for (int i = 0; i < product.Count; i++)
    { %>
    <div class="col-md-3" style="margin-left:20px;">
        <div class="card">
        <div><a href="wishlist.aspx?id=<%=product[i].productId%>" id="cross">X</a></div> 
        <div><img src="<%=product[i].images%>" id="wishlistImg"/></div>
        <div style="margin-left:0.35px;"><a href="productDetail.aspx?id=<%=product[i].productId%>" id="cart">Product Details</a></div>
        </div>
    </div>
    <br />
    <br />
    <%}
    }
    else
    { %>
    <div><h1>Wishlist is empty now!</h1></div>

    <%} %>
</div>
<br />
<br />
</form>
    <div class="border" style="margin-bottom:50px;"></div>





</asp:Content>
