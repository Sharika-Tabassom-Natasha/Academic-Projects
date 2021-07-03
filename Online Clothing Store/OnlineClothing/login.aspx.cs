using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing.login
{
    public partial class login : System.Web.UI.Page
    {
		protected void Page_Load(object sender, EventArgs e)
		{

		}

		public void Submit_Click(Object sender, EventArgs e)
		{
		
			DatabaseConnection dc = new DatabaseConnection();
			SqlDataReader reader = dc.getReader("Select * from CUSTOMER where email='" + email.Text + "' And verified ='true' And password='" + password.Text + "'");




			while (reader.Read())
			{
				Session["user"] = reader["customerId"];
				if (reader["customerId"] != null)
				{
					Response.Redirect("http://localhost:49890/profile.aspx");
				}
				else if (reader["customerId"] == null)
				{
					ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Login failed try again!');", true);
				}
			}


			if (Session["user"] == null)
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Login failed try again!');", true);
			}



			dc.closeConnection();

		}
	}
}