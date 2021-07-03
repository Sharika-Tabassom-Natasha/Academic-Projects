using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
    public partial class cart : System.Web.UI.Page

    {

		public List<object> productName = new List<object>();
		public List<object> productImage = new List<object>();
		public List<object> productPrice = new List<object>();
		public List<object> productDiscount = new List<object>();
		public List<object> productDiscountAdd = new List<object>();
		public List<object> productSize = new List<object>();
		public List<object> productCategory = new List<object>();
		public List<object> productType = new List<object>();

		protected string discount,address, checkingSize,sizeMass;
		protected decimal price, p;
		protected int percentage, discountedPrice, checkout;
		bool check = false;
		protected int totalPrice, tax, totalDiscount,final;
		public List<string[]> cookieValues = new List<string[]>();


		protected void Page_Load(object sender, EventArgs e)
        {
			if (Session["user"] != null)
			{
				getCookieValue();

				if(Request.QueryString["id"] != null)
				{
					deleteItem();
				}
				
			}
			else
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Please Login!');", true);
				Response.Redirect("http://localhost:49890/login.aspx");
			}

		}

		void getCookieValue()
		{

			HttpCookieCollection MyCookieCollection = Request.Cookies;
			HttpCookie cookielist = MyCookieCollection.Get("MyListOfCookies");

			if (cookielist == null)
			{
			}
			else
			{
				var value = Request.Cookies["MyListOfCookies"].Value;

				var cookieParts = value.Split('&');
				var cool = Array.Empty<object>();
				
			
				for (var j = 0; j < cookieParts.Length; j++)
				{
					cookieValues.Add(cookieParts[j].Split('='));
				}

				for (var k = 0; k < cookieValues.Count; k++)
				{
					var id = cookieValues[k][0];
					var size = cookieValues[k][1];
					productSize.Add(size);


					DatabaseConnection dbm = new DatabaseConnection();
					SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT WHERE productId='" + id + "';");

					while (reader.Read())
					{
						productImage.Add(reader["image"]);
						productName.Add(reader["productName"]);
						productPrice.Add(reader["price"]);
						price = (decimal)reader["price"];
						discount = reader["discountId"].ToString();
						productCategory.Add(reader["productCategory"]);
						productType.Add(reader["productType"]);

					}

					if (discount != "")
					{
						reader = dbm.getReader("SELECT * FROM Discount WHERE discountId='" + discount + "';");

						while (reader.Read())
						{
							p = (decimal)reader["percentageOff"];
						}
						percentage = (int)p;

						discountedPrice = (int)(price * (p / 100));
						discountedPrice = (int)(price - discountedPrice);
						productDiscount.Add(discountedPrice);
						productDiscountAdd.Add(discountedPrice);
						totalPrice += (int)price;
						totalDiscount += discountedPrice;
					}
					else
					{
						totalPrice += (int)price;
						totalDiscount += (int)price;
						discountedPrice = 0;
						productDiscount.Add(discountedPrice);
						productDiscountAdd.Add(price);
					}

					dbm.closeConnection();

				
				}
				tax = (int)(0.15 * totalDiscount);
				final = tax + totalDiscount + 50;



			}
		}

		public void placeOrder_Click(Object sender, EventArgs e)
		{
			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select address from CUSTOMER where customerId ='"+Session["user"]+"';");

			while (reader.Read())
			{
				address = reader["address"].ToString();				
			}
			dbm.closeConnection();

			if (address == "")
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('You must provide us your address in profile section!');", true);
			}
			else
			{

				dbm = new DatabaseConnection();
				
				for (var k = 0; k < cookieValues.Count; k++)
				{
					reader = dbm.getReader("SELECT "+cookieValues[k][1]+"Size FROM PRODUCT WHERE productId='" + cookieValues[k][0] + "';");
					while (reader.Read())
					{
						checkingSize = reader[0].ToString();
					}

					var myOutput = string.Compare(checkingSize, "1");

					if (myOutput == -1)
					{
						check = true;
						sizeMass = "product "+(k+1)+" in size "+ cookieValues [k][1]+ " is out of stock";
						break;
					}
				}
				dbm.closeConnection();



				dbm = new DatabaseConnection();
			     reader = dbm.getReader("select DISTINCT top 1 checkoutNumber from CustomerProduct where customerId = '" + Session["user"] + "' order by checkoutNumber desc;");

				while (reader.Read())
				{
					checkout = (int)reader["checkoutNumber"];
				}

				dbm.closeConnection();
				checkout+=1;

				SqlConnection con = new SqlConnection("Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True");
				con.Open();
				SqlCommand cmd;

				if (check.Equals(false))
				{
					for (var k = 0; k < cookieValues.Count; k++)
					{
						string size = "";

						if (cookieValues[k][1] == "small")
						{
							size = "S";
						}
						else if (cookieValues[k][1] == "medium")
						{
							size = "M";
						}
						else if (cookieValues[k][1] == "large")
						{
							size = "L";
						}
						else
						{
							size = cookieValues[k][1];
						}


						cmd = new SqlCommand("insert into CustomerProduct values(" + Session["user"] + "," + cookieValues[k][0] + ",'" + DateTime.Now.ToString("yyyy-MM-dd") + "'," + checkout + ",'" + size + "'," + productDiscountAdd[k] + ",1);", con);
						cmd.ExecuteNonQuery();

						cmd = new SqlCommand("UPDATE PRODUCT SET "+ cookieValues[k][1] + "Size = " + cookieValues[k][1]+"Size-1 WHERE productId =" + cookieValues[k][0] + ";", con);
						cmd.ExecuteNonQuery();

						


					}

					con.Close();

					Response.Cookies["MyListOfCookies"].Expires = DateTime.Now.AddDays(-1);
					Session["massage"] = "You have succesfully placed an order!";
					Response.Redirect("OrderDetails.aspx");
				}

				else
				{
					ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('"+ sizeMass + "');", true);
				}

			}
		}


		public void deleteItem()
		{
			var id = Request.QueryString["id"];
			var size = Request.QueryString["size"];

			if(id != "" && size != "")
			{

				Response.Cookies["MyListOfCookies"].Expires = DateTime.Now.AddDays(-1);
				System.Collections.Specialized.NameValueCollection productCookie = new System.Collections.Specialized.NameValueCollection();

				for (var k = 0; k < cookieValues.Count; k++)
				{
					if (id == cookieValues[k][0] && size == cookieValues[k][1])
					{
						
					}
					else {
						productCookie.Add(cookieValues[k][0], cookieValues[k][1]);
					}
				}

				HttpCookie cookielist = new HttpCookie("MyListOfCookies");
				cookielist.Values.Add(productCookie);
				Response.Cookies.Add(cookielist);

				Response.Redirect("cart.aspx");
			}

		}

	}
}