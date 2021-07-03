using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
	public partial class Contact : System.Web.UI.Page
	{
		SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["clothingDatabaseConnectionString"].ConnectionString);


		protected void Page_Load(object sender, EventArgs e)
		{
			con.Open();
		}

		protected void send_Click(object sender, EventArgs e)
		{
			SqlCommand cmd = new SqlCommand("insert into ContactUs values('" + name.Text + "','" + mail.Text + "','" + msg.Text + "')", con);
			cmd.ExecuteNonQuery();
			con.Close();
			status.Visible = true;
			status.Text = "Message was sent successfully";
			name.Text = "";
			mail.Text = "";
			msg.Text = "";

		}
	}
}
