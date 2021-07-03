using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OnlineClothing
{
	public partial class home : System.Web.UI.Page
	{
		public string discountID,discountImg, discountName;
		public string trendingID, trendingImg, trendingName;
		public string discoverID, discoverImg, discoverName, color, discoverChildID, discoverChildImg, discoverChildName;
		public string womenImg, menImg, kidsImg, womenName, menName, kidsName;

		protected void Page_Load(object sender, EventArgs e)
		{


			discount();
			trending();
			discover();
			shopFor("women");
			shopFor("men");
			shopFor("kids");
		}

		private string ArrayListToString(ref ArrayList _ArrayList)
		{
			int intCount;
			string strFinal = "";

			for (intCount = 0; intCount <= _ArrayList.Count - 1; intCount++)
			{
				if (intCount > 0)
				{
					strFinal += "~";
				}

				strFinal += _ArrayList[intCount].ToString();
			}

			return strFinal;
		}

		private void discount()
		{
			ArrayList productID = new ArrayList();
			ArrayList productName = new ArrayList();
			ArrayList productImage = new ArrayList();

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT * FROM Discount;");

			while (reader.Read())
			{
				productID.Add(reader["discountID"]);
				productImage.Add(reader["discountImage"]);
				productName.Add(reader["discountName"]);
			}
			dbm.closeConnection();

			discountID = ArrayListToString(ref productID);
			discountImg = ArrayListToString(ref productImage);
			discountName = ArrayListToString(ref productName);
		}



		private void trending()
		{
			ArrayList productId = new ArrayList();
			ArrayList productName = new ArrayList();
			ArrayList productImage = new ArrayList();

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("select productId,image,productName from PRODUCT where productId IN (select top 4 productid from CustomerProduct  group by productId order by COUNT(productId) dESC );  ");

			while (reader.Read())
			{
				productId.Add(reader["productId"]);
				productImage.Add(reader["image"]);
				productName.Add(reader["productName"]);
			}
			dbm.closeConnection();

			trendingID = ArrayListToString(ref productId);
			trendingImg = ArrayListToString(ref productImage);
			trendingName = ArrayListToString(ref productName);
		}

		private void discover()
		{

			string[] category = { "men", "women", "kids" };
			Random random = new Random();
			int index = random.Next(0, category.Length);


			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT productId,productName,image,productColor from PRODUCT where productCategory = '" + category[index] + "' and productType != 'accessories';");

			while (reader.Read())
			{
				discoverID = reader["productId"].ToString();
				discoverImg = reader["image"].ToString();
				discoverName = reader["productName"].ToString();
				color = reader["productColor"].ToString(); ;
			}
			dbm.closeConnection();

			ArrayList productId = new ArrayList();
			ArrayList productName = new ArrayList();
			ArrayList productImage = new ArrayList();


			DatabaseConnection dbm1 = new DatabaseConnection();
			SqlDataReader reader1 = dbm1.getReader("SELECT top 2 productId,productName,image from PRODUCT where productCategory = '" + category[index] + "'  and productType = 'accessories' and productColor = 'black';");

			while (reader1.Read())
			{
				productId.Add(reader1["productId"]);
				productImage.Add(reader1["image"]);
				productName.Add(reader1["productName"]);
			}
			dbm1.closeConnection();

			discoverChildID = ArrayListToString(ref productId);
			discoverChildImg = ArrayListToString(ref productImage);
			discoverChildName = ArrayListToString(ref productName);


		}

		private void shopFor(string category)
		{
			ArrayList productName = new ArrayList();
			ArrayList productImage = new ArrayList();

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT DISTINCT productType FROM PRODUCT WHERE productCategory = '" + category + "' and productType != 'accessories' ;");

			while (reader.Read())
			{
				productName.Add(reader["productType"]);
			}

			dbm.closeConnection();

			if (category == "women")
			{
				womenName = ArrayListToString(ref productName);
			}

			if (category == "men")
			{
				menName = ArrayListToString(ref productName);
			}

			if (category == "kids")
			{

				kidsName = ArrayListToString(ref productName);
			}


		}


	}
}