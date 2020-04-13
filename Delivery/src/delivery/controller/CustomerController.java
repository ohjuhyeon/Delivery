package delivery.controller;

import delivery.model.service.CustomerService;
import delivery.model.vo.Customer;
import delivery.view.DeliveryMenu;

public class CustomerController {

	public void insertCustomer(Customer signUpCustomer) {

		DeliveryMenu menu = new DeliveryMenu();
		int result;
		result = new CustomerService().insertCustomer(signUpCustomer);
		if (result > 0) {
			menu.displaySuccess("사용자 등록 성공.");
		} else {
			menu.displayError("사용자 등록 실패!!");
		}

	}

}
