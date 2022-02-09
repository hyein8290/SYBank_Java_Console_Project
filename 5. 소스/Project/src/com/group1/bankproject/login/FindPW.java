package com.group1.bankproject.login;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.UserData;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * FindPW 클래스, Login 클래스에서 비밀번호 찾기 선택 시 구현되는 클래스 
 * @author 1조
 *
 */
public class FindPW {
	
	private static Scanner scan;
	static { scan = new Scanner(System.in); }
	
	/**
	 * pw 클래스, 아이디 찾기에 필요한 정보 입력 후 아이디를 찾아주는 클래스
	 * @throws IOException 예외 처리 : FileNotFoundException에 대한 예외 처리 완료 (MyPath.USERDATA)
	 */
	public static void pw() throws IOException {
		
		clearScreen();
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		String id="", jumin="";
		boolean check = true;
		
		System.out.println();
		System.out.println();
		header("5. 비밀번호 찾기");
		System.out.println();
		
		while (check) {
			System.out.print("아이디 (4~16자 이내) : ");
			id = scan.nextLine();
			if (userIDCheck(id)) { continue;} break; }
		while (check) {
			System.out.print("주민등록번호 (13자 이내) : ");
			jumin = scan.nextLine();
			if (userjuminCheck(jumin)) { continue;} break; }
		System.out.println();
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		String line = null;
		
		boolean flag = false;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (id.equals(line.split(",")[1]) && jumin.equals(line.split(",")[4])) {
				flag = true;
				break;
			} 
		}
		
		if (flag) {
			pause("회원님의 비밀번호는 " + line.split(",")[2] + "입니다.");
			clearScreen();
			Login.main(null);
			clearScreen();
		} else {
			clearScreen();
			pause("!비밀번호 찾기 실패 : 아이디와 주민등록번호를 다시 입력해주세요.");
			clearScreen();
		}
		
	}//pw
	
	private static void clearScreen() {
		for (int i = 0; i < 42; i++)
			System.out.println("");
	}
	
	private static boolean userjuminCheck(String jumin) {
		
		String regex = "^[0-9]{13}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(jumin);
		
		if (!m.find()) {
			pause("주민등록번호는 숫자 13자리만 입력 가능합니다.");
			return true;
		} else if(!(jumin.charAt(6) =='1') || jumin.charAt(6) =='3' || jumin.charAt(6) =='2' || jumin.charAt(6) =='4') {
			pause("!주민등록번호 입력 실패 : 올바른 주민등록번호를 입력해주세요.");
			return true;
		} 
		return false;
		
	}//juminCheck
	
	private static boolean userIDCheck(String id) {
		
		if (id.length() < 4 || id.length() > 16) {
			pause("아이디는 4 ~ 16자로 입력해주세요.");
			return true;
		}
		
		for (int i = 0; i < id.length(); i++) {
			int ch = id.charAt(i); // "a" -> 'a'
			if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z') && !(id.equals("_"))) {
				pause("영어 소문자, 숫자만 입력 가능합니다.");
				return true;
			}
		}
		
		return false;
		
	}//IDCheck
	
	private static void header(String title) {
		System.out.printf("[%s]\r\n", title);
	}//header + 디자인 변경 맟춰서 +-하기 
	
	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속 진행하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}//pause + 디자인 변경 맟춰서 +-하기 
	
}//findPW.class



