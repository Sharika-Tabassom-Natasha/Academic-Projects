using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
	public partial class OrderDetails : System.Web.UI.Page
	{
		
		public List<CustomerProduct> order = new List<CustomerProduct>();

		protected void Page_Load(object sender, EventArgs e)
		{
			
			if (Session["user"] != null)
			{
				showOrderDetails();
			}
			else
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Please Login!');", true);
				Response.Redirect("http://localhost:49890/login.aspx");
			}
		}


		private void showOrderDetails()
		{
			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("Select * from CustomerProduct where customerID=" + Session["user"] + "");



			double price = 0;
			string status;

			while (reader.Read())
			{
				CustomerProduct p = new CustomerProduct();
				p.ordernum = Convert.ToInt32(reader["checkoutNumber"]);
				p.orderid = Convert.ToInt32(reader["customerproductid"]);
				if (p.orderid >= 1)
				{
					DatabaseConnection dbm3 = new DatabaseConnection();
					SqlDataReader reader3 = dbm.getReader("Select * from delivery where deliverid=" + p.orderid + "");

					while (reader3.Read())
					{
						status = reader3["track"].ToString();
						if (status == "True")
						{
							p.status = "Your order has been delivered";
						}
						else
						{
							p.status = "Your order is on its way";
						}
					}
				}
				p.productid = Convert.ToInt32(reader["productid"]);
				if (p.productid >= 1)
				{

					DatabaseConnection dbm2 = new DatabaseConnection();
					SqlDataReader reader2 = dbm.getReader("Select * from product where productid=" + p.productid + "");

					while (reader2.Read())
					{
						p.name = reader2["productName"].ToString();
						price = Convert.ToDouble(reader2["price"].ToString());
					}
				}
				p.date = reader["date"].ToString();
				p.quantity = Convert.ToInt32(reader["quantity"].ToString());
				p.size = reader["size"].ToString();
				if (p.quantity > 1)
				{
					p.price = price * p.quantity;
				}
				else
				{
					p.price = price;
				}
				order.Add(p);
			}
			dbm.closeConnection();

		}
	}


}