package delivery.view;

import java.util.ArrayList;
import java.util.Scanner;

import delivery.controller.AdminController;
import delivery.controller.CustomerController;
import delivery.controller.OwnerController;
import delivery.model.vo.BlackList;
import delivery.model.vo.Customer;
import delivery.model.vo.Owner;

public class DeliveryMenu {

	private Scanner sc;
	private AdminController ac;
	private CustomerController cc;
	private OwnerController oc;

	public DeliveryMenu() {
		sc = new Scanner(System.in);
		ac = new AdminController();
		cc = new CustomerController();
		oc = new OwnerController();
	}

	public void Menu() {

		while (true) {

			System.out.println("배달 프로그램 ");
			System.out.println("1. 관리자");
			System.out.println("2. 점주");
			System.out.println("3. 사용자");
			System.out.println("4. 회원가입(점주, 사용자)");
			System.out.print("선택 : ");

			int select = sc.nextInt();
			switch (select) {

			case 1:
				loginAdmin(); // 아디 비번 admin 접속 함수
				break;
			case 2:
				// loginOwner(); // 점주 로그인 함수
				OwnerMenu(); // 점주 메뉴 함수
				break;
			case 3:
				// loginCustomer(); // 사용자 로그인함수
				CustomerMenu(); // 사용자 메뉴함수
				break;
			case 4:
				Signup();
				break;
			default:
				System.out.println("잘못누르셨습니다.");

			}
		}

	}

	public Customer loginCustomer() {
		Customer customer = new Customer();
		System.out.print("사용자 아이디 입력");
		customer.setCusId(sc.next());
		System.out.println("점주 비밀번호 입력");
		customer.setCusPwd(sc.next());

		return customer;
	}

	public Owner loginOwner() {
		Owner owner = new Owner();
		System.out.print("점주 아이디 입력");
		owner.setStrId(sc.next());
		System.out.println("점주 비밀번호 입력");
		owner.setStrPwd(sc.next());
		return owner;

	}

	public void loginAdmin() {

		System.out.print("아이디 입력");
		String admin = sc.next();
		if (admin.equals("admin")) {
			System.out.print("비밀번호 입력");
			String pass = sc.next();
			if (pass.equals("admin")) {
				System.out.println("로그인 성공");
				AdminMenu();
			}

		} else {
			System.out.println("로그인 실패");
		}

	}

	public void Signup() {
		System.out.println("────회원가입 메뉴────");
		System.out.println("1.점주 회원가입");
		System.out.println("2.사용자 회원가입");
		System.out.print("선택 > ");

		switch (sc.nextInt()) {
		case 1:
			oc.insertOwner(this.SignUpOwner());
			break;
		case 2:
			cc.insertCustomer(this.SignUpCustomer());
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	public Owner SignUpOwner() {

		Owner owner = new Owner();

		System.out.print("점주 이름 > ");
		owner.setCeoName(sc.next());

		System.out.print("점주 아이디 > ");
		owner.setStrId(sc.next());

		System.out.print("비밀번호 > ");
		owner.setStrPwd(sc.next());

		System.out.print("가게 이름> ");
		owner.setStrName(sc.next());

		System.out.print("가게 주소 > ");
		sc.nextLine();
		owner.setStrAddr(sc.nextLine());

		System.out.print("가게 전화번호 > ");
		owner.setStrPhone(sc.next());

		System.out.print("카테고리 > ");
		owner.setCategory(sc.next());

		return owner;
	}

	private Customer SignUpCustomer() {

		Customer customer = new Customer();

		System.out.print("회원 이름 > ");
		customer.setCusName(sc.next());

		System.out.print("아이디 > ");
		customer.setCusId(sc.next());

		System.out.print("비밀번호 > ");
		customer.setCusPwd(sc.next());

		System.out.print("주소 > ");
		sc.nextLine();
		customer.setCusAddr(sc.nextLine());

		System.out.print("전화번호 > ");
		customer.setCusPhone(sc.next());

		return customer;
	}

	private void AdminMenu() {
		System.out.println("────관리자 메뉴────");
		System.out.println("1.회원관리 메뉴");
		System.out.println("2.가게관리 메뉴");
		System.out.println("3.메인메뉴로 가기");
		System.out.print("선택 > ");

		switch (sc.nextInt()) {
		case 1:
			CustomerManageMenu();
			AdminMenu();
			break;
		case 2:
			StoreManageMenu();
			AdminMenu();
			break;
		case 3:
			Menu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			AdminMenu();
			break;
		}

	}

	private void CustomerManageMenu() {
		System.out.println("────회원 관리 메뉴────");
		System.out.println("1. 회원 전체 출력");
		System.out.println("2. 회원 검색 (keyword)");
		System.out.println("3. 전체 주문 내역");
		System.out.println("4. 신고내역 전체출력");
		System.out.println("5. 신고내역 검색");
		System.out.print("선택 > ");

		switch (sc.nextInt()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}

	}

	private void StoreManageMenu() {
		System.out.println("────가게 관리 메뉴────");
		System.out.println("1. 가게 전체 출력");
		System.out.println("2. 가게 검색");
		System.out.println("3. 가게 삭제");
		System.out.println("4. 가게 메뉴 확인");
		System.out.println("5. 가게 매출 순위");
		System.out.println("6. 블랙 리스트 추가");
		System.out.println("7. 블랙 리스트 삭제");
		System.out.print("선택 > ");

		switch (sc.nextInt()) {
		case 1:
			ac.selectAllStore();
			break;
		case 2:
			ac.searchStore(this.searchStoreNo());
			break;
		case 3:
			ac.deleteStore(this.deleteStoreNo());
			break;
		case 4:
			ac.selectAllMenu();
			break;
		case 5:
			break;
		case 6:
			ac.insertBlackList(this.insertBlackList());
			break;
		case 7:
			ac.deleteBlackList(this.deleteBlackListNo());
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}

	}

	private int deleteBlackListNo() {
		System.out.println("지우실 블랙리스트번호를 입력 해주세요");
		return sc.nextInt();
	}

	private BlackList insertBlackList() {
		BlackList blacklist = new BlackList();

		System.out.print("점주 아이디 : ");
		blacklist.setStrId(sc.next());

		System.out.print("키워드 : ");
		blacklist.setKeyword(sc.next());

		return blacklist;
	}

	private int deleteStoreNo() {
		System.out.println("지우실 가게를 번호해주세요");
		return sc.nextInt();
	}

	public int searchStoreNo() {
		System.out.println("찾으실 가게를 입력해주세요");
		return sc.nextInt();
	}

	private void OwnerMenu() {
		System.out.println("────점주 모드────");
		System.out.println("1.전체 메뉴 출력");
		System.out.println("2.메뉴 추가");
		System.out.println("3.메뉴 삭제");
		System.out.println("4.메뉴 수정");
		System.out.println("5.주문내역 리스트"); // 주문내역
		System.out.println("6.주문 내역 처리");
		System.out.println("7.날짜별 주문내역 확인"); // 배달완료내역
		System.out.print("메뉴 선택 > ");

		switch (sc.nextInt()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	private void CustomerMenu() {
		System.out.println("────사용자 모드────");
		System.out.println("1. 주문하기");
		System.out.println("2. 장바구니 확인");
		System.out.println("3. 주문취소");
		System.out.println("4. 신고하기");
		System.out.print("메뉴 선택 > ");

		switch (sc.nextInt()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	public void displayOwnerList(ArrayList<Owner> ownerList) {
		System.out.println("가게정보입니다.");
		for (Owner owner : ownerList) {
			System.out.println(owner.toString());
		}
	}

	public void displayMenuList(ArrayList<delivery.model.vo.Menu> menuList) {
		System.out.println("가게 메뉴 정보입니다.");
		for (delivery.model.vo.Menu menu : menuList) {
			System.out.println(menu.toString());
		}
	}

	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}

	public void displayOwner(Owner owner) {
		System.out.println(owner.toString());

	}

	public void displaySuccess(String message) {
		System.out.println("서비스 성공 : " + message);

	}

}