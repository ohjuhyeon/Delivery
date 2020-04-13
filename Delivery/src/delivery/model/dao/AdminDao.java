package delivery.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import delivery.model.vo.BlackList;
import delivery.model.vo.Menu;
import delivery.model.vo.Owner;

public class AdminDao {

	private Properties prop;
	public ArrayList<Owner> ownerList;

	public AdminDao() {
		prop = new Properties();

		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Owner> selectAllStore(Connection conn) {

		ArrayList<Owner> ownerList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAllStore");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			ownerList = new ArrayList<Owner>();

			while (rset.next()) {
				Owner owner = new Owner();
				owner.setStrId(rset.getString("str_id"));
				owner.setCategory(rset.getString("category"));
				owner.setStrPwd(rset.getString("str_pwd"));
				owner.setStrAddr(rset.getString("str_Addr"));
				owner.setStrPhone(rset.getString("str_phone"));
				owner.setStrName(rset.getString("str_name"));
				owner.setCeoName(rset.getString("ceo_name"));
				owner.setStrNo(rset.getInt("str_no"));
				ownerList.add(owner);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ownerList;
	}

	public Owner searchStore(int inputStoreNo, Connection conn) {
		Owner owner = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("searchStore");

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inputStoreNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				owner = new Owner();
				owner.setStrId(rset.getString("str_id"));
				owner.setCategory(rset.getString("category"));
				owner.setStrPwd(rset.getString("str_pwd"));
				owner.setStrAddr(rset.getString("str_Addr"));
				owner.setStrPhone(rset.getString("str_phone"));
				owner.setStrName(rset.getString("str_name"));
				owner.setCeoName(rset.getString("ceo_name"));
				owner.setStrNo(rset.getInt("str_no"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return owner;
	}

	public int deleteStore(int deleteStoreNo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("deleteStore");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deleteStoreNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<Menu> selectAllMenu(Connection conn) {

		ArrayList<Menu> menuList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAllMenu");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			menuList = new ArrayList<Menu>();

			while (rset.next()) {
				Menu menu = new Menu();
				menu.setStrId(rset.getString("str_id"));
				menu.setMenuName(rset.getString("Menu_Name"));
				menu.setPrice(rset.getInt("price"));
				menu.setCategory(rset.getString("category"));
				menu.setMenuNo(rset.getInt("menu_no"));
				menuList.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuList;
	}

	public int insertBlackList(BlackList insertBlackList, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertBlackList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, insertBlackList.getStrId());
			pstmt.setString(2, insertBlackList.getKeyword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int deleteBlackList(int deleteBlackListNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("deleteBlackList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deleteBlackListNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
