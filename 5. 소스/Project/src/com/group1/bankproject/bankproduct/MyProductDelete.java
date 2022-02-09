package com.group1.bankproject.bankproduct;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.group1.bankproject.additionalWork.CurrentUser;


/**
 * 나의 가입상품을 해지하는 기능을 구현한 클래스입니다.
 * 
 * @author 1조
 *
 */


public class MyProductDelete {

	/**
	 * 적금상품 해지기능을 구현한 메소드입니다.
	 * 
	 */
	
	public void select(ArrayList<Savings> savingsList) {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		Liner.equalLine();
		
		System.out.println("    해지하시겠습니까?");
		System.out.println("1. 예");
		System.out.println("2. 아니오 (뒤로가기)");
		
		Liner.minusLine();
		
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		
		Liner.equalLine();
		
		
		if (sel.equals("1")) {
		

			System.out.println("    어떤 상품을 해지하시겠습니까?");


			Liner.minusLine();
			
			
			System.out.print("선택(상품번호) : ");
			String selNum = scan.nextLine();


			Liner.equalLine();
			
			
			//상품번호 유효성 검사
			boolean rightDecision = false;
			
			try { 
			
				for (Savings object : savingsList) {
					
					if (Integer.parseInt(selNum)==object.getSavingsSequence()) {
						
						rightDecision = true;
						
					}
					
				}//for
				
			}catch (Exception e) {  }
			
			
			if (rightDecision == false) {
				
				System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
				
				
				Liner.clearScreen();
				
				
				MyProductDelete delete = new MyProductDelete();
				
				delete.select(savingsList);
			}			
			
			
			
			System.out.println("    환급받을 예금계좌를 입력하십시오('-'포함)");

			Liner.minusLine();
			
			System.out.print("입력(계좌번호) : ");
			String selAccount = scan.nextLine();
			
			Liner.equalLine();
			
			for (Savings object : savingsList) {
				if (Integer.parseInt(selNum)==object.getSavingsSequence()) {
					Calendar cal = Calendar.getInstance();
					String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
					
					double refund = (1+object.getRate())*object.getSavingsMoney();
			 
					
					
					UserManage test = new UserManage();
					
					String refundMoney = test.refundDeposit(selAccount, date, refund);
					
					System.out.printf("%s만원이 입급되었습니다.\n", refundMoney);
					
					
					Liner.clearScreen();
					
					test.deleteSavings(CurrentUser.getNum(), Integer.parseInt(object.getSavingsNum()));
					
					MyProduct.main(null);
					
				}
				
			}
			
			
			
		
		}else if (sel.equals("2")){
			
			Liner.clearScreen();
			
			MyProduct.main(null);
			
			
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
	
			Liner.clearScreen();
			
			
			MyProductDelete delete = new MyProductDelete();
			
			delete.select(savingsList);
			
		}
		
		
	}
	
	/*
	 * 펀드상품 해지 기능을 구현한 메소드입니다.
	 */

	public void selectFund(ArrayList<Fund> fundList) {

		
		
		Scanner scan = new Scanner(System.in);
		
		Liner.equalLine();
		
		System.out.println("    해지하시겠습니까?");
		System.out.println("1. 예");
		System.out.println("2. 아니오 (뒤로가기)");
		Liner.minusLine();
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		Liner.equalLine();

		
		
		if (sel.equals("1")) {
		

			System.out.println("    어떤 상품을 해지하시겠습니까?");
			Liner.minusLine();
			System.out.print("선택(상품번호) : ");
			String selNum = scan.nextLine();
			Liner.equalLine();

			
			//상품번호 유효성 검사
			boolean rightDecision = false;
			
			try { 
				
				for (Fund object : fundList) {
					
					if (Integer.parseInt(selNum)==object.getFundSequence()) {
						
						rightDecision = true;
						
					}
					
				}//for
				
			}catch (Exception e) {  }
			
			if (rightDecision == false) {
				
				System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
				Liner.clearScreen();

				
				MyProductDelete delete = new MyProductDelete();
				
				delete.selectFund(fundList);
				
			}			
						
			
			
			
			
			
			
			System.out.println("    환급받을 예금계좌를 입력하십시오('-'포함)");
			Liner.minusLine();
			System.out.print("입력(계좌번호) : ");
			String selAccount = scan.nextLine();
			Liner.equalLine();

			
			for (Fund object : fundList) {
				
				
				
				if (Integer.parseInt(selNum)==object.getFundSequence()) {
					Calendar cal = Calendar.getInstance();
					String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
					
					double refund = (1+object.getRate())*object.getFundMoney();
			 
					
					
					UserManage test = new UserManage();
					
					String refundMoney = test.refundDeposit(selAccount, date, refund);
					
					System.out.printf("%s만원이 입급되었습니다.\n", refundMoney);
					Liner.clearScreen();

					
					test.deleteFund(CurrentUser.getNum(), Integer.parseInt(object.getFundNum()));
					
					MyProduct.main(null);
					
				}
				
			}
			
			
			
		
		}else if (sel.equals("2")){
			Liner.clearScreen();

			
			MyProduct.main(null);
			
			
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
			Liner.clearScreen();

			
			MyProductDelete delete = new MyProductDelete();
			
			delete.selectFund(fundList);
			
		}
		
	}


	
	
	

}
