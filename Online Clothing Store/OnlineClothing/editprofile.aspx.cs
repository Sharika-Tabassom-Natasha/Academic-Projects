using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing.login
{
    public partial class editprofile : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
			DatabaseConnection dc = new DatabaseConnection();
			SqlDataReader reader = dc.getReader("Select * from CUSTOMER where customerId=" + Session["user"]);

			while (reader.Read())
			{
				username.Text = reader["email"].ToString();
				pwd.Text = reader["password"].ToString();
			}
			dc.closeConnection();
		}


		protected void Cancel_Click(object sender, EventArgs e)
		{
			Response.Redirect("profile.aspx");

		}


		protected void Confirm_Click(object sender, EventArgs e)
		{
			string gender = "";


			if (male.Checked)
			{
				gender = "Male";
			}
			if (female.Checked)
			{
				gender = "Female";
			}

			Label2.Text = num.Text;
			SqlConnection con = new SqlConnection("Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True");
			con.Open();
			if (fullname.Text != "")
			{
				SqlCommand cmd = new SqlCommand("Update CUSTOMER set customerName='" + fullname.Text + "' where customerID=" + Session["user"] + "", con);
				cmd.ExecuteNonQuery();
			}
			if (num.Text != "")
			{
				SqlCommand cmd = new SqlCommand("Update CUSTOMER set phone='" + num.Text + "' where customerID=" + Session["user"] + "", con);
				cmd.ExecuteNonQuery();
			}
			if (loc.Text != "")
			{
				SqlCommand cmd = new SqlCommand("Update CUSTOMER set address='" + loc.Text + "' where customerID=" + Session["user"] + "", con);
				cmd.ExecuteNonQuery();
			}
			if (male.Checked)
			{
				SqlCommand cmd = new SqlCommand("Update CUSTOMER set gender='Male' where customerID=" + Session["user"] + "", con);
				cmd.ExecuteNonQuery();
			}
			if (female.Checked)
			{
				SqlCommand cmd = new SqlCommand("Update CUSTOMER set gender='Female' where customerID=" + Session["user"] + "", con);
				cmd.ExecuteNonQuery();
			}


			con.Close();

			Response.Redirect("profile.aspx");
		}
	}
}