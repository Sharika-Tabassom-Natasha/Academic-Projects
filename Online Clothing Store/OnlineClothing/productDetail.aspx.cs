using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using AjaxControlToolkit;

namespace OnlineClothing
{
	public partial class productDetail : System.Web.UI.Page
	{
		protected List<int> rating = new List<int>();
		protected List<object> review = new List<object>();
		protected string getId, name, category, type, image, small, medium, large, xl, xxl, discount, front,side,back,icon;
		protected decimal price, p;
		protected int percentage, discountedPrice;
		protected string size="not";
		bool check = false;

		DataTable dt = new DataTable();
		string ConnectionString = (@"Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True");




		protected void Page_Load(object sender, EventArgs e)
		{
			getId = Request.QueryString["id"];
			showProductDetails();

			if (!IsPostBack)
			{

				DataTable dt = this.GetData("SELECT COUNT(Rating) RatingCount FROM ProductReview");
				Rating1.CurrentRating = Convert.ToInt32(dt.Rows[0]["RatingCount"]);
				Rating1.CurrentRating = 0;

			}
		}

		private void showProductDetails()
		{
			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT * FROM PRODUCT WHERE productId='" + getId + "';");

			while (reader.Read())
			{

				name = reader["productName"].ToString();
				image = reader["image"].ToString();
				price = (decimal)reader["price"];

				small = reader["smallSize"].ToString();
				medium = reader["mediumSize"].ToString();
				large = reader["largeSize"].ToString();
				xl = reader["xlSize"].ToString();
				xxl = reader["xxlSize"].ToString();

				discount = reader["discountId"].ToString();

				category = reader["productCategory"].ToString();
				type = reader["productType"].ToString();
				front = reader["trialFront"].ToString();
				side = reader["trialSide"].ToString();
				back = reader["trialBack"].ToString();
				icon = reader["icon"].ToString();
			}


			if (discount != "")
			{
				reader = dbm.getReader("SELECT * FROM Discount WHERE discountId='" + discount + "';");

				while (reader.Read())
				{
					p = (decimal)reader["percentageOff"];
				}
				percentage = (int)p;

				discountedPrice = (int)(price * (p / 100));
				discountedPrice = (int)(price - discountedPrice);
				discountSpan.Visible = true;

				priceSpan.Style.Add("text-decoration", "line-through");
				priceSpan.Style.Add("color", "grey");
				priceSpan.Style.Add("font-weight", "100");
				percentageSpan.Visible = true;
				percentageSpan.Style.Add("color", "#d84b6b");
			}
			else
			{
				discountSpan.Visible = false;
				percentageSpan.Visible = false;
			}

			dbm = new DatabaseConnection();
			reader = dbm.getReader("select * from ProductReview where productId ='"+ getId +"'");

			while (reader.Read())
			{
				rating.Add(Convert.ToInt32(reader["rating"]));
				review.Add(reader["review"]);
			}

			dbm.closeConnection();

		}


		private DataTable GetData(string query)
		{
			SqlConnection con = new SqlConnection(ConnectionString);
			SqlCommand sqlcomm = new SqlCommand(query);
			SqlDataAdapter sda = new SqlDataAdapter();
			sqlcomm.CommandType = CommandType.Text;
			sqlcomm.Connection = con;
			sda.SelectCommand = sqlcomm;
			sda.Fill(dt);
			return dt;
		}

		protected void b1_Click1(object sender, EventArgs e)
		{
			if (Session["user"] != null)
			{
				SqlConnection sqlconn = new SqlConnection(ConnectionString);
				SqlCommand sqlcomm = new SqlCommand("Insert into ProductReview Values(@customerId,@productId,@rating,@review)", sqlconn);
				sqlcomm.Parameters.AddWithValue("@rating", Rating1.CurrentRating.ToString());
				sqlcomm.Parameters.AddWithValue("@customerId", Session["user"]);
				sqlcomm.Parameters.AddWithValue("@productId", getId);
				sqlcomm.Parameters.AddWithValue("@review", t3.Text);
				SqlDataAdapter sda = new SqlDataAdapter();
				sqlcomm.CommandType = CommandType.Text;

				sqlconn.Open();
				sqlcomm.ExecuteNonQuery();
				sqlconn.Close();
				Response.Redirect(Request.Url.AbsoluteUri);
			}
			else
			{
				//ADD WARNING
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Please login!');", true);

			}
		}




		public void checkSize()
		{

			if (RadioButtonSMALL.Checked)
			{				
				size = "small";
			}

			if (RadioButtonMEDIUM.Checked)
			{
				size = "medium";

			}

			if (RadioButtonLARGE.Checked)
			{

				size = "large";

			}

			if (RadioButtonXL.Checked)
			{

				size = "xl";

			}

			if (RadioButtonXXL.Checked)
			{
				size = "xxl";
			}

		}

		public void addItem(){

			System.Collections.Specialized.NameValueCollection productCookie = new System.Collections.Specialized.NameValueCollection();

			productCookie.Add(getId, size);

			HttpCookieCollection MyCookieCollection = Request.Cookies;
			HttpCookie cookielist = MyCookieCollection.Get("MyListOfCookies");
			
			if (cookielist == null)
			{
				cookielist = new HttpCookie("MyListOfCookies");
				cookielist.Values.Add(productCookie);
				Response.Cookies.Add(cookielist);

			}
			else
			{
				var  value = Request.Cookies["MyListOfCookies"].Value;

				var cookieParts = value.Split('&');
				var cool = Array.Empty<object>();
				//List<string> cookieValues = new List<string>();
				List<string[]> cookieValues = new List<string[]>();

				for (var j = 0; j < cookieParts.Length; j++)
				{
					cookieValues.Add(cookieParts[j].Split('='));
				}

				for(var k = 0; k < cookieValues.Count; k++)
				{
					if(getId.Equals(cookieValues[k][0]) && size.Equals(cookieValues[k][1]))
					{
						check = true;
						break;
					}
					else
					{
						check = false;
					}
				}

				if (check.Equals(false))
				{
					cookielist.Values.Add(productCookie);
					Response.Cookies.Add(cookielist);
				}
			}
		}



		public void cart_Click(Object sender, EventArgs e)
		{
			checkSize();
			if (size.Equals("not"))
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Please add a size.');", true);
			}
			else
			{
				addItem();
			}

			if (check.Equals(true))
			{
				Session["massage"] = "Product already added";
			}
			else
			{
				ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('Product Added');", true);
			}
		}


		public void wishlist_Click(Object sender, EventArgs e)
		{
			Response.Redirect("wishlist.aspx");
		}


		public void trialRoom_Click(Object sender, EventArgs e)
		{
			Response.Redirect("http://127.0.0.1:8887/?id=" + getId + "&x=" + front+ "&icon=" + icon + "&y=" + side + "&z=" + back + "");
		}

	}
}