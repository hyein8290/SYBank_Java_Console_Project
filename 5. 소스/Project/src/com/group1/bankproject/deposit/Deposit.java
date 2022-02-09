package com.group1.bankproject.deposit;

import java.util.Scanner;

import com.group1.bankproject.Screen;

/**
 * 
 * 예금 메뉴를 선택하는 객체
 * @author 1조
 *
 */
public class Deposit {
	
	private static Scanner scan;
	private static SendingMoney sendingMoney;
	private static FindingAccount findingAccount;
	private static MakingAccount makingAccount;
	
	static {
		scan = new Scanner(System.in);
		sendingMoney = new SendingMoney();
		findingAccount = new FindingAccount();
		makingAccount = new MakingAccount();
	}
	
	/**
	 * 예금 메뉴를 선택하는 메소드
	 */
	public static void selectMenu() {
		
		int selectedNum = 0;
		boolean flag = true;
		
		while(flag) {
			
			Screen.clearScreen();
			printMenu();
			
			selectedNum = Integer.parseInt(scan.nextLine());
			System.out.println();
			
			switch(selectedNum) {
			case 1: 
				//계좌 이체
				sendingMoney.sendMoney();
				break;
			case 2:
				//계좌 조회
				findingAccount.findAccount();
				break;
			case 3:
				//계좌 개설
				makingAccount.makeAccount();
				break;
			case 4:
				//계좌 해지
				DeleteAccount.main(null);
				break;
			case 5:
				//뒤로 가기 userMain 회원메인메뉴
				flag = false;
				break;
			case 6:
				//프로그램 종료
				System.out.println("쌍용은행을 이용해주셔서 감사합니다.");
				System.exit(0);
				break;
			default:
				//잘못 입력
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("계속 하시려면 엔터를 눌러주세요...");
				scan.nextLine();
				break;
			}
		}
		
	}
	
	private static void printMenu() {
		
		System.out.println("===================================================\r\n");
		System.out.println("예금 메뉴");
		System.out.println("---------------------------------------------------");
		System.out.println("1. 계좌 이체");
		System.out.println("2. 계좌 조회");
		System.out.println("3. 계좌 개설");
		System.out.println("4. 계좌 해지");
		System.out.println("5. 뒤로 가기");
		System.out.println("6. 프로그램 종료\r\n");
		System.out.println("===================================================");
		System.out.print("입력: ");
		
	}
	
}
