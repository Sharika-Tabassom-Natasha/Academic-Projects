using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing.login
{
    public partial class verification : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

		protected void Unnamed_Click(object sender, EventArgs e)
		{

			DatabaseConnection dc = new DatabaseConnection();
			SqlDataReader reader = dc.getReader("Select * from CUSTOMER where email ='" + Request.QueryString["email"] + "'");



			string temp = "";
			while (reader.Read())
			{


				temp = reader["verificationCode"].ToString();
				temp = temp.Trim();

				if (temp.Equals(verificatonText.Text.ToString()))
				{

					changestatus();
					Label1.Text = "Your Email has been verified successfully";
					Response.Redirect("login.aspx");
				}
				else
				{
					Label2.Text = "You have entered invalid activation code";
					Response.Redirect("home.aspx");
				}
			}


			dc.closeConnection();

		}


		private void changestatus()
		{
			SqlConnection con = new SqlConnection("Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True");
			con.Open();
			SqlCommand cmd = new SqlCommand("Update CUSTOMER set verified='true' where email='" + Request.QueryString["Email"] + "'", con);
			cmd.ExecuteNonQuery();

		}
	}
}