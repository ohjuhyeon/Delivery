package delivery.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import delivery.model.vo.Owner;

public class OwnerDao {

	private Properties prop;
	public ArrayList<Owner> OwnerList;

	public OwnerDao() {
		prop = new Properties();

		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertOwner(Owner signUpOwner, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertOwner");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, signUpOwner.getStrId());
			pstmt.setString(2, signUpOwner.getCategory());
			pstmt.setString(3, signUpOwner.getStrPwd());
			pstmt.setString(4, signUpOwner.getStrAddr());
			pstmt.setString(5, signUpOwner.getStrPhone());
			pstmt.setString(6, signUpOwner.getStrName());
			pstmt.setString(7, signUpOwner.getCeoName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
