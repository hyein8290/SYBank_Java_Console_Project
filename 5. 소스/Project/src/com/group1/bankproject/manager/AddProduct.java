package com.group1.bankproject.manager;

import java.util.Scanner;
public class AddProduct {
	
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	
	public static void add() throws Exception {
		
		boolean loop = true;
		
		while(loop) {
			blank();
			menu1();
			
			System.out.print("업무 번호 선택: ");
			
			String sel = scan.nextLine();			
		
			if (sel.equals("1")) {						
				//addProductSaving aps = new addProductSaving();
				AddProductSaving.allofSave();
				
			} else if (sel.equals("2")) {
				//적금상품 추가				
				//addProductFund apf = new addProductFund();
				AddProductFund.allofFund();
				
			} else {
				System.out.println("뒤로가기");
				loop = false;
			}
			}	
	}
	
	private static void menu1() {
		blank();
		System.out.println("====================================================");
		System.out.println("관리자 -> 적금,대출 펀드 상품 추가/삭제");
		System.out.println("----------------------------------------------------");

		System.out.println("1. 적금 상품 추가/삭제");		
		System.out.println("2. 펀드 상품 추가/삭제");		
		System.out.println("3. 뒤로가기");		
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
