package com.group1.bankproject;

import java.util.Scanner;

import com.group1.bankproject.login.Login;
/**
 * Main 클래스입니다. 메인화면이며  메인메뉴 정보(로그인, 종료)를 담고있습니다.
 * @author 1조
 *
 */
public class Main {
	
	static Scanner scan;
	static { scan = new Scanner(System.in); }
	/**
	 * 프로그램 진입점입니다.
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		
		boolean loop = true;
		
		while (loop) { 			
			
			clearScreen();
			mainMenu();
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println();
			System.out.print("선택(숫자) : ");
			String sel = scan.nextLine();
		
			try {
				if (sel.equals("1")) {
					clearScreen();
					Login.main(args);
					clearScreen();
				} else if (sel.equals("2")) {
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
		pause("1-2사이의 숫자를 입력해주세요.");
		clearScreen();
		Main.main(args);
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
	
	private static void mainMenu() {
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		
		
		System.out.println("====================================================");
		System.out.println("쌍용은행");
		System.out.println("----------------------------------------------------");
		System.out.println("1. 로그인 ");
		System.out.println("2. 종료 ");
		System.out.println("====================================================");
		
	}//mainMenu

}//Main.class