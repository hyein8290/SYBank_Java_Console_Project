package com.group1.bankproject.deposit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * 
 * 예금 계좌 내역을 조회하는 객체
 * @author 1조
 *
 */
public class FindingAccount {
	
	private static Scanner scan;
	private static final int LINE = 10;
	private static ArrayList<IndividualAccount> userAccount = new ArrayList<>();
	
	static {
		scan = new Scanner(System.in);
		userAccount = new ArrayList<>();
	}
	
	public void findAccount() {   
		
		String selectedAccount = "";
		boolean flag = false;
		int pageCount = 0;
		int selectedNum = 0;
		
		
		
		while(!flag) {
			Screen.clearScreen();
			
			System.out.println();
			Screen.equalLine();
			System.out.println("계좌 조회를 선택하셨습니다.");
			Screen.equalLine();
			
			printAccountList();
			selectedAccount = selectAccount();
			Screen.equalLine();
			
			if(selectedAccount.equals("0")) {
				System.out.println("계좌 조회을 취소하셨습니다.");
				System.out.println("이전 메뉴로 돌아갑니다.");
				pause();
				return;
			}
			
			flag = checkAccount(selectedAccount);
		}
		
		loadAccount(getFilePath(selectedAccount));
		
		Collections.sort(userAccount);
		
		pause();
		Screen.clearScreen();
		
		while(true) {
			
			printAccount(pageCount);
			
			selectedNum = selectAccountMenu();
			if(selectedNum == 1) {
				pageCount--;
			} else if(selectedNum == 2) {
				pageCount++;
			} else {
				break;
			}
			
		}
		
		Screen.clearScreen();
		
		Screen.equalLine();
		System.out.println("계좌 조회가 끝났습니다.");
		Screen.equalLine();
		
		pause();
		userAccount.clear();
	}
	
	
	private void pause() {
		System.out.println("계속 하시려면 엔터를 눌러주세요...");
		scan.nextLine();
	}
	
	
	private int selectAccountMenu() {
		
		Screen.equalLine();
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("3. 종료");
		Screen.equalLine();
		
		return input(3, 1);
		
	}
	
	
	private void printAccount(int pageCount) {
		
		int index = pageCount * LINE;
		
		Screen.clearScreen();
		
		Screen.equalLine();
		System.out.println("   [날짜]\t\t[거래유형]\t\t[금액]\t     [잔액]");
		Screen.equalLine();
		
		try {
			
			for(int i=index; i < index + LINE; i++) {
				IndividualAccount account = userAccount.get(i);
				System.out.printf("%tF\t%4s\t%,13d\t%,11d\r\n"
						, account.getTransTime()
						, account.getTransType()
						, account.getTransMoney()
						, account.getMoney());
			}
			
			Screen.equalLine();
			System.out.printf("현재 페이지: %d페이지\r\n", pageCount + 1);
			
		} catch (IndexOutOfBoundsException e) {
			Screen.equalLine();
			System.out.printf("현재 페이지: %d페이지 (마지막 페이지입니다.)\r\n", pageCount + 1);
			return;
		}
	}
	
	private boolean checkAccount(String selectedAccount) {
		
		boolean flag = false;
		int num = 0;
		
		System.out.printf("선택하신 계좌가 %s가 맞습니까?\r\n", selectedAccount);
		System.out.println("맞으면 1, 아니면 0을 눌러주세요.");
		
		num = input(1,0);
		
		Screen.equalLine();
		
		if (num == 1) {
			
			System.out.printf("%s 계좌를 조회하겠습니다.\r\n", selectedAccount);
			flag = true;
			
		} else {
			
			System.out.println("계좌를 잘못 선택하셨습니다.");
			System.out.println("계좌 선택 메뉴로 돌아갑니다.");
			pause();
			flag = false;
		}
		
		return flag;
		
	}
	
	private String selectAccount() {
		
		String selectedAccount = "";
		int num = 0;
		
		System.out.println("조회를 원하시는 계좌를 선택해주세요.");
		
		num = input(CurrentUser.getAccountList().size(), 0);
		
		if(num != 0) {
			selectedAccount = CurrentUser.getAccountList().get(num - 1);         
		} else {
			selectedAccount = "0";
		}
		
		return selectedAccount;
		
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
				System.out.println();
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	private void printAccountList() {
		
		int seq = 1;
		
		Screen.equalLine();
		System.out.printf("%s님의 계좌 목록\r\n", CurrentUser.getNum());
		Screen.minusLine();
		
		for(String account : CurrentUser.getAccountList()) {
			
			System.out.printf("%d. %s\r\n", seq++, account);
		}
		
		System.out.println("0. 뒤로 가기");
		Screen.equalLine();
	}
	
	private void loadAccount(String path) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				IndividualAccount account = new IndividualAccount();
				
				account.setTransTime(temp[0]);
				account.setTransType(temp[1]);
				account.setTransMoney(Integer.parseInt(temp[2]));
				account.setMoney(Integer.parseInt(temp[3]));
				
				userAccount.add(account);
			}
			
			reader.close();   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String getFilePath(String selectedAccount) {
		
		String path = MyPath.INDIVIDUAL_ACCOUNT;
		File dir = new File(path);
		
		File[] list = dir.listFiles();
		
		for(File file : list) {
			if(file.getName().equals(selectedAccount + ".csv")) {
				return file.getAbsolutePath();
			}
		}
		
		return null;
	}
	
}
