using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace OnlineClothing
{
	public class CustomerProduct
	{
		public int orderid { get; set; }
		public int ordernum { get; set; }
		public string name { get; set; }
		public double price { get; set; }
		public int quantity { get; set; }
		public string date { get; set; }
		public string size { get; set; }
		public string status { get; set; }
		public int productid { get; set; }
	}
}