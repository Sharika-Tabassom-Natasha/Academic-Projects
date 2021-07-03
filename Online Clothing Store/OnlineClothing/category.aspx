<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="category.aspx.cs" Inherits="OnlineClothing.category" %>

<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">

	<div class="container-fluid categoryPage">
		<div class="row">

			<div class="col-sm-12" id="image">
				<script>

					var name = "<%=this. categoryName%>";
					var img = document.createElement('img');	

					if (name == "women") {
						img.src = "Images/Product/WOMEN.jpg";
					}

					else if (name == "men") {
					    img.src = "Images/Product/MEN.jpg";
					}

					else if (name == "kids") {
					    img.src = "Images/Product/KIDS.jpg";				
					}

					var myImage = document.getElementById('image');
					myImage.appendChild(img);

				</script>

			</div>

			<div class="col-sm-12">
				<div class="row" id="discount">

				<script>
					      var n = "<%=this.discountID%>";
						  var id = n.split('~');
						  var n = "<%=this.discountName%>";
						  var na = n.split('~');

						  var items=[""];

					for (var j = 0; j < na.length; j++) {
						var divdiv = document.createElement('div');
						divdiv.className = "col-sm-5 mx-auto discountDiv";
						divdiv.textContent = "SALE";
						var div = document.createElement('a');
						div.href = "product.aspx?discount="+id[j];
						div.textContent = na[j];
						divdiv.appendChild(div);
							 items[j] =divdiv;
					 }

						  var myDiv = document.getElementById('discount');
						  appendchild(myDiv, items);
					</script>

					</div>
			</div>


			<div class="col-sm-12">

				<div class="row categoryDiv" id="categoryBody">
					<div class="col-sm-12"><p class="fancy"><span>YOUR CLOSET-SSENTIALS</span></p></div>
					
					 <script>

						  var n = "<%=this.Name%>";
						  var na = n.split('~');
						 var name = "<%=this. categoryName%>";

						 console.log(na);
						  var items=[""];

						 for (var j = 0; j < na.length; j++) {
							 items[j] = createDivCategoryPage("Images/Product/Category/" +name+ na[j] + ".jpg",name, na[j]);
						 }

						  var myDiv = document.getElementById('categoryBody');
						  appendchild(myDiv, items);
					</script>

				</div>

			</div>

		</div>

	</div>

</asp:Content>

