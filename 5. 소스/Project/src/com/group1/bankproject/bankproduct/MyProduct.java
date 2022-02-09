package com.group1.bankproject.bankproduct;

import java.util.ArrayList;
import java.util.Scanner;

import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * 나의 가입상품 화면을 구현하는 클래스입니다.
 * @author 1조
 *
 */

public class MyProduct {
	
/**
 * 	
 * 나의 가입상품 화면을 실행시키는 main 메소드입니다.
 */
	
public static void main(String[] args) {
		
		int userNum = CurrentUser.getNum();
		//print figlet

		Scanner scan = new Scanner(System.in);
		Screen.clearScreen();
		Liner.equalLine();
		
		System.out.println("\n나의 가입상품 화면을 시작합니다.\n");
		System.out.println("    원하시는 서비스를 선택해주세요.");
		
		Liner.minusLine();
		
		System.out.println("1. 가입된 적금 조회");
		System.out.println("2. 가입된 펀드 조회");
		System.out.println("3. 뒤로가기");

		Liner.equalLine();
		
		
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		
		
		Liner.clearScreen();
		
		
		if (sel.equals("1")) {
		

			RefundList test = new RefundList();
			ArrayList<Savings> savingsList= test.savingsList();
			savingsList = show(savingsList, userNum);
			
			MyProductDelete delete = new MyProductDelete();
			
			delete.select(savingsList);
			
			
			
			
		
		}else if (sel.equals("2")){

			RefundList test = new RefundList();
			ArrayList<Fund> fundList= test.fundList();
			fundList = showFund(fundList, userNum);
			
			MyProductDelete delete = new MyProductDelete();
			
			delete.selectFund(fundList);
			
			
		}else if (sel.equals("3")){

			
			ProductMain.main(null);
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
			
			
			Liner.clearScreen();

			
			
			main(null);
			
			
		}

		
		
	}//main

	private static ArrayList<Fund> showFund(ArrayList<Fund> fundList, int userNum) {
		
		int count = 0;
		
		String header1 = String.format("[%s]\t [%s]\n ","상품번호","상품명");
		String header2 = String.format("[%s]\t [%s]\n","수익률","가입규모");
		String footer = "_____________________________________________\n";
		
		
		for (Fund object : fundList) {
			
			if (userNum == object.getUserNum()) {
				count++;
				object.setFundSequence(count);
				
				String content1 = String.format("%s\t %s\n",object.getFundSequence(),object.getFundName());

				String content2 = String.format("%.2f\t %s\n", object.getRate(), object.getFundMoney());
				
				
				System.out.println(header1+content1+header2+content2+footer);
				
			}
			
		}
		return fundList;
		
		
		
		
	}
	
	
	private static ArrayList<Savings> show(ArrayList<Savings> savingsList, int userNum) {
	
		int count = 0;
		
		String header1 = String.format("[%s]\t [%s]\n ","상품번호","상품명");
		String header2 = String.format("[%s]\t [%s]\n","수익률","가입규모");
		String footer = "_____________________________________________\n";
		
		
		for (Savings object : savingsList) {
			
			if (userNum == object.getUserNum()) {
				count++;
				object.setSavingsSequence(count);
				
				String content1 = String.format("%s\t %s\n",object.getSavingsSequence(),object.getSavingsName());

				String content2 = String.format("%.2f\t %s\n", object.getRate(), object.getSavingsMoney());
				
				
				System.out.println(header1+content1+header2+content2+footer);
				
			}
			
		}
		return savingsList;
		
		
		
		
	}

}
