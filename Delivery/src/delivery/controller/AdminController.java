package delivery.controller;

import java.util.ArrayList;

import delivery.model.service.AdminService;
import delivery.model.vo.BlackList;
import delivery.model.vo.Menu;
import delivery.model.vo.Owner;
import delivery.view.DeliveryMenu;

public class AdminController {

	public void selectAllStore() {
		DeliveryMenu menu = new DeliveryMenu();
		ArrayList<Owner> ownerList;
		ownerList = new AdminService().selectAllStore();
		if (!ownerList.isEmpty()) {
			menu.displayOwnerList(ownerList);
		} else {
			menu.displayError("가게 전체 조회 실패 ");
		}

	}

	public void searchStore(int inputStoreNo) {
		DeliveryMenu menu = new DeliveryMenu();
		Owner owner;

		owner = new AdminService().searchStore(inputStoreNo);
		if (owner != null)
			menu.displayOwner(owner);
	}

	public void deleteStore(int deleteStoreNo) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;

		result = new AdminService().deleteStore(deleteStoreNo);
		if (result > 0) {
			menu.displaySuccess("회원 탈퇴 성공");
		} else {
			menu.displayError("회원탈퇴 실패");
		}

	}

	public void selectAllMenu() {

		DeliveryMenu menu = new DeliveryMenu();
		ArrayList<Menu> menuList;
		menuList = new AdminService().selectAllMenu();
		if (!menuList.isEmpty()) {
			menu.displayMenuList(menuList);
		} else {
			menu.displayError("가게 전체 조회 실패 ");
		}

	}

	public void insertBlackList(BlackList insertBlackList) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;
		result = new AdminService().insertBlackList(insertBlackList);
		if (result > 0) {
			menu.displaySuccess("블랙리스트 등록 성공.");
		} else {
			menu.displayError("블랙리스트 등록 실패!!");
		}

	}

	public void deleteBlackList(int deleteBlackListNo) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;

		result = new AdminService().deleteBlackList(deleteBlackListNo);
		if (result > 0) {
			menu.displaySuccess("블랙리스트 삭제 성공");
		} else {
			menu.displayError("블랙리스트 삭제 실패");
		}

	}

}
