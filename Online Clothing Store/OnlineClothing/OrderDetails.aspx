<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="OrderDetails.aspx.cs" Inherits="OnlineClothing.OrderDetails" %>

<asp:Content ID="Content3" ContentPlaceHolderID="navigation" runat="server">

	 <br />
    <br />
    <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Order Number</th>
      <th scope="col">Order Date</th>
      <th scope="col">Product Name</th>
      <th scope="col">Size</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Delivery Status</th>
    </tr>
  </thead>
  <tbody>

      <%if (order.Count >= 1)
		  {
			  for (int i = 0; i < order.Count; i++)
			  {%>
				<tr>
				  <th scope="row"><%=order[i].ordernum%></th>
				  <td><%=order[i].date%></td>
				  <td><%=order[i].name%></td>
				  <td><%=order[i].size%></td>
				  <td><%=order[i].quantity%></td>
				  <td><%=order[i].price %></td>
				  <td><%=order[i].status%></td>
				</tr>
			<%}
		}%>
  </tbody>
</table>

    <div class="gap" style="margin-bottom:200px;"></div>
	<script>
		var massage = "<%=Session["massage"]%>";

		if (massage != "") {
			<%Session["massage"] = "";%> 
			alert(massage);
		}

	</script>


</asp:Content>
