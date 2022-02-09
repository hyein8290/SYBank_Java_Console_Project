package com.group1.bankproject.login;

import java.util.Scanner;
import com.group1.bankproject.manager.ManagerLogin;

/**
 * Login 클래스 입니다. Main 첫화면 클래스 이후 로그인 관련 화면을 구현합니다.
 * @author 1조
 *
 */
public class Login {
	
	private static Scanner scan;
	static { scan = new Scanner(System.in); }
	
	/**
	 * Login.main 클래스, 로그인 관련 선택 메뉴 페이지 입니다.
	 * @param args 로그인 관련 선택 상세 메뉴 페이지 입니다.
	 */
	public static void main(String[] args) {

		
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
			menu();	
			
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("선택(숫자) : ");
			String sel = scan.nextLine();
			clearScreen();
			try {
				if (sel.equals("1")) {
					clearScreen();
					UserLogin.login();
					clearScreen();
				} else if (sel.equals("2")) {
					clearScreen();
					System.out.println();
					ManagerLogin.Login();
					clearScreen();
				} else if (sel.equals("3")) {
					clearScreen();
					Join.userjoin();
					clearScreen();
				} else if (sel.equals("4")) {
					clearScreen();
					FindID.id();
					clearScreen();
				} else if (sel.equals("5")) {
					clearScreen();
					FindPW.pw();
					clearScreen();
				} else if (sel.equals("6")) {
					System.out.println("쌍용은행을 이용해주셔서 감사합니다.");
					System.exit(0);
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
		Login.main(args);
		clearScreen();
		
	}//main
	
	private static void pause (String msg) {
		System.out.println(msg);
		System.out.println("계속 진행하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}//pause + 디자인 변경 맟춰서 +-하기 

	private static void clearScreen() {
	    for (int i = 0; i < 42; i++)
	      System.out.println("");
}
	
	private static void menu() {
		
		System.out.println("====================================================");
		System.out.println("로그인");
		System.out.println("----------------------------------------------------");
		System.out.println(" 1. 회원 로그인 ");
		System.out.println(" 2. 관리자 로그인 ");
		System.out.println(" 3. 회원가입 ");
		System.out.println(" 4. 아이디 찾기 ");
		System.out.println(" 5. 비밀번호 찾기 ");
		System.out.println(" 6. 종료 ");
		System.out.println("====================================================");
		
	}//menu

}//login.class
