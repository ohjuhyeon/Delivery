package delivery.controller;

import delivery.model.service.OwnerService;
import delivery.model.vo.Owner;
import delivery.view.DeliveryMenu;

public class OwnerController {

	public void insertOwner(Owner signUpOwner) {

		DeliveryMenu menu = new DeliveryMenu();
		int result;
		result = new OwnerService().insertOwner(signUpOwner);
		if (result > 0) {
			menu.displaySuccess("점주 등록 성공.");
		} else {
			menu.displayError("점주 등록 실패!!");
		}
	}

}
