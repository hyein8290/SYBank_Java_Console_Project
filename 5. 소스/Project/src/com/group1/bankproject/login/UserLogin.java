package com.group1.bankproject.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.UserData;
import com.group1.bankproject.additionalWork.CurrentUser;


/**
 * UserLogin 클래스, 회원 로그인 화면
 * @author 1조
 *
 */
public class UserLogin {
	
	private static Scanner scan;
	private static ArrayList<UserData> list;
	
	static { 
		scan = new Scanner(System.in);
		list = new ArrayList<UserData>();
	}
	
	
	/**
	 * UserLogin.login 클래스, 회원 로그인 메뉴
	 * @throws IOException 예외 처리 : FileNotFoundException에 대해 예외 처리.
	 */
	public static void login() throws IOException {
		clearScreen();
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		load();
		System.out.println();		
		System.out.println();
		header("1. 로그인");
		System.out.println();
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();
		System.out.println();
		
		boolean flag = false;
		
		for (int i=0; i< list.size(); i++ ) {
			if (id.equals(list.get(i).getId()) && password.equals(list.get(i).getPassword())) {
				System.out.println("로그인에 성공했습니다.");
				CurrentUser.setName(list.get(i).getName());
				CurrentUser.setNum(list.get(i).getNum());
				CurrentUser.setDebt(list.get(i).getDebt());
				CurrentUser.setPassword(list.get(i).getPassword());
				CurrentUser.setJumin(list.get(i).getJumin());
				
				File file = new File(MyPath.USERACCOUNTDATA);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				
				while ((line = reader.readLine()) != null) {
					
					String[] temp = line.split(",");
					
					if (Integer.parseInt(temp[0]) == list.get(i).getNum()) {
						CurrentUser.setAccountList(temp[1]);;
					}
				}
				reader.close();
				
				
				clearScreen();
				UserMain.main();
				clearScreen();
				return;
			} else {
				flag = true;
			} 
			
		}//while
		
	}//login
	
	private static void load() {
		
		try {
			
			File file = new File(MyPath.USERDATA);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				UserData u = new UserData();
				
				u.setNum(Integer.parseInt(temp[0]));
				u.setId(temp[1]);
				u.setPassword(temp[2]);
				u.setName(temp[3]);
				u.setJumin(temp[4]);
				u.setAddress(temp[6]);
				u.setTel(temp[7]);
				u.setDebt(Integer.parseInt(temp[8]));
				
				list.add(u);
				
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void header(String title) {
		System.out.printf("[%s]\r\n", title);
	}//header + 디자인 변경 맟춰서 +-하기 
	
	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속 진행하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}//pause + 디자인 변경 맟춰서 +-하기 
	
	private static void clearScreen() {
	    for (int i = 0; i < 42; i++)
	      System.out.println("");
}
	
}//userLogin.class







