package delivery.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.common.ConnectionFactory;
import delivery.model.dao.AdminDao;
import delivery.model.vo.BlackList;
import delivery.model.vo.Menu;
import delivery.model.vo.Owner;

public class AdminService {

	public ConnectionFactory factory;

	public AdminService() {

		factory = ConnectionFactory.getInstance();

	}

	public ArrayList<Owner> selectAllStore() {

		Connection conn = null;
		ArrayList<Owner> ownerList = null;

		try {
			conn = factory.createConnection();
			ownerList = new AdminDao().selectAllStore(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ownerList;
	}

	public Owner searchStore(int inputStoreNo) {
		Connection conn = null;
		Owner owner = null;
		try {
			conn = factory.createConnection();
			owner = new AdminDao().searchStore(inputStoreNo, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return owner;
	}

	public int deleteStore(int deleteStoreNo) {

		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminDao().deleteStore(deleteStoreNo, conn);

			if (result > 0)
				factory.commit(conn);
			else
				factory.rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn);
		}
		return result;
	}

	public ArrayList<Menu> selectAllMenu() {
		Connection conn = null;
		ArrayList<Menu> menuList = null;

		try {
			conn = factory.createConnection();
			menuList = new AdminDao().selectAllMenu(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;
	}

	public int insertBlackList(BlackList insertBlackList) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminDao().insertBlackList(insertBlackList, conn);

			if (result > 0)
				factory.commit(conn);
			else
				factory.rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
