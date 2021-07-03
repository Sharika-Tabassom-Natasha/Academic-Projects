
/*------------------------ Home page java script ------------------------*/

/* discount *//* trend *//* shop for */
function createImage(id, text) {
	var img = document.createElement('img');
	img.src = text;
	img.id = id;
	return img;
}


/* shop for */ /* discount */
function createTitle(text,link) {

	var a = document.createElement('a');
	a.textContent = text;
	a.href = link;
	return a;
}

function createTitleDiv(text,link) {

	var div = document.createElement('div');
	div.className = "titleDiv";
	div.appendChild(createTitle(text,link));
	return div;
}



/* shop for */
function createDiv(imageId, image, name, link) {
	var div = document.createElement('div');
	div.className = "col-lg-4 col-md-6 ";
	div.appendChild(createImage(imageId, image));
	div.appendChild(createTitleDiv(name,link));
	return div;

}

/* Discover Now */

function createDiscoverDiv(image, name, id) {
	var div = document.createElement('div');
	div.className = "col-sm-12 " + name;

	var div2 = document.createElement('div');
	div2.className = "row";

	var subdiv1 = document.createElement('div');
	subdiv1.className = "col-sm-7 imagee";
	var subdiv2 = document.createElement('div');
	subdiv2.className = "col-sm-4";

	var subname = document.createElement('h3');
	subname.textContent = name;
	var subname1 = document.createElement('h5');
	subname1.textContent = "Wear you time";

	var a = document.createElement('a');
	a.href = "productDetail.aspx?id=" + id;
	var a2 = document.createElement('a');
	a2.href = "productDetail.aspx?id=" + id;

	a.appendChild(createImage("", image));
	subdiv1.appendChild(a);

	a2.appendChild(subname);
	a2.appendChild(subname1);
	subdiv2.appendChild(a2)
	div2.appendChild(subdiv1);
	div2.appendChild(subdiv2);
	div.appendChild(div2);

	return div;

}


/* trend */
function createDivTrending(id, image, name) {

	var div = document.createElement('div');
	div.className = "col-sm-6 col-md-4 col-lg-3 mx-auto hovereffect " + name;

	var innerdiv = document.createElement('div');
	innerdiv.className = "overlay";

	var a = document.createElement('a');
	a.className = "info";
	a.textContent = name;
	a.href = "productDetail.aspx?id=" + id;

	innerdiv.appendChild(a);
	div.appendChild(createImage("", image));
	div.appendChild(innerdiv);
	return div;
}


/* discount */
function createListDiscount(number, text) {
	var li = document.createElement('li');
	li.dataset.target = "#myCarousel";
	li.dataset.slideTo = number;
	li.className = text;
	return li;
}




/* discount */

function captionDiscount(name,link) {

	var div = document.createElement('div');
	div.className = "carousel-caption ";
	div.appendChild(createTitle(name,link));
	return div;

	/* discount */
}
function createDivDiscount(imageId, image, text, name,link) {
	var div = document.createElement('div');
	div.className = "carousel-item " + text + " DISCOUNT";
	div.appendChild(createImage(imageId, image));
	div.appendChild(captionDiscount(name,link));
	return div;
}


/*-------------------- Product page java Script---------------------------*/


//show product

function hoverDiv(id,link,image) {

	var hover = document.createElement('div');
	hover.className = "mydivouter";

	hover.appendChild(createImage("productt", image));

	var cart = document.createElement('a');
	cart.className = "mybuttonoverlap cartDesign";
	cart.href = "productDetail.aspx?id=" + id;
	cart.textContent = "CART";


	var wishlist = document.createElement('a');
	wishlist.className = "mybuttonoverlap wishlistDesign";
	wishlist.href = link;
	wishlist.textContent = "WISHLIST";


	hover.appendChild(cart);
	hover.appendChild(wishlist);

	return hover;

}

function createDivSubProduct(name, price) {

	var div = document.createElement('div');
	div.className = "productTitle";
	var h = document.createElement('div');
	var p = document.createElement('div');

	h.textContent = name;
	p.textContent = price;

	div.appendChild(h);
	div.appendChild(p);

	return div;
}

function createDivProduct(id, link, image, name, price) {

	var div = document.createElement('div');
	div.className = "col-sm-6 col-md-4 col-lg-3";

	var a = document.createElement('a');
	a.href = "productDetail.aspx?id=" + id;
	a.appendChild(hoverDiv(id, link,image));
	a.appendChild(createDivSubProduct(name, price));
	div.appendChild(a);

	return div;
}


/*----------------------------- Category page ----------------------------------*/

function createDivCategoryPage(image, category, name,link) {
	var div = document.createElement('div');
	div.className = "col-sm-6 col-md-4";

	var heading = document.createElement('h3');
	heading.textContent = name;
	var buttonBody = document.createElement('p');
	var button = document.createElement('a');
	button.href = "product.aspx?Type=" + name + "&Category=" + category;
	button.textContent = "Shop Now";

	buttonBody.appendChild(button);
	div.appendChild(createImage("category", image));
	div.appendChild(heading);
	div.appendChild(buttonBody);

	return div;
}


/*------------------- Parent function -------------------*/

function appendchild(parent, children) {

	children.forEach(function (child) {
		parent.appendChild(child);
	});

}


