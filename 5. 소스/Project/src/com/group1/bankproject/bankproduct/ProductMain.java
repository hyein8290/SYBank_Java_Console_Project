package com.group1.bankproject.bankproduct;

import java.util.Scanner;

import com.group1.bankproject.Screen;
import com.group1.bankproject.login.UserMain;

/**
 * 은행상품 메인화면을 구현한 클래스입니다.
 * @author 1조
 *
 */

public class ProductMain {
	
	/**
	 * 
	 * 은행상품 메인화면을 실행하는 main 메소드입니다.
	 */
	
	
	public static void main(String[] args) {
		
		//print figlet
		
		
		Screen.clearScreen();
		Scanner scan = new Scanner(System.in);
		
		Liner.equalLine();
		
		System.out.println("\n은행상품 메인화면을 시작합니다.\n");

		
		
		System.out.println("    원하시는 상품/서비스를 선택해주세요.");

		Liner.minusLine();
		
		System.out.println("1. 적금");
		System.out.println("2. 대출");
		System.out.println("3. 펀드");
		System.out.println("4. 나의 가입상품");
		System.out.println("5. 뒤로가기");
		
		Liner.equalLine();
		
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		
		Liner.clearScreen();
		
		
		
		
		if (sel.equals("1")) {
		
			Saving.main(args);
		
		
		}else if (sel.equals("2")){

			
			LoanMain.main(null);
			
		}else if (sel.equals("3")){
			
			FundMain.main(null);
			
		}else if (sel.equals("4")){
			MyProduct.main(null);
			
		}else if (sel.equals("5")){

			UserMain.main();
			
			
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
		
			
			Liner.clearScreen();

			
			
			
			main(null);
			
		}

		
		
	}//main
	
	
	
	
	
}//class
