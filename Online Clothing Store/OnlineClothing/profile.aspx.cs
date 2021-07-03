using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing.login
{
    public partial class profile : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
		{
			 



			if (Session["user"] != null)
			{
				var logout = Request.QueryString["logout"];

				if (logout == "1")
				{
					Session.Abandon();
					Response.Redirect("http://localhost:49890/login.aspx");
				}


				DatabaseConnection dc = new DatabaseConnection();
				SqlDataReader reader = dc.getReader("Select * from CUSTOMER where customerId='" + Session["user"] + "'");
				while (reader.Read())
				{
					username.Text = reader[2].ToString();
					fullname.Text = reader[1].ToString();
					if (reader[5].ToString() == "")
					{
						phone.Text = "Mobile Number";
					}
					else
					{
						phone.Text = reader[5].ToString();
					}

					if (reader[6].ToString() == "")
					{
						address.Text = "Location";
					}
					else
					{
						address.Text = reader[6].ToString();
					}

					if (reader[4].ToString() == "")
					{
						gender.Text = "Gender";
					}
					else
					{
						gender.Text = reader[4].ToString();
					}



				}

				dc.closeConnection();
			}
			else
			{
				Response.Redirect("http://localhost:49890/login.aspx"); 
			}
		}


	}
}