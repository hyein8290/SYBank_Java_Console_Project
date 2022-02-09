package com.group1.bankproject.manager;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.group1.bankproject.MyPath;


public class FindUserManager {
	//아이디 비밀번호 수정
	//조회는 user datafile 긁어오기
	private static Scanner scan;
	private static int index;
	static {
		scan = new Scanner(System.in);   
		index = 0;
	}
	
	public static void findFix() {
		boolean loop = true;
		while(loop) {
			blank();
			menu();
			index = 0;
			System.out.print("업무 번호 선택: ");         
			String sel = scan.nextLine();      
			try {
				if(sel.equals("1")) {
					//회원 조회
					list();
				} else if(sel.equals("2")) {
					//회원 찾기
					search();
				} else if(sel.equals("3")) {
					fix();
				}  else {
					loop = false;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void fix() throws IOException {
		blank();
		System.out.println("[회원 수정하기]");
		
		System.out.print("수정할 회원 번호: ");
		String num = scan.nextLine();
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		
		
		String line = null;
		
		while((line = reader.readLine()) != null) {
			
			if (num.equals(line.split(",")[0])) {
				index ++;
				break;
			}
			
		}
		
		if (index == 0) {
			pause("잘못 입력하였습니다.");
			FindUserManager.fix();
		}
		reader.close();
		
		String[] temp = line.split(",");
		
		System.out.println("기존 아이디: " + temp[1]);
		System.out.print("수정 이름(수정하지 않으려면 그냥 엔터): ");
		String id = scan.nextLine();
		if(id.equals("")) {
			id = temp[1];
		}   
		
		
		
		System.out.println("기존 비밀번호: " + temp[2]);
		System.out.print("수정 비밀번호: ");
		String password = scan.nextLine();
		
		if (password.equals("")) {
			password = temp[2];
		}
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		
		String txt = "";
		line = null;
		
		while((line = reader.readLine()) != null) {
			
			if(num.equals(line.split(",")[0])) {
				
				txt += String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", num, id, password, temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
			} else {
				txt += line + "\r\n";
			}
			
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.USERDATA));
		writer.write(txt);
		writer.close();
		
		
		pause("회원 정보를 수정했습니다.");
		
	}
	
	private static void search() throws Exception {
		blank();
		System.out.println("[회원 검색하기]");
		
		System.out.print("검색어(주소 일부분): ");
		String word = scan.nextLine();
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		
		String line = null;
		
		System.out.println("[번호]\t[아이디]\t[비밀번호]\t[이름]\t  [주민등록번호]\t[성별]\t[주소]");
		
		while((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			if (temp[6].indexOf(word) > -1) {               
				System.out.printf("%5s\t%s\t%7s\t%s\t%s\t%s\t%s\r\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				index++;
			}
		}
		
		reader.close();
		if(index ==0) {
			pause("검색하신 회원이 없습니다.");
			FindUserManager.search();
		} else {
			pause("회원을 검색했습니다.");            
		}
		
		
		
	}
	
	private static void list() throws Exception {
		blank();
		System.out.println("[회원 목록보기]");
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		
		String line = null;
		
		System.out.println("[번호]\t[아이디]\t[비밀번호]\t[이름]\t[주민등록번호]\t[성별]\t[주소]");
		
		while((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			System.out.printf("%5s\t%s\t%7s\t\t%s\t%s\t%s\t%s\r\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
			
			
		}
		
		
		reader.close();
		pause("회원 목록을 출력했습니다.");
		
	}
	
	private static void pause(String msg) {
		//잠시 휴식.. 프로그램 잠시 멈춤
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}
	
	private static void menu() {
		blank();
		System.out.println("====================================================");
		System.out.println("관리자 -> 회원 정보 조회/수정");
		System.out.println("----------------------------------------------------");

		System.out.println("1. 회원 정보 조회");      
		System.out.println("2. 회원 정보 찾기");      
		System.out.println("3. 회원 정보 수정");      
		System.out.println("4. 뒤로가기");      
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



