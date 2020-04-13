package delivery.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import delivery.model.vo.Customer;
import delivery.model.vo.Owner;

public class CustomerDao {

	private Properties prop;
	public ArrayList<Customer> CustomerList;

	public CustomerDao() {
		prop = new Properties();

		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertCustomer(Customer signUpCustomer, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertCustomer");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, signUpCustomer.getCusId());
			pstmt.setString(2, signUpCustomer.getCusName());
			pstmt.setString(3, signUpCustomer.getCusPwd());
			pstmt.setString(4, signUpCustomer.getCusAddr());
			pstmt.setString(5, signUpCustomer.getCusPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
