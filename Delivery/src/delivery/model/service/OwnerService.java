package delivery.model.service;

import java.util.ArrayList;

import delivery.common.ConnectionFactory;
import delivery.model.vo.Owner;

public class OwnerService {

	private ConnectionFactory factory;

	public OwnerService() {

		factory = ConnectionFactory.getInstance();

	}


}
