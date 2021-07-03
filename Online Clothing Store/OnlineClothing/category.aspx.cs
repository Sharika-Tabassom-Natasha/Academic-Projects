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
    public partial class category : System.Web.UI.Page
    {

		protected string categoryName;
		public string Name, discountName,discountID;


		protected void Page_Load(object sender, EventArgs e)
		{
			categoryName = Request.QueryString["Category"];
			discount();
			categoryPage();
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

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT * FROM Discount where discountId in (select distinct discountId from PRODUCT where productCategory='" + categoryName + "');");

			while (reader.Read())
			{
				productID.Add(reader["discountID"]);
				productName.Add(reader["discountName"]);
			}
			dbm.closeConnection();

			discountID = ArrayListToString(ref productID);
			discountName = ArrayListToString(ref productName);
		}


		private void categoryPage()
		{
			ArrayList productName = new ArrayList();
			ArrayList productImage = new ArrayList();

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT DISTINCT productType FROM PRODUCT WHERE productCategory = '" + categoryName + "' and productType != 'accessories' ;");

			while (reader.Read())
			{
				productName.Add(reader["productType"]);
			}

			dbm.closeConnection();

			Name = ArrayListToString(ref productName);

		}
	}
}