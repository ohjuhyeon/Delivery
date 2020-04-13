package delivery.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.common.ConnectionFactory;
import delivery.model.dao.OwnerDao;
import delivery.model.vo.Owner;

public class OwnerService {

	private ConnectionFactory factory;

	public OwnerService() {

		factory = ConnectionFactory.getInstance();

	}

	public int insertOwner(Owner signUpOwner) {

		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new OwnerDao().insertOwner(signUpOwner, conn);

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
