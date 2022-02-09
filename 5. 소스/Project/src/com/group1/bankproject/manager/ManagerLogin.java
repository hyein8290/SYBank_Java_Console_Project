package com.group1.bankproject.manager;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ManagerLogin {
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	public static void Login()  {
		blank();
		System.out.println("[관리자 로그인]");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디입력: ");
		String admin = scan.nextLine();
		
		System.out.print("비밀번호입력: ");
		String passWord = scan.nextLine();
			
		Manager manager = new Manager();
		
		
		if(admin.equals(manager.getId()) && passWord.equals(manager.getPassword())) {
			blank();
			System.out.println("로그인 완료");
			
			pass();
			
		} else {
			blank();
			System.out.println("잘못된 계정입니다.");
			ManagerLogin.Login();
		}

		

	}
	public static void pass() {
		boolean flag = true;
		
		while(flag) {
			blank();
			menu();
			
			System.out.print("업무 번호 선택: ");
			String sel = scan.nextLine();
			try {
			if (sel.equals("1")) {				
				AddProduct.add();				
			} else if (sel.equals("2")) {
				//연이자율 수정
				ChangePersent.aboutPersent();
				
			} else if (sel.equals("3")) {
				//회원정보 조회/수정(findUserManager)
				FindUserManager fum = new FindUserManager();
				fum.findFix();
			} else if (sel.equals("4")) {
				//뒤로가기
				//list();
			}
			 else {
				flag = false;
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료합니다.");		
		}
		
	
	private static void menu() {
		blank();
		System.out.println("====================================================");
		System.out.println("관리자");
		System.out.println("----------------------------------------------------");

		System.out.println("1. 적금,대출 펀드 상품 추가/삭제");
		System.out.println("2. 연이자율 수정");
		System.out.println("3. 회원정보 조회/수정");
		System.out.println("4. 뒤로가기");
		System.out.println("5. 로그아웃");		
		System.out.println("====================================================");
		
	}
	
	private static void blank() {
		for(int i=0; i<42; i++) {
			System.out.println();
		}
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
	}

}
