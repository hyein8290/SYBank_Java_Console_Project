package com.group1.bankproject.login;

import java.util.Scanner;

import com.group1.bankproject.additionalWork.AdditionalWorkMenu;
import com.group1.bankproject.bankproduct.ProductMain;
import com.group1.bankproject.deposit.Deposit;

/**
 * UserMain 클래스, 회원 로그인 완료시 구현되는 회원 로그인 화면
 * @author 1조
 *
 */
public class UserMain {
	
	private static Scanner scan;
	static { scan = new Scanner(System.in); }
	
	/**
	 * UserMain.main 클래스, 로그인한 회원들만 이용할 수 있는 메뉴
	 */
	public static void main() {
		
		
		boolean loop = true;
		
		while (loop) {
			clearScreen();
			System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
					+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
					+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
					+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
					+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
					+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
					+ "                                                   ");
			//clearScreen();
			memberMenu();
			//clearScreen();
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("선택(숫자) : ");
			String sel = scan.nextLine();
			try {
				if (sel.equals("1")) {
					clearScreen();
					Deposit.selectMenu();
					clearScreen();
				} else if (sel.equals("2")) {
					clearScreen();
					ProductMain.main(null);
					clearScreen();
				} else if (sel.equals("3")) {
					clearScreen();
					AdditionalWorkMenu.main();
					clearScreen();
				} else if (sel.equals("4")) {
					clearScreen();
					System.out.println();
					System.out.println("이전 화면으로 이동합니다.");
					clearScreen();
					Login.main(null);
				} else if (sel.equals("5")) {
					clearScreen();
					System.out.println("로그아웃 되었습니다.");
					Login.main(null);
					clearScreen();
				} else if (sel.equals("6")) {
					clearScreen();
					System.out.println("쌍용은행을 이용해주셔서 감사합니다.");
					System.exit(0);
					clearScreen();
				} else {
					loop = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}//while 
		
		System.out.println();
		pause("1-6사이의 숫자를 입력해주세요.");
		clearScreen();
		UserMain.main();
		clearScreen();
		
	}//main
	
	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속 진행하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}//pause + 디자인 변경 맟춰서 +-하기 
	
	private static void clearScreen() {
		for (int i = 0; i < 42; i++)
			System.out.println("");
	}
	
	private static void memberMenu() {
		
		System.out.println("====================================================");
		System.out.println("회원");
		System.out.println("----------------------------------------------------");
		System.out.println(" 1. 예금 ");
		System.out.println(" 2. 은행 상품 ");
		System.out.println(" 3. 추가 업무 ");
		System.out.println(" 4. 이전 화면 ");
		System.out.println(" 5. 로그아웃 ");
		System.out.println(" 6. 종료 ");
		System.out.println("====================================================");
		
	}//memberMenu
	
}//Main.class
