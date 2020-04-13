package delivery.view;

import java.util.Scanner;

public class DeliveryMenu {

	private Scanner sc;

	public DeliveryMenu() {
		sc = new Scanner(System.in);
	}

	public void menu() {

		while (true) {

			System.out.println("배달 프로그램 ");
			System.out.println("1. 책관리");
			System.out.println("2. 회원관리");
			System.out.println("3. 대여관리");
			System.out.print("선택 : ");

			int select = sc.nextInt();
			switch (select) {

			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("잘못누르셨습니다.");

			}
		}

	}
}