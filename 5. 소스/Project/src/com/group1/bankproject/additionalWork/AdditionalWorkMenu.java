package com.group1.bankproject.additionalWork;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.group1.bankproject.login.UserMain;
/**
 * 
 * @author 1조
 *
 */
public class AdditionalWorkMenu {
	
	private static Scanner scan;
	
	static {
		
		scan = new Scanner(System.in);
		
	}
	/**
	 * 추가업무의 메뉴메소드 입니다.
	 * 임금계산기, 주휴수당, 예상 퇴직금 계산기, 예상 신용등급 등을 연결해주는 메소드입니다.
	 */
	public static void main() {
		
		
		
		boolean loop = true;
		
		while (loop) {
			clearScreen();
			logo();
			menu();
			
			System.out.print("선택 :");
			String sel = scan.nextLine();
			
			try {
				if (sel.equals("1")) {
					
					partTime(); //임금 계산기
					
				} else if (sel.equals("2")) {
					
					holidayPay(); //주휴수당 계산기
					
				} else if (sel.equals("3")) {
					
					severancePay(); //예상 퇴직금 계산기
					
				} else if (sel.equals("4")) {
					
					expect(); //나의 예상 신용등급
					pause();
					
				} else if(sel.equals("5")){
					
					loop = false;
//					pause();
				} else if(sel.equals("6")){
					
					UserMain.main();
					
				} else {
					System.out.println("입력값이 틀렸습니다. 다시 입력주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
	}
	
	private static void expect() {
		
		clearScreen();
		logo();
		
		int max = Integer.MAX_VALUE/10000;
		line1();
		System.out.println("예상 신용등급");
		line2();
		if (CurrentUser.getDebt() >=0 && CurrentUser.getDebt()<=10000) {
			System.out.println("당신의 신용등급은 A입니다.");
		} else if (CurrentUser.getDebt() > 10000 && CurrentUser.getDebt()<=100000) {
			System.out.println("당신의 신용등급은 B입니다.");
		} else if (CurrentUser.getDebt() > 100000 && CurrentUser.getDebt()<=150000) {
			System.out.println("당신의 신용등급은 C입니다.");
		} else if (CurrentUser.getDebt() >150000 && CurrentUser.getDebt()<= max ) {
			System.out.println("당신의 신용등급은 D입니다.");
		}
		line1();
//		pause();
		
		
	}
	
	private static void severancePay() {
		
		try {
			System.out.print("최근 이번달 월급 : ");
			int thisMonth = scan.nextInt();
			System.out.print("최근 1개월전 월급 : ");
			int lastMonth = scan.nextInt();
			System.out.print("최근 2개월전 월급 : ");
			int twoMonthAgo = scan.nextInt();
			SeverancePay severance = new SeverancePay(thisMonth, lastMonth, twoMonthAgo);
			severance.calculate();
//			pause();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void holidayPay() {
		
		try {
			System.out.print("시급 : ");
			int hourPay = scan.nextInt();
			System.out.print("시간 : ");
			int albaTime = scan.nextInt();
			System.out.print("근무 일수 : ");
			int weekday = scan.nextInt();
			HolidayPay holidaypay = new HolidayPay(hourPay, albaTime, weekday);
			holidaypay.calculate();
//			pause();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void partTime() {
		
		try {
			System.out.print("시급 : ");
			int hourPay = scan.nextInt();
			System.out.print("시간 : ");
			int albaTime = scan.nextInt();
			System.out.print("근무 일수 : ");
			int weekday = scan.nextInt();
			PartTime parttime = new PartTime(hourPay, albaTime, weekday);
			parttime.calculate();
//			pause();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void pause() {
		System.out.println();
		System.out.println("계속하시려면 엔터키를 누르세요..");
		scan.nextLine();
	}
	
	private static void logo() {
		System.out.println(	"███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ 			"██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ 			"███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ 			"╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ 			"███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ 			"╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ 			"                                                   ");
		
	}
	
	private static void menu() {
		
		line1();
		System.out.println("추가업무");
		line2();
		System.out.println("1. 아르바이트 월급 계산");
		System.out.println("2. 주휴수당 계산");
		System.out.println("3. 퇴직금 계산");
		System.out.println("4. 예상 신용등급 계산");
		System.out.println("5. 이전 페이지로");
		System.out.println("6. 메인페이지");
		line1();
		
	}
	
	private static void line1() {
		System.out.println("====================================================");
	}

	private static void line2() {
		System.out.println("----------------------------------------------------");
	}
	
	
	private static void clearScreen() {
	    for (int i = 0; i < 42; i++) {
	      System.out.println("");
	    }
	}
	
}
