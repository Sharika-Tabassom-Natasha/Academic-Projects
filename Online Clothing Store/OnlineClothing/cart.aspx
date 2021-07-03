<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="cart.aspx.cs" Inherits="OnlineClothing.cart" %>
<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">


	<form runat="server">
	<div class="container">
		<div class="row">
			<div class="col-md-8" >
				<div class="row">

					<div class="col-md-12" >
						<div class="row">

							<% if (productName.Count != 0)
								{%>
									
									
								<h2 class="col-md-12">My Shopping Bag (<%=this.productImage.Count%> Items)</h2>		

								 <%for (int i = 0; i < productName.Count; i++)
									 {%>

									<div class="col-md-3 cartImg">
										<img src="<%=this.productImage[i]%>" style="height:180px; width:180px" />
									</div>

									<div class="col-md-8 cartItem">
										<h3 class="item" style="text-transform:uppercase;"><%=this.productName[i]%></h3> 
										<div style="float:right">

											<%if (productDiscount[i].Equals(0))
												{%>

												<span ><%=this.productPrice[i]%> BDT</span> 
											<%}
											else
											{%>

												<span ><%=this.productDiscount[i]%> BDT</span> <br />
											    <span style="text-decoration:line-through; color:grey"><%=this.productPrice[i]%> BDT</span> 

											<%} %>


										</div>
										<div class="item"><%=this.productCategory[i]%> <%=this.productType[i]%> wear</div>
										<span class="item">Size: <%=this.productSize[i]%></span> <br />

										
										  <div><a href="cart.aspx?id=<%=cookieValues[i][0]%>&size=<%=cookieValues[i][1]%>" class="btn btn-outline-dark">Remove</a></div> 

									</div>							       

									<%}
								}
								else
								{%>

										
							            <div style="height:300px;margin-left:400px;"><h2>Your Cart is Empty</h2></div>

								<%} %>

						</div>
					</div>
				</div>
			</div>

			
				<% if (productName.Count != 0)
					{%>

					<div class="col-md-3 placeOrder" >
				
						<h4> Price Details</h4>
						<div>Bag Total <span><%=this.totalPrice %></span></div>
						<div>Bag Discount <span>-<%=totalPrice-totalDiscount%></span></div>
						<div>Tax(10%) <span><%=this.tax %></span></div>
						<div>Order Total <span><%=tax+totalDiscount%></span></div>
						<div>Delivery charge <span>50</span></div>
						<h4 style="border-top:1px dotted grey; padding-top:10px">Total <span><%=this.final %></span></h4>
						<asp:Button Text="PLACE ORDER" class="btn btn-dark btn-lg" style="margin-top:10px;" OnClick="placeOrder_Click" runat="server" />

					</div>

					<%}
					else
					{%>				

					<%} %>

			</div>
		</div>
	</form>

</asp:Content>
