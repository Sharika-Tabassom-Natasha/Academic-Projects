using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
    public partial class wishlist : System.Web.UI.Page
    {
		public List<ProductClass> product = new List<ProductClass>();


		string id;

		protected void Page_Load(object sender, EventArgs e)
		{

			if (Session["user"] != null)
			{
				showProduct();
			}
			else
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Please Login!');", true);
				Response.Redirect("home.aspx");
			}
			
		}


		private void showProduct()
		{
			if (Session["user"] != null)
			{



				id = Request.QueryString["id"];
				if (id != "")
				{
					int temp = Convert.ToInt32(id);
					string query = "delete from wishlist where productid=" + temp + " And customerid= " + Session["user"] + "";

					DatabaseConnection dbm2 = new DatabaseConnection();
					SqlCommand cmd = new SqlCommand(query, dbm2.getConnection());
					cmd.ExecuteNonQuery();
					dbm2.closeConnection();

				}


				DatabaseConnection dbm = new DatabaseConnection();
				SqlDataReader reader = dbm.getReader("Select * from product where productId in (SELECT productId from wishlist where customerId=" + Session["user"] + ");");

				while (reader.Read())
				{
					ProductClass p = new ProductClass();
					p.productId = Convert.ToInt32(reader["productId"]);
					p.images = reader["image"].ToString();
					product.Add(p);
				}

				dbm.closeConnection();
			}


			else
			{
				Response.Redirect("login.aspx");
			}
		}

	}
}