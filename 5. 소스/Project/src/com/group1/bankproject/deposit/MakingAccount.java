package com.group1.bankproject.deposit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * 
 * 예금 계좌를 개설하는 객체
 * @author 1조
 *
 */
public class MakingAccount {
	
	private static Scanner scan;
	private static Set<String> usersAccountSet;
	
	static {
		scan = new Scanner(System.in);
		usersAccountSet = new HashSet<String>();
	}
	
	/**
	 * 예금 계좌를 개설하는 메소드
	 */
	public void makeAccount() {
		
		int num = 0;
		
		String newAccount = "";
		
		Screen.clearScreen();
		
		System.out.println();
		Screen.equalLine();      
		System.out.println("계좌 개설을 선택하셨습니다.");
		Screen.equalLine();
		
		System.out.printf("%s님 본인 인증을 부탁드립니다.\r\n", CurrentUser.getName());
		System.out.println("본인 인증을 진행하시려면 1, 뒤로 가시려면 0을 눌러주세요.");
		Screen.minusLine();
		
		num = input(1,0);
		
		Screen.equalLine();
		
		if(num == 0) {
			System.out.println("계좌 개설을 취소하셨습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
			Screen.equalLine();
			pause();
			return;
		}
		
		
		verifyPassword();
		verifyJumin();
		
		Screen.minusLine();
		System.out.println("본인 인증이 완료되었습니다.");
		Screen.equalLine();
		pause();
		Screen.clearScreen();
		
		selectPurpose();
		Screen.equalLine();
		
		System.out.println("계좌 개설을 진행합니다.");
		System.out.println("계속 하시려면 1을, 취소하시려면 0을 눌러주세요.");
		num = input(1, 0);
		
		Screen.clearScreen();
		Screen.equalLine();
		
		if(num == 0) {
			System.out.println("계좌 개설을 취소하셨습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
			Screen.equalLine();
			pause();
			return;
		}
		
		newAccount = generateAccont();
		
		makeNewAccountFile(newAccount);
		writeNewAccount(newAccount);
		
		System.out.println("계좌 개설이 완료되었습니다.");
		System.out.printf("새로운 계좌번호는 %s입니다.\r\n", newAccount);
		
		Screen.equalLine();
		pause();
		
		usersAccountSet.clear();
		
	}//makeAccount
	
	private void pause() {
		System.out.println("계속 하시려면 엔터를 눌러주세요...");
		scan.nextLine();
	}
	
	private void writeNewAccount(String newAccount) {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.USERACCOUNTDATA, true));
			
			writer.write(String.format("%s,%s", CurrentUser.getNum(), newAccount));
			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("계좌 개설을 실패하였습니다.");
		}
	}
	
	private void makeNewAccountFile(String newAccount) {
		
		try {
			
			File newAccountFile = new File(MyPath.INDIVIDUAL_ACCOUNT + newAccount + ".csv");
			FileOutputStream stream = new FileOutputStream(newAccountFile);
			
			stream.close();
			
		} catch (Exception e) {
			System.out.println("계좌 개설을 실패하였습니다.");
		}
		
	}
	
	private String generateAccont() {
		
		String newAccount = "";
		Random rnd = new Random();
		
		loadUsersAccount();
		
		do {
			newAccount = "110-" + (rnd.nextInt(900) + 100) + "-" + (rnd.nextInt(9000) + 1000);
		} while(usersAccountSet.contains(newAccount));
		
		return newAccount;
		
	}
	
	private void loadUsersAccount() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERACCOUNTDATA));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				usersAccountSet.add(temp[1]);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void selectPurpose() {
		
		Screen.equalLine();
		System.out.println("계좌 개설 목적을 선택해주세요.");
		Screen.minusLine();
		
		System.out.println("1. 급여 계좌");
		System.out.println("2. 법인 계좌");
		System.out.println("3. 모임 계좌");
		System.out.println("4. 공과금 이체 계좌");
		System.out.println("5. 아르바이트 계좌");
		System.out.println("6. 그 외의 이유");
		Screen.equalLine();
		
		input(6,1);
		
	}
	
	private int input(int max, int min) {
		
		while (true) {
			try {
				
				int input = 0;
				
				System.out.print("입력: ");
				input = Integer.parseInt(scan.nextLine());
				
				if(input > max || input < min) {
					throw new Exception();
				} else {
					return input;
				}
				
			} catch (Exception e) {   
				Screen.minusLine();
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	private void verifyJumin() {
		
		while(true) {
			
			String input = "";
			System.out.print("주민등록번호 입력(숫자만 입력):");
			input = scan.nextLine();
			
			if(!input.contains("-")) {
				
				if(input.equals(CurrentUser.getJumin().replace("-", ""))) {
					break;
				} else {
					System.out.println("잘못된 주민번호입니다. 다시 입력해주세요.");
				}
				
			} else {
				System.out.println("숫자만 입력해주세요.");
			}
			
		}
	}
	
	
	private void verifyPassword() {
		
		while(true) {
			
			String input = "";
			System.out.print("비밀번호 입력:");
			input = scan.nextLine();
			
			if(!input.equals(CurrentUser.getPassword())) {
				System.out.println("잘못된 비밀번호입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		
	}
	
	
}
