<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="productDetail.aspx.cs" Inherits="OnlineClothing.productDetail" %>
<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="asp" %>
<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">

	<form id="Room" runat="server">


	<div class="showLink">
        <a href="home.aspx">Home</a> /
        <a href="category.aspx?Category=<%=this.category%>"><%=this.category%></a> /
		<a href="product.aspx?Type=<%=this.type%>&Category=<%=this.category%>"><%=this.type%> WEAR</a> /
        <span> <%=this.name %></span>
    </div>

		<div class="container prductDetail">
			<div class="row">

				<div class="col-md-6 productDetailsImage">
					<img src="<%=this.image %>" />
				</div>

				<div class="col-md-6 ">
					<div class="row productDetailsInfo">

						<div class="col-sm-12 NAME">
							
							<div class="ratting"> 

								<asp:Label Text="Rating" runat="server" style="font-weight:bold"/>

								<ajaxToolkit:Rating ID="Rating1" runat="server" AutoPostBack="true"
									StarCssClass="Star" WaitingStarCssClass="WaitingStar" EmptyStarCssClass="Star"
									FilledStarCssClass="FilledStar">
								</ajaxToolkit:Rating>
								<asp:ScriptManager ID="ScriptManager1" runat="server">
								</asp:ScriptManager>

							</div>

							<h3><%=this.name %></h3>
							<div><%=this.category %> <%=this.type %> wear</div>
						</div>

						<div class="col-sm-12 PRICE">

							<span style="font-size:22px">Price: </span><span runat="server" id="discountSpan"><%=this.discountedPrice%> BDT</span> 
							<span runat="server" id="priceSpan"><%=this.price%> BDT</span> 
							<span runat="server" id="percentageSpan">(<%=this.percentage%> % OFF) </span>
							
							<p style="font-size:12px; font-weight:100;">Additional tax shall apply, charged at checkout</p>
						</div>

						


						<div class="col-sm-12 SIZE" id="SIZE">
							<div style="font-size:22px">Select Size: </div>
							 
							<div class="form">

								<div class="plan" id="sizeButton">

									<div class="col colhover1" id="colhover1">
										<asp:RadioButton ID="RadioButtonSMALL" Text="S" GroupName="radioSize" runat="server" />
										
									</div>

									<div class="col colhover2" id="colhover2">		
										<asp:RadioButton ID="RadioButtonMEDIUM" Text="M" GroupName="radioSize" runat="server" />
									</div>

									<div class="col colhover3" id="colhover3">
										<asp:RadioButton ID="RadioButtonLARGE" Text="L" GroupName="radioSize" runat="server" />
									</div>

									<div class="col colhover4" id="colhover4">
										<asp:RadioButton ID="RadioButtonXL" Text="XL" GroupName="radioSize" runat="server" />
									</div>

									<div class="col colhover5" id="colhover5">										
										<asp:RadioButton ID="RadioButtonXXL" Text="XXL" GroupName="radioSize" runat="server" />
									</div>

									<script>

										var SMALL = "<%=this.small%>";
										var MEDIUM ="<%=this.medium%>";
										var LARGE = "<%=this.large%>";
										var XL = "<%=this.xl%>";
										var XXL = "<%=this.xxl%>";
										var count=0;

										if (SMALL == "")
										{
											document.getElementById("colhover1").remove();
											count++;
										}
										if (MEDIUM == "")
										{
											document.getElementById("colhover2").remove();
											count++;
										}
										if (LARGE == "")
										{
											document.getElementById("colhover3").remove();
											count++;
										}
										if (XL == "")
										{
											document.getElementById("colhover4").remove();
											count++;
										}
										if (XXL == "")
										{
											document.getElementById("colhover5").remove();
											count++;
										}

										if (count == 5) {
											document.getElementById("SIZE").remove();
										}
		
										</script>

								</div>
							</div>   
						</div>

						
						<div class="col-sm-12 BUTTON">

							<asp:Button ID="cart" class="btn btn-outline-dark btn-lg" style="width: 200px;" OnClick="cart_Click" Text="Add to Cart" runat="server" />
							<asp:Button ID="wishlist" class="btn btn-dark btn-lg" OnClick="wishlist_Click" Text="Wishlist" runat="server" />

							<div style="margin-top:10px;">
							  <asp:Button ID="Button1" class="btn btn-outline-dark btn-lg" style="width: 200px;" OnClick="trialRoom_Click" Text="Trial Room"  runat="server" />
							</div>

						</div>


						<script>
							var massage = "<%=Session["massage"]%>";

							if (massage != "") {
								<%Session["massage"] = "";%> 
								alert(massage);
							}

						</script>


						<div class="col-sm-12 COMMENT">

							<div style="font-size:22px; margin-top:10px">Review: </div>

							<asp:TextBox ID="t3" CssClass="inputt"  runat="server" /> <br />
							<asp:Button ID="b1"  class="btn btn-dark btn-lg" Text="Add Comment" OnClick="b1_Click1" runat="server" />

						</div>


					</div>

				</div>


			</div>
		</div>


		<div class="container">
			<h3>Reviews</h3>
			<div class="row rateSection">

				<%for (var i = 0; i < rating.Count; i++)
					{
						;%>


							<div class="col-12">

							<%for (var j = 0; j < rating[i]; j++)
								{ %>
									<i class="	fa fa-star"></i>
							<%}

							for (var k = 0; k < (5 -  rating[i]); k++)
							{%>

								<i class="	fa fa-star-o"></i>

							<%} %>



					</div>
					<div class="col-12"> <%=this.review[i]%> </div>

				<%} %>

			</div>

		</div>

	</form>



</asp:Content>
