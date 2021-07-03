using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;


namespace OnlineClothing
{
	public partial class EmpLogin : System.Web.UI.Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{

		}

		protected void Login_Click(object sender, EventArgs e)
		{
			SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["clothingDatabaseConnectionString"].ConnectionString);
			con.Open();
			SqlCommand cmd = new SqlCommand("select  password ,username from Employee where username=@Email and password=@Password", con);
			cmd.Parameters.AddWithValue("@Email", TextBox1.Text);
			cmd.Parameters.AddWithValue("@Password", TextBox2.Text);

			SqlDataReader sdr = cmd.ExecuteReader();
			if (sdr.Read())
			{


				Label1.Text = "Login successful";
				Response.Redirect("test.aspx");
			}
			else
			{
				Label1.Text = "Incorrect";
			}
			con.Close();
		}
	}
}