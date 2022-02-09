package com.group1.bankproject.manager;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.group1.bankproject.MyPath;



public class ChangePersent {
	
	private static Scanner scan;
	static {
		scan = new Scanner(System.in);		
	}
	public static void aboutPersent() {

		
		boolean loop = true;
		
		try {
		while (loop) {
			blank();
			menu();
			System.out.print("업무 번호 선택: ");
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//적금
				saving();
			} else {
				loop = false;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private static void saving() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split(",");
			
			System.out.println("[번호]\t[상품명]");
			System.out.printf("%5s\t%s\r\n", temp[0],temp[1]);
		
		}
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
		
		System.out.print("수정할 상품 번호 입력: ");
		String num = scan.nextLine();
		
		line = null;
		String txt = "";
		
		while((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
			
			if(num.equals(temp[0])) {
				
				System.out.println("현재 이자율: " + temp[2]);
				System.out.print("이자율 변경: ");
				String change = scan.nextLine();
				
				txt += String.format("%s,%s,%s,%s\r\n", temp[0],temp[1],change,temp[3]);			
			} else {
			txt += line + "\r\n";
			}
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.SAVINGPRODUCT));
		
		writer.write(txt);
		writer.close();
	}

	//상품 목록을 보여준다.
	//상품 번호를 선택한다.
	//상품 번호의 이자율을 수정한다.
	//수정한 값을 저장한다.
	private static void menu() {
		blank();
		System.out.println("====================================================");
		System.out.println("관리자 -> 연이자율 수정");
		System.out.println("----------------------------------------------------");

		System.out.println("1. 적급 상품 선택/수정");	
		System.out.println("2. 뒤로가기");		
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
