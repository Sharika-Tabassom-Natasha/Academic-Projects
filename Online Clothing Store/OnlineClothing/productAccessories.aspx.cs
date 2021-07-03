using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
	public partial class productAccessories : System.Web.UI.Page
	{

		public string name, image, price, id, wishlistid;

		protected void Button1_Click(object sender, EventArgs e)
		{



			if (RadioButton1.Checked)
			{

				Session["filter"] = 1;
				if (Session["filter"].ToString() == "1")
				{
					showProductbyPrice1();
				}
			}
			else if (RadioButton2.Checked)
			{
				Session["filter"] = 2;
				if (Session["filter"].ToString() == "2")
				{
					showProductbyPrice2();
				}
			}


		}



		protected void Button2_Click(object sender, EventArgs e)
		{

			Session["filter"] = null;
			if (RadioButton3.Checked)
			{

				Session["filter"] = 3;
				if (Session["filter"].ToString() == "3")
				{
					showProductNewArrival();
				}
			}
			else if (RadioButton4.Checked)
			{


				Session["filter"] = 4;
				if (Session["filter"].ToString() == "4")
				{
					showProductSale();
				}
			}


		}


		protected void Button3_Click(object sender, EventArgs e)
		{


			if (RadioButton5.Checked)
			{
				Session["filter"] = 5;
				showMale();
			}
			else if (RadioButton6.Checked)
			{
				Session["filter"] = 6;
				showFemale();
			}

			else if (RadioButton7.Checked)
			{
				Session["filter"] = 7;
				showKids();
			}

		}

		protected void Page_Load(object sender, EventArgs e)
		{

			showProduct();
			wishlistid = Request.QueryString["wishlist"];
			if (wishlistid != null)
			{
				addtoWishlist();
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


		private void showProduct()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT where productType like 'accessories';");

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





		private void showProductbyPrice1()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where  productType like 'accessories' order by price asc");

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





		private void showProductbyPrice2()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productType like 'accessories' order by price desc");

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



		private void showProductNewArrival()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select top 20 * from product where productType like 'accessories' order by date desc");

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


		private void showProductSale()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productType like 'accessories' And discountId is not null");

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

		private void showMale()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productType like 'accessories' And productCategory like 'Men'");

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


		private void showFemale()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productType like 'accessories' And productCategory like 'Women'");

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

		private void showKids()
		{

			List<object> productId = new List<object>();
			List<object> productName = new List<object>();
			List<object> productImage = new List<object>();
			List<object> productPrice = new List<object>();


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select * from product where productType like 'accessories' And productCategory like 'Kids'");

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