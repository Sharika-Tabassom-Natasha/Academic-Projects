<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="product.aspx.cs" Inherits="OnlineClothing.product" %>
<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">

    <div class="showLink">
        <a href="home.aspx">Home</a> /
        <a href="category.aspx?Category=<%=category%>"><%=category%></a> /
        <span><%=type%> wear</span>
    </div>


    <div class="container-fluid">
        <h5 style="font-weight:600;margin:10px 0; display: inline">FILTERS</h5>
		<a href="product.aspx?Type=<%=type%>&Category=<%=category%>" id="clear">Clear</a>

        <div class="row" style="border: 2px solid #eeeeee">
            
            <div class="col-sm-2 "style="border-right:2px solid #eeeeee;margin-right:10px;">
                <div class="row filter">

					  <form id="Form" runat="server">
                     <div class="col-12"  style="border-bottom: 2px solid #eeeeee;">
                        <h4>FILTER BY</h4>
                     
                            <!--Experiment checkbox filter-->
                            <div class="form-group" >
                             <asp:RadioButton ID="RadioButton3" runat="server" Text="New Arrival" GroupName="filterby" /> 
                             <br />
                             <asp:RadioButton ID="RadioButton4" runat="server" Text="Product on Sale" GroupName="filterby" /> 
                            </div>
                       <asp:Button ID="Button2" runat="server" CssClass="btn btn-default" BackColor="Black" ForeColor="White" Height="40px" Width="100px" BorderStyle="Groove" Text="Filter" OnClick="Button2_Click"/>
                            
                      
                    </div>


                    <div class="col-12">
                        <h4>PRICE RANGE</h4>
                         <div class="form-group">
                             <asp:RadioButton ID="RadioButton1" runat="server" Text="Higher to Lower" GroupName="price" /> 
                             <br />
                             <asp:RadioButton ID="RadioButton2" runat="server" Text="Lower to Higher" GroupName="price" />  
                        </div>
                      <asp:Button ID="Button1" runat="server" CssClass="btn btn-default" BackColor="Black" ForeColor="White" Width="100px" BorderStyle="Groove" Text="Filter" OnClick="Button1_Click"/>
                    </div>

		        </form>

       

               </div>  
            </div>

            <div class="col-sm-9 product">
                <div class="row" id="showProduct">


					<span></span>
                        <script>

							var b = "<%=this.id%>";
                            var productId = b.split('~');
                            var c = "<%=this.name%>";
                            var productName = c.split('~');
                            var d = "<%=this.image%>";
                            var productImg = d.split('~');
                            var e = "<%=this.price%>";
							var productPrice = e.split('~');

							var type = "<%=this.type%>";
							var category = "<%=this.category%>";

                            var item=[""];

							for (var j = 0; j < productName.length; j++) {

								
								item[j] = createDivProduct(productId[j], "product.aspx?Type="+type+"&Category="+category+"&wishlist="+productId[j], productImg[j], productName[j], "BDT: " + productPrice[j]);
                            } 

                            var showProduct = document.getElementById('showProduct');
                             appendchild(showProduct, item);
                        </script>
                </div>        
            </div>

		  </div>
        </div>

</asp:Content>
