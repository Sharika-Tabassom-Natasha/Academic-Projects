using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace OnlineClothing
{
    public class DatabaseConnection
    {
        private SqlConnection conn;

        public SqlConnection getConnection()
        {
            //CONNECT TO THE DATABASE
            String connStr = @"Data Source= LAPTOP-8E03MU34; Initial Catalog = clothingDatabase; Integrated Security=True";
			conn = new SqlConnection(connStr);
            conn.Open();
            return conn;
        }

        public SqlDataReader getReader(string query)
        {
            //Create Command
            SqlCommand cmd = new SqlCommand(query);
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.Connection = this.getConnection();

            //READ FROM THE DATABASE
            SqlDataReader reader = cmd.ExecuteReader();

            return reader;
        }


        public void closeConnection()
        {
            if (conn != null && conn.State == System.Data.ConnectionState.Open)
            {
                this.conn.Close();
            }
        }
    }
}