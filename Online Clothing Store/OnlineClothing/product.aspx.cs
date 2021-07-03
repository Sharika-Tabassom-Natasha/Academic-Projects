using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
    public partial class product : System.Web.UI.Page
    {

		protected string category, type;
		public string name, image, price, id, wishlistid,discountid;


		protected void Button1_Click(object sender, EventArgs e)
		{

			if (RadioButton1.Checked)
			{

				Session["filter"] = 1;
				if (Session["filter"].ToString() == "1")
				{
					showProductbyPrice2(category, type);
				}
			}
			else if (RadioButton2.Checked)
			{
				Session["filter"] = 2;
				if (Session["filter"].ToString() == "2")
				{
					showProductbyPrice1(category, type);
				}
			}


		}



		protected void Button2_Click(object sender, EventArgs e)
		{


			if (RadioButton3.Checked)
			{
				Session["filter"] = 3;
				if (Session["filter"].ToString() == "3")
				{
					showProductNewArrival(category, type);
				}
			}
			else if (RadioButton4.Checked)
			{
				Session["filter"] = 4;
				if (Session["filter"].ToString() == "4")
				{
					showProductSale(category, type);
				}

			}


		}

		protected void Page_Load(object sender, EventArgs e)
		{
			category = Request.QueryString["Category"];
			type = Request.QueryString["Type"];
			wishlistid = Request.QueryString["wishlist"];
			discountid = Request.QueryString["discount"];
			if (wishlistid != null)
			{
				addtoWishlist();
			}

			if (Request.QueryString["search"] != null)
			{
				showSearchProduct();
			}
			else
			{
				showProduct(category, type, discountid);
			}

		}


		private void addtoWishlist()
		{
			List<object> t = new List<object>();

			if (wishlistid != "")
			{
				DatabaseConnection dbm = new DatabaseConnection();
				SqlDataReader reader = dbm.getReader("SELECT * FROM wishlist WHERE productId='" + wishlistid + "' And customerId=" + Session["user"] + ";");
				while (reader.Read())
				{
					t.Add(reader["productId"]);
				}

				if (t.Count == 0)
				{
					int temp = Convert.ToInt32(wishlistid);
					string query = "insert into wishlist Values(" + temp + "," + Session["user"] + ")";

					DatabaseConnection dbm2 = new DatabaseConnection();
					SqlCommand cmd = new SqlCommand(query, dbm2.getConnection());
					cmd.ExecuteNonQuery();
					dbm2.closeConnection();
					ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Added to Wishlist!');", true);
				}
				else
				{
					ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('This item already exist in your Wishlist!');", true);
				}
			}
		}

		private string ArrayListToString(List<object> list)
		{
			int intCount;
			string strFinal = "";

			for (intCount = 0; intCount <= list.Count - 1; intCount++)
			{
				if (intCount > 0)
				{
					strFinal += "~";
				}

				strFinal += list[intCount].ToString();
			}

			return strFinal;
		}


		private void showProduct(string category, string type, string discount)
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();

			DatabaseConnection dbm = new DatabaseConnection();
			if (discountid == null)

			{
				
				SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT WHERE productCategory='" + category + "' AND productType='" + type + "';");

				while (reader.Read())
				{
					productId.Add(reader["productId"]);
					productName.Add(reader["productName"]);
					productImage.Add(reader["image"]);
					productPrice.Add(reader["price"]);
				}

			}
			else
			{

				SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT WHERE discountId='" + discountid + "';");

				while (reader.Read())
				{
					productId.Add(reader["productId"]);
					productName.Add(reader["productName"]);
					productImage.Add(reader["image"]);
					productPrice.Add(reader["price"]);
				}

			}

			dbm.closeConnection();

			id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);



		}


		private void showSearchProduct()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();

			var search = Request.QueryString["search"];

			DatabaseConnection dbm = new DatabaseConnection();

			SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT WHERE productName like'%"+search +"%';");

			while (reader.Read())
				{
					productId.Add(reader["productId"]);
					productName.Add(reader["productName"]);
					productImage.Add(reader["image"]);
					productPrice.Add(reader["price"]);
				}

			

			dbm.closeConnection();

			id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);



		}


		private void showProductbyPrice1(string category, string type)
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productCategory like '" + category + "' And productType like '" + type + "' order by price");

			while (reader.Read())
			{
				productId.Add(reader["productId"]);
				productName.Add(reader["productName"]);
				productImage.Add(reader["image"]);
				productPrice.Add(reader["price"]);
			}

			dbm.closeConnection();

			//id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);

		}


		private void showProductbyPrice2(string category, string type)
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productCategory like '" + category + "' And productType like '" + type + "' order by price desc");

			while (reader.Read())
			{
				productId.Add(reader["productId"]);
				productName.Add(reader["productName"]);
				productImage.Add(reader["image"]);
				productPrice.Add(reader["price"]);
			}

			dbm.closeConnection();

			//id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);

		}



		private void showProductNewArrival(string category, string type)
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select top 20 * from product where productCategory like '" + category + "' And productType like '" + type + "' order by date desc");

			while (reader.Read())
			{
				productId.Add(reader["productId"]);
				productName.Add(reader["productName"]);
				productImage.Add(reader["image"]);
				productPrice.Add(reader["price"]);
			}

			dbm.closeConnection();

			//id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);

		}


		private void showProductSale(string category, string type)
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productCategory like '" + category + "' And productType like '" + type + "' And discountId is not null");

			while (reader.Read())
			{
				productId.Add(reader["productId"]);
				productName.Add(reader["productName"]);
				productImage.Add(reader["image"]);
				productPrice.Add(reader["price"]);
			}

			dbm.closeConnection();

			//id = ArrayListToString(productId);
			name = ArrayListToString(productName);
			image = ArrayListToString(productImage);
			price = ArrayListToString(productPrice);

		}

	}
}