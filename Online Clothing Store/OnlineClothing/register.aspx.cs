using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net.Mail;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing.login
{
    public partial class register : System.Web.UI.Page
    {
		static string activationCode;
		protected void Page_Load(object sender, EventArgs e)
		{

		}
		public void Submit_Click(Object sender, EventArgs e)
		{

			SqlConnection con = new SqlConnection("Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True");
			con.Open();

			//Sending Activation Code
			Random random = new Random();
			activationCode = random.Next(1001, 9999).ToString();
			SqlCommand cmd = new SqlCommand("insert into CUSTOMER (customerName,email,password,phone,verificationCode,verified) Values('" + Name.Text + "','" + Email.Text + "','" + Password.Text + "','" + Phone.Text + "','" + activationCode + "' ,'false')", con);
			cmd.ExecuteNonQuery();
			con.Close();
			sendCode();
			Response.Redirect("verification.aspx?email=" + Email.Text);
		}

		private void sendCode()
		{
			SmtpClient smtp = new SmtpClient();
			smtp.Host = "smtp.gmail.com";
			smtp.Port = 587;
			smtp.Credentials = new System.Net.NetworkCredential("onlineclothingstore68@gmail.com", "Onlineclothingstore68!");
			smtp.EnableSsl = true;
			MailMessage msg = new MailMessage();
			msg.Subject = "Activation Code to Verify Email |Address";
			msg.Body = "Dear" + Name.Text + "your activate code is" + activationCode + "\n\n\n Thanks and regards \n Online Clothing Store";
			string toaddress = Email.Text;
			msg.To.Add(toaddress);
			string fromaddress = "Online Clothing Store <onlineclothingstore68@gmail.com>";
			msg.From = new MailAddress(fromaddress);

			try
			{
				smtp.Send(msg);
			}
			catch
			{
				throw;
			}
		}
	}
}