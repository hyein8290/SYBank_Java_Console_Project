package com.group1.bankproject.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.group1.bankproject.MyPath;

/**
 * Join 클래스, Login 클래스에서 회원가입 선택 시 구현되는 클래스 (userjoin() 예외처리 완료함)
 * @author 1조
 *
 */
public class Join {
	
	private static Scanner scan;
	private static int num; //회원가입 정보 > 'num' 항목 데이터 덮어쓰기 위함.
	
	static { 
		
		scan = new Scanner(System.in); 
		
		try {
			BufferedReader reader 
			= new BufferedReader(new FileReader(MyPath.USERDATA));
			String line = null;
			while ((line = reader.readLine()) != null) {   
				String[] temp = line.split(",");
				num = Integer.parseInt(temp[0]); 
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //회원가입 정보 > 'num' 항목 데이터 덮어쓰기 위함 > 데이터 파일 순서대로 덮어쓰기 위함. (static > try-catch 전체)
	
	static void userjoin() throws IOException {
		
		clearScreen();
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		
		String id="", password="", name="", jumin="", address="", tel="", debt="";
		boolean check = true;
		//clearScreen();
		System.out.println();
		System.out.println();
		header("3. 회원가입");
		System.out.println();
		
		while (check) {
			System.out.print("아이디 (4~16자 이내) : ");
			id = scan.nextLine();
			if (userIDCheck(id)) { continue;} break; }
		
		while (check) {
			System.out.print("비밀번호 (4자 이내) : ");
			password = scan.nextLine();
			if (userpasswordCheck(password)) { continue;} break; }
		
		while (check) {
			System.out.print("이름 (2~5자 이내) : ");
			name = scan.nextLine();
			if (usernameCheck(name)) { continue;} break; }
		
		while (check) {
			System.out.print("주민등록번호 (13자 이내) : ");
			jumin = scan.nextLine();
			if (userjuminCheck(jumin)) { continue;} break; }
		
		//고객 데이터에 주민번호로 성별 덮어쓰기 위함.
		char ch   = jumin.charAt(6);
		String gender = getGender(jumin,ch);
		
		while (check) {
			System.out.print("주소 (ex)OO시 OO구 OO동) : ");
			address = scan.nextLine();
			if (useraddressCheck(address)) { continue;} break; }
		
		while (check) {
			System.out.print("핸드폰 번호 (ex)010-1234-5678) : ");
			tel = scan.nextLine();
			if (usertelCheck(tel)) { continue;} break; }
		
		while (check) {
			System.out.print("부채 (없을 경우 0으로 기입) : ");
			debt = scan.nextLine();
			if (userdebtCheck(debt)) { continue;} break; }
		System.out.println();
		
		try {
			
			BufferedWriter writer 
			= new BufferedWriter(new FileWriter(MyPath.USERDATA, true));
			
			num++;
			
			//아이디,비밀번호,이름,주소,주민등록번호,핸드폰번호,부채 //1000,zzo6679,8194,장기현,9004152796396,여자,천안시 강서구 장안동,010-2878-4964,15083
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
					, num, id, password, name, jumin, gender, address, tel, debt));
			
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		pause("쌍용은행 회원가입을 축하합니다.");
		clearScreen();
		UserLogin.login();
		clearScreen();
	}//userjoin
	
	private static void clearScreen() {
		for (int i = 0; i < 42; i++)
			System.out.println("");
	}
	
	private static boolean userdebtCheck(String debt) {
		
		String regex = "^[0-9]*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(debt);
		
		if (!m.find()) {
			pause("대출금액은 숫자만 입력 가능합니다. (없을 경우 0으로 기입)");
			return true;
		} 
		
		return false;
		
	}//debtCheck
	
	private static boolean usertelCheck(String tel) {
		
		String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tel);
		
		if (!m.find()) {
			pause("전화번호는 형식에 맞게 입력해주세요.\n ex) 010-1234-5678");
			return true;
		}
		
		return false;
	}//telCheck
	
	private static boolean useraddressCheck(String address) {
		
		String regex = "^[가-힣\s]{6,100}+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(address);
		
		if (!m.find()) {
			pause("주소는 형식에 맞게 입력해주세요.\n ex) OO시 OO구 OO동");
			return true;
		} 
		return false;
		
	}//addressCheck
	
	private static boolean userjuminCheck(String jumin) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		String line = null;
		
		boolean flag = true;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (jumin.equals(line.split(",")[4])) {
				flag = false;
			} 
		} 
		if (flag) {
		} else {
			pause("!주민등록번호 등록 실패 : 이미 등록된 주민등록번호 입니다.");
			return true;
		}//주민번호 중복 검사 
		
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
		
		//jumin.charAt(6);
		
	}//juminCheck
	
	
	private static boolean usernameCheck(String name) {
		
		
		String regex = "^[가-힣]{2,5}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		
		if (!m.find()) {
			pause("이름은 2~5자 이내 한글만 입력 가능합니다.");
			return true;
		} 
		
//	      if (name.length() < 2 || name.length() > 5) {
//	         System.out.println("이름은 2~5자 이내 입력 가능합니다.");
//	         return true;
//	      }
		
		return false;
		
	}//nameCheck
	
	private static boolean userpasswordCheck(String password) {
		
		String regex = "^[1-9]{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		
		if (!m.find()) {
			pause("비밀번호는 1~9사이의 4자리 숫자만 입력 가능합니다.");
			return true;
		} 
		return false;
		
	}//passwordCheck
	
	private static boolean userIDCheck(String id) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
		String line = null;
		
		boolean flag = true;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (id.equals(line.split(",")[1])) {
				flag = false;
			} 
		} 
		if (flag) {
		} else {
			pause("!아이디 등록 실패 : 이미 사용중인 아이디 입니다.");
			return true;
		}//아이디 중복 검사 
		
		if (id.length() < 4 || id.length() > 16) {
			pause("아이디는 4 ~ 16자로 입력해주세요.");
			return true;
		}
		
		for (int i = 0; i < id.length(); i++) {
			int ch = id.charAt(i); // "a" -> 'a'
			if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z') && !(id.equals("_"))) {
				pause("아이디는 영어 소문자, 숫자만 입력 가능합니다.");
				return true;
			}
		}
		
		return false;
		
	}//IDCheck
	
	
	public static String getGender(String jumin, char ch) {
		
		String gender = "";
		
		if(ch=='1' || ch=='3') {
			gender="남자";
		} else if(ch=='2' || ch =='4') {
			gender="여자";
		}
		return gender;
		
	}//getGender
	
	private static void header(String title) {
		System.out.printf("[%s]\r\n", title);
	}//header + 디자인 변경 맟춰서 +-하기 
	
	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속 진행하시려면 엔터키를 누르세요.");
		scan.nextLine();
	}//pause + 디자인 변경 맟춰서 +-하기 
	
}//join.class
