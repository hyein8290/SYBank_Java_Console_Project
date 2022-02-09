package com.group1.bankproject.bankproduct;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * 펀드 가입 / 뒤로가기 중 선택하는 클래스입니다.
 * @author 1조
 *
 */

public class FundMain {
	
	/**
	 * 펀드 가입 서비스를 실행하는 main 메소드입니다.
	 * @author 1조
	 */
	
	public static void main(String[] args) {
		
		
		
				
		//print figlet
		Screen.clearScreen();
		Scanner scan = new Scanner(System.in);
		
		Liner.equalLine();
		
		System.out.println("\n펀드상품 메인화면을 시작합니다.\n");
		System.out.println("    원하시는 서비스를 선택해주세요.");
		
		Liner.minusLine();
		
		System.out.println("1. 펀드 가입");
		System.out.println("2. 뒤로가기");

		Liner.equalLine();
		
		System.out.print("선택(번호) : ");
		String sel = scan.nextLine();
		
		Liner.clearScreen();
		
		
		if (sel.equals("1")) {
			
			
			Liner.equalLine();
			
			System.out.println("\n펀드상품 목록 화면을 시작합니다.\n");
			System.out.println("    원하시는 상품을 선택해주세요.");
			
			Liner.minusLine();
			
			String path_FundListData = MyPath.FUNDPRODUCT;
			printFundList(path_FundListData);
			
			
			Liner.equalLine();
			
			System.out.print("선택(번호) : ");
			String selFund = scan.nextLine();
			
			Liner.minusLine();
			
			System.out.print("금액입력(만원) : ");
			String selMoney = scan.nextLine();
			
			
			boolean already = have(selFund);
			
			
			if (already == true) {
				System.out.println("이미 해당 상품에 가입되어 있습니다. 다른 상품을 선택하여 주세요");
				
				Liner.clearScreen();
				
				main(null);
			}else {
				
				
				
				
				UserManage test = new UserManage();
				test.createFund(CurrentUser.getNum(),Integer.parseInt(selFund),Integer.parseInt(selMoney));
				
				Liner.equalLine();
				
				System.out.println("    구입 완료.");
				Liner.equalLine();
				
				Liner.clearScreen();
				main(null);
				
			}
			
			
		
		
		}else if (sel.equals("2")){
			//대출 클래스 생성자
			//대출 클래스 실행메소드
			ProductMain.main(null);
			
		}else {
			
			System.out.println("\n\n유효하지 않은 번호입니다. 다시 선택해주세요.\n\n");
			
			Liner.clearScreen();
			
			main(null);
			
		}
		
		
		
		
		
		
	}//main



	private static boolean have(String selFund) {
		
		try {
			
			String path_userFundData = MyPath.USERFUNDDATA;
			
			
			
			Scanner scan = new Scanner(new File(path_userFundData));
			ArrayList<String> user = new ArrayList<String>();
			Set<String> set = new HashSet<String>();
			String str = "";
					
			while (scan.hasNextLine()) {
				
				String line = scan.nextLine();
				
				user.add(line);
			}
			
			
			for (String line : user) {
				
				String[] fundInfo = line.split(",");
				
				
				
				if (fundInfo[0].equals(Integer.toString(CurrentUser.getNum())) &&
					fundInfo[2].equals(selFund)	) {
					
					return true;
					
				}
				
				}
		}catch (Exception e) {
				System.out.println(e.toString());
			}
		
		return false;
	}



	private static void printFundList(String path_FundListData) {
		try {
			
			Scanner scan = new Scanner(new File(path_FundListData));
			
			String header1 = String.format("[%s]\t [%s]\n ","상품번호","상품명");
			String header2 = String.format("[%s]\t [%s]\t [%s]\n","수익률","가입기간","수수료");
			String footer = "_____________________________________________\n";
			
			
			while (scan.hasNextLine()) {
				
				String[] arr = scan.nextLine().split(",");
				String content1 = String.format("%s\t %s\n",arr[0],arr[1]);

				String content2 = String.format("%s\t %s\t\t %s\n", arr[2],arr[3],arr[4]);
				
				
				System.out.println(header1+content1+header2+content2+footer);
				
			}
			
			scan.close();
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
	}


	
	
}//class
