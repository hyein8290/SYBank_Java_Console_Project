package com.group1.bankproject.bankproduct;

import java.util.ArrayList;
import java.util.Scanner;

import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;


/**
 * 대출 메인화면을 구현한 클래스입니다.
 * @author 1조
 *
 */
public class LoanMain {
	
	/**
	 * 대출 메인화면을 실행시키는 main 메소드입니다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		
		
				
		//print figlet
		Screen.clearScreen();
		Scanner scan = new Scanner(System.in);
		
		Liner.equalLine();
		
		System.out.println("\n대출 메인화면을 시작합니다.\n");
		
		System.out.println("    원하시는 상품/서비스를 선택해주세요.");

		Liner.minusLine();
		
		System.out.println("1. 대출");
		System.out.println("2. 뒤로가기");

		Liner.equalLine();
		
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		
		Liner.clearScreen();
		
		
		
		if (sel.equals("1")) {
			UserManage test = new UserManage();
			int debt = test.updateDebt(CurrentUser.getNum(), 0);
			System.out.printf("기존 대출잔액은 %d만원입니다.\n",debt);

			
			
			
			Liner.minusLine();
			System.out.println("    대출금액을 입력해주세요.");
			Liner.minusLine();
			System.out.print("입력(금액) : ");
			String selMoney = scan.nextLine();
			
			UserManage test_after = new UserManage();
			
			int newDebt = test_after.updateDebt(CurrentUser.getNum(), Integer.parseInt(selMoney));
			
			Liner.equalLine();
			System.out.println("    대출완료");
			Liner.minusLine();
			System.out.printf("대출잔액은 %d만원입니다.\n",newDebt);
			
			Liner.clearScreen();
			
			main(null);
		
		
		}else if (sel.equals("2")){
			
			
			Liner.clearScreen();
			
			ProductMain.main(null);
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
			
			
			Liner.clearScreen();
			main(null);
			
		}
		
		
		
		
		
		
	}//main

	private static void printAccount() {
		
		UserManage test = new UserManage();
		ArrayList<User> userObjectList = test.addDeposit();
		
		for (User userObject : userObjectList) {
			
			if (userObject.getUserNum() == CurrentUser.getNum()) {
				
				for (int key : userObject.getDepositMap().keySet()) {
					
					System.out.print(String.format("%d번 : %s\n", key, userObject.getDepositMap().get(key) ));
					
				}
				
			}
			
		}
		
		
	}
	
	
	
	
	
}//class
