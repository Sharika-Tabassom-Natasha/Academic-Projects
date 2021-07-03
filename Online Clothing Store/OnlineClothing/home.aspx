<%@ Page Title="" Language="C#" MasterPageFile="~/navbar.Master" AutoEventWireup="true" CodeBehind="home.aspx.cs" Inherits="OnlineClothing.home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="navigation" runat="server">

    <div class="DiscountSection">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">

        <ol class="carousel-indicators" id="dot"> 
        </ol>
        <div class="carousel-inner" id="discount">
        </div>
     
        <script>

			var c = "<%=this. discountID%>";
            var idDiscount = c.split('~');
            var a = "<%=this. discountImg%>";
            var imageDiscount = a.split('~');
            var b = "<%=this. discountName%>";           
            var nameDiscount = b.split('~');

            var dots = [createListDiscount(0,'active')];
            for (var i = 1; i < nameDiscount.length; i++) {
                dots[i] = createListDiscount(i, '');
            }
            var myDot = document.getElementById('dot');
            appendchild(myDot, dots);


			var items = [createDivDiscount('discountImage', imageDiscount[0], 'active', nameDiscount[0], "product.aspx?discount=" + idDiscount[0])];

            for (var j = 1; j < imageDiscount.length; j++) {
                items[j] = createDivDiscount('discountImage',imageDiscount[j], '',nameDiscount[j],"product.aspx?discount=" + idDiscount[j]);
            }
            var myDiv = document.getElementById('discount');
            appendchild(myDiv, items);
        </script>

    </div>
</div>

<div class="container trendingSection">
    <h3>Now Trending</h3>
    <h4>From the runway to your wardrobe</h4>
    <div class="row" id="trending">
        </div>

            <script>

             var b = "<%=this. trendingID%>";
             var idTrending = b.split('~');
             var c = "<%=this. trendingImg%>";
             var imageTrending = c.split('~');
             var d = "<%=this. trendingName%>";
             var nameTrending = d.split('~');

				var itemTrending = [""];


             for (var j = 0; j < imageTrending.length; j++) {
				 itemTrending[j] = createDivTrending(idTrending[j],imageTrending[j], nameTrending[j]);
             }

             var myTrending = document.getElementById('trending');
             appendchild(myTrending, itemTrending);
         </script>

</div>


	    <div class="container discoverSection">
        <h3>Discover Now</h3>
			<h4>We curate, You shop</h4>

        <div class="row " id="discover">
			<div class="col-sm-6 <%=this.discoverName%>" style="width:500px; height:400px">
				<a href="productDetail.aspx?id=<%=this.discoverID%>">
				<img src="<%=this.discoverImg%>" style="width:100%;height:100%;"/>
					</a>
			</div>
			<div class="col-sm-6" >
				<div class="row subbDiscover" id="subDiscover"></div>
					<script>

						 var b = "<%=this. discoverChildID%>";
						 var discoverChildID = b.split('~');
						 var c = "<%=this. discoverChildImg%>";
						 var discoverChildImg = c.split('~');
						 var d = "<%=this. discoverChildName%>";
						var discoverChildName = d.split('~');

						console.log("discover");
						console.log(discoverChildImg);

							var itemDiscover = [""];

						for (var j = 0; j < discoverChildID.length; j++) {

							itemDiscover[j] = createDiscoverDiv(discoverChildImg[j], discoverChildName[j], discoverChildID[j]);
							console.log(itemDiscover[j]);
						 }

						 var myDiv = document.getElementById('subDiscover');
						 appendchild(myDiv, itemDiscover);
					 </script>


				</div>	

        </div>   
    </div>


    <div class="container shopForWomen">
        <h3>Shop for Woman</h3>
		<h4>Shop for Woman</h4>
        <div class="row " id="women">

            <script>

                var n = "<%=this.womenName%>";
                var na = n.split('~');

                var items=[""];

                for (var j = 0; j < na.length; j++) {
                    items[j] = createDiv('womenImage',"Images/Product/Category/women" + na[j] +".jpg", na[j] ,"category.aspx?type=women?category="+na[j]);
                }

                var myDiv = document.getElementById('women');
                appendchild(myDiv, items);
            </script>

        </div>   
    </div>

    <div class="container shopForMen">
        <h3>Shop for Man</h3>
		<h4>Shop for Woman</h4>
        <div class="row" id="men">
            <script>

                var n = "<%=this.menName%>";
                var na = n.split('~');

                var items=[""];

                for (var j = 0; j < na.length; j++) {
                    items[j] = createDiv('menImage',"Images/Product/Category/men" + na[j]+".jpg", na[j],"category.aspx?type=men?category="+na[j]);
                }

                var myDiv = document.getElementById('men');
                appendchild(myDiv, items);

            </script>
        </div>   
    </div>

        <div class="container shopForKids">
        <h3>Shop for kid</h3>
			<h4>Shop for Woman</h4>
        <div class="row" id="kids">

            <script>


                var n = "<%=this.kidsName%>";
                var na = n.split('~');

                var items=[""];

                for (var j = 0; j < na.length; j++) {
                    items[j] = createDiv('kidsImage',"Images/Product/Category/kids" + na[j]+".jpg",na[j],"category.aspx?type=kids?category="+na[j]);
                }

                var myDiv = document.getElementById('kids');
                appendchild(myDiv, items);
            </script>
        </div>   
    </div>

</asp:Content>
