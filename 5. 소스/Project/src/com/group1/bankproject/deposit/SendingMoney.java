package com.group1.bankproject.deposit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.Screen;
import com.group1.bankproject.UserAccountData;
import com.group1.bankproject.UserData;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * 
 * 계좌 이체를 하는 객체
 * @author 1조
 *
 */
public class SendingMoney {
	
	private static Scanner scan;
	private static ArrayList<UserAccountData> usersAccountList;
	private static ArrayList<UserData> userList;
	private static ArrayList<String> accountList;
	
	static {
		scan = new Scanner(System.in);
		usersAccountList = new ArrayList<UserAccountData>();
		userList = new ArrayList<UserData>();
		accountList = CurrentUser.getAccountList();
	}
	
	/**
	 * 계좌 이체를 하는 메소드
	 */
	public void sendMoney() {
		
		String transAccount = "";
		int transUserNum = 0;
		int transMoney = 0;
		int balance = 0;
		String sendPath = "";
		String receivePath = "";
		int num = 0;
		int accountNum = 0;
		
		load();
		
		Screen.clearScreen();
		
		Screen.equalLine();
		System.out.println("계좌 이체를 선택하셨습니다.");
		
		while (true) {
			
			Screen.equalLine();
			transAccount = enterAccount();
			transUserNum = getTransUserNum(transAccount);
			
			if (transUserNum != 0) {
				break;
			} else {
				
				Screen.clearScreen();
				Screen.equalLine();
				System.out.println("입력하신 계좌가 존재하지 않습니다.");
				System.out.println("다시 입력하시려면 1, 뒤로 가시려면 0을 눌러주세요.");
				num = input(1,0);
				
				if(num == 0) {
					cancel();
					return;
				}
				
			}
		}
		
		Screen.clearScreen();
		Screen.equalLine();
		System.out.println("입력하신 계좌 정보");
		Screen.minusLine();
		System.out.println("이름: " + getUserName(transUserNum));
		System.out.println("계좌번호: " + transAccount);
		Screen.equalLine();
		
		System.out.println("입력하신 계좌가 맞으시면 1, 아니면 0을 눌러주세요.");
		num = input(1,0);
		
		if(num == 0) {
			cancel();
			return;
		}
		
		Screen.clearScreen();
		Screen.equalLine();
		
		transMoney = enterMoney();      
		accountNum = selectAccount();
		
		Screen.clearScreen();
		Screen.equalLine();
		System.out.printf("%s계좌를 선택하셨습니다.\r\n", accountList.get(accountNum - 1));
		
		balance = getBalance(getFilePath(accountList.get(accountNum -1)));
		
		while(transMoney > balance) {
			
			Screen.equalLine();
			System.out.println("계좌 잔액이 부족합니다.");
			System.out.println("1. 이체 금액 다시 입력");
			System.out.println("2. 이체 계좌 다시 선택");
			System.out.println("0. 뒤로 가기");
			Screen.minusLine();
			
			num = input(2,0);
			
			if(num == 1) {
				transMoney = enterMoney();
				accountNum = selectAccount();
			} else if (num == 2) {
				accountNum = selectAccount();
			} else {
				cancel();
				return;
			}
			
			Screen.clearScreen();
			Screen.equalLine();
			System.out.printf("%s계좌를 선택하셨습니다.\r\n", accountList.get(accountNum - 1));
			balance = getBalance(getFilePath(accountList.get(accountNum -1)));
		}
		
		Screen.equalLine();
		System.out.printf("나의 %s 계좌에서\r\n", accountList.get(accountNum - 1));
		System.out.printf("%s님의 %s로\r\n", getUserName(transUserNum), transAccount);
		System.out.printf("%,d원을 보내겠습니다.\r\n", transMoney);
		Screen.minusLine();
		System.out.printf("이체 뒤 나의 잔액: %,d원\r\n", (balance - transMoney));
		Screen.equalLine();
		
		System.out.println("계속 하시려면 1을, 취소하시려면 0을 눌러주세요.");
		num = input(1, 0);
		
		if(num == 0) {
			cancel();
			return;
		}
		
		sendPath = getFilePath(accountList.get(accountNum - 1));
		balance = getBalance(sendPath);
		writeTrans(sendPath, (-1) * transMoney, balance);
		
		receivePath = getFilePath(transAccount);
		balance = getBalance(receivePath);
		writeTrans(receivePath, transMoney, balance);
		
		Screen.clearScreen();
		Screen.equalLine();
		System.out.println("이체가 완료되었습니다.");
		Screen.equalLine();
		
		pause();
		
	}//sendMoney
	
	private void cancel() {
		
		Screen.clearScreen();
		Screen.equalLine();
		System.out.println("계좌 이체를 취소하셨습니다.");
		System.out.println("이전 메뉴로 돌아갑니다.");
		Screen.equalLine();
		pause();
		
	}
	
	private int selectAccount() {
		
		int balance = 0;
		int num = 0;
		int seq = 1;
		
		Screen.equalLine();
		System.out.printf("%s님의 계좌 목록\r\n", CurrentUser.getNum());
		Screen.minusLine();
		for (String account : accountList) {
			
			//balance = getBalance(getFilePath(account));
			//System.out.printf("%d. %s\t남은 잔액: %d\r\n", seq++, account, balance);
			System.out.printf("%d. %s\r\n", seq++, account);
		}
		
		Screen.equalLine();
		System.out.println("어떤 계좌에서 이체하시겠습니까? ");
		
		num = input(accountList.size(), 1);
		
		return num;
	}
	
	private int enterMoney() {
		
		int transMoney = 0;
		
		System.out.println("얼마를 이체하시겠습니까?");
		try {
			
			System.out.print("금액(원): ");
			transMoney = Integer.parseInt(scan.nextLine());
			
		} catch (Exception e) {
			System.out.println();
			System.out.println("다시 입력해주세요.");
		}
		
		return transMoney;
		
	}
	
	private void pause() {
		System.out.println("계속 하시려면 엔터를 눌러주세요...");
		scan.nextLine();
	}
	
	private void writeTrans(String filePath, int transMoney, int balance) {
		
		//현재 시간으로 설정
		Calendar now = Calendar.getInstance();
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
			
			writer.write(String.format("%tF,%s,%d,%d", now, transMoney < 0 ? "송금" : "입금",transMoney, balance + transMoney));
			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getBalance(String filePath) {
		
		Stack<Integer> balances = new Stack<>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				balances.add(Integer.parseInt(temp[3]));
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return balances.peek();
		
	}
	
	private String getFilePath(String account) {
		
		File dir = new File(MyPath.INDIVIDUAL_ACCOUNT);
		
		File[] list = dir.listFiles();
		
		for(File file : list) {
			if(file.getName().equals(account + ".csv")) {
				return file.getAbsolutePath();
			}
		}
		
		return null;
	}
	
	private String getUserName(int transNum) {
		
		String name = "";
		
		if (CurrentUser.getNum() == transNum) {
			
			//System.out.println("본인 계좌입니다.");
			name = CurrentUser.getName();
			
		} else {
			
			for (UserData user : userList) {
				if (user.getNum() == transNum) {
					//System.out.printf("%s님 계좌입니다.", user.getName());
					name = user.getName();
					break;
				}
			}
		}
		
		return name;
	}
	
	private String enterAccount() {
		
		String input = "";
		
		while(true) {
			
			try {
				
				System.out.print("입금할 계좌: ");
				input = scan.nextLine();
				
				String regex = "^\\d{3}-?\\d{3}-?\\d{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(input);
				
				if(!m.find()) {
					throw new Exception();
				}
				
				if(!input.contains("-")) {
					return input.substring(0, 3) + "-"
							+ input.substring(3, 6) + "-"
							+ input.substring(6);               
				}
				
				return input;
				
				
			} catch (Exception e) {
				
				Screen.minusLine();
				System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
				
			}
			
		}
		
	}
	
	private static void load(){
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERACCOUNTDATA));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				UserAccountData account = new UserAccountData();
				
				account.setNum(Integer.parseInt(temp[0]));
				account.setAccount(temp[1]);
				
				usersAccountList.add(account);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private int getTransUserNum(String transAccount) {
		
		for(UserAccountData account : usersAccountList) {
			
			if(account.getAccount().equals(transAccount)) {
				return account.getNum();
			}
		}
		
		return 0;
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
	
}
