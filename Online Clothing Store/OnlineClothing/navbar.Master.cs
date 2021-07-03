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
	public partial class navbar : System.Web.UI.MasterPage
	{
		public string womenType, menType, kidsType, accessoryType, womenName, menName, kidsName;
		protected void Page_Load(object sender, EventArgs e)
		{
			shopFor("women");
			shopFor("men");
			shopFor("kids");



		}

		private string ArrayListToString(List<object> list)
		{
			int intCount;
			string strFinal = "";

			for (intCount = 0; intCount <= list.Count - 1; intCount++)
			{
				if (intCount > 0)
				{
					strFinal += "~";
				}

				strFinal += list[intCount].ToString();
			}

			return strFinal;
		}

		private void shopFor(string category)
		{
			//ArrayList productName = new ArrayList();
			// ArrayList tempType = new ArrayList();

			List<object> productName = new List<object>();
			List<object> tempType = new List<object>();

			DatabaseConnection dbm = new DatabaseConnection();
			SqlDataReader reader = dbm.getReader("SELECT productName, productType FROM PRODUCT WHERE productCategory = '" + category + "' and productType != 'accessories' ;");

			while (reader.Read())
			{
				productName.Add(reader["productName"]);
				tempType.Add(reader["productType"]);
			}

			dbm.closeConnection();

			List<object> productType = tempType.Distinct().ToList();

			if (category == "women")
			{
				womenType = ArrayListToString(productType);
			}

			if (category == "men")
			{
				menType = ArrayListToString(productType);
			}

			if (category == "kids")
			{
				kidsType = ArrayListToString(productType);
			}


		}

	}

}