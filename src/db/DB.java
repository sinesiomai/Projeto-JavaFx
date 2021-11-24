package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Properties pr = loadProperties();
				String url = pr.getProperty("dburl");
				con = DriverManager.getConnection(url, pr);

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return con;
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties pr = new Properties();
			pr.load(fs);
			return pr;
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}
	
	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}

	}
}
