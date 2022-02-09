package com.group1.bankproject.manager;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.group1.bankproject.MyPath;

public class AddProductSaving {
	private static int index;
	private static Scanner scan;
	static {
		scan = new Scanner(System.in);      
		index = 0;
	}
	public static void allofSave() throws Exception {
		
		try {
			boolean loop = true;
			
			while(loop) {
				
				blank();
				menu2();
				System.out.print("업무 번호 선택: ");
				
				String sel = scan.nextLine();         
				
				if (sel.equals("1")) {   
					savingAdd();
					
				} else if (sel.equals("2")) {
					//적금상품 삭제            
					savingDelete();            
				} else {
					System.out.println("뒤로가기");
					loop = false;
				}
			}
		} catch (Exception e) {
			blank();
			System.out.println("잘못 입력했습니다.");
			e.printStackTrace();
		}
	}
	
	private static void savingDelete() throws Exception {
		blank();
		System.out.print("삭제할 상품 번호: ");
		String number = scan.nextLine();
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
		
		String txt = "";
		String line = null;
		
		while((line = reader.readLine()) != null) {
			if (!number.equals(line.split(",")[0])) {
				txt += line + "\r\n";
			} else if (number.equals(line.split(",")[0])) {
				index++;
			}
		}
		
		reader.close();
		
		if (index == 0) {
			System.out.println("상품이 존재하지 않습니다.");
			System.out.println("이전 화면으로 돌아갑니다.");
			AddProductSaving.allofSave();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.SAVINGPRODUCT));
		
		writer.write(txt);
		writer.close();
		blank();
		pause("적금 상품을 삭제하였습니다.");
		
		
	}
	
	
	
	private static void savingAdd() throws Exception {
		blank();
		List<SavingList> list = new ArrayList<SavingList>();
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			list.add(new SavingList(temp[0],temp[1],temp[2],temp[3]));
			
			System.out.println("[번호]\t[상품명]");
			System.out.printf("%5s\t%s\r\n", temp[0],temp[1]);
			
		}
		
		reader.close();
		
		System.out.print("추가할 상품 번호: ");
		String number = scan.nextLine();
		System.out.print("추가할 상품명: ");
		String productName = scan.nextLine();
		System.out.print("금리율: ");
		String rate = scan.nextLine();
		System.out.print("가입 기간: ");
		String period = scan.nextLine();
		
		
		list.add(new SavingList(number, productName,rate,period));
		list.sort((n1, n2) -> Integer.parseInt(n1.getNum()) - Integer.parseInt(n2.getNum()));
		//System.out.println(list);
		String txt = "";
		for (int i=0; i<list.size();i++) {
			txt += list.get(i).getNum() + "," + list.get(i).getProduct() + "," + list.get(i).getRate() + "," + list.get(i).getMon() + "\r\n";
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.SAVINGPRODUCT));
		
		writer.write(txt);
		
		writer.close();
		blank();
		pause("적금 상품을 추가하였습니다.");
		
	}
	
	private static void pause(String msg) {
		
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요.");
		scan.nextLine();
		
	}
	
	private static void menu2() {
		blank();
		System.out.println("====================================================");
		System.out.println("관리자 -> 적금,대출 펀드 상품 추가/삭제 -> 적금");
		System.out.println("----------------------------------------------------");
		
		System.out.println("1. 적금 상품 추가");      
		System.out.println("2. 적금 상품 삭제");      
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

