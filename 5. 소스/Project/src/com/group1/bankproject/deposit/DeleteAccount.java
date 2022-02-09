package com.group1.bankproject.deposit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.Screen;
import com.group1.bankproject.additionalWork.CurrentUser;


/**
 * 
 * 예금 계좌를 해지하는 클래스
 * @author 1조
 *
 */
public class DeleteAccount {

	private static int num;
	private static String CurrentUserNum;
	private static Scanner scan;
	private static String deleteAccountNumber;
	private static String sendingAccountNumber;
	private static String remainingMoney;
	private static String sendingAccountRemainingMoney;
	private static int number;
	
	static {
		num = CurrentUser.getNum();
		CurrentUserNum = String.valueOf(num);
		scan = new Scanner(System.in);
		deleteAccountNumber ="";
		sendingAccountNumber ="";
		remainingMoney ="";
		sendingAccountRemainingMoney ="";
		number = 1;
		
	}
	//---------------------------------------------------------------------
	//
	/**
	 * 계좌 해지 프로그램 진입점입니다.
	 * @param args
	 */
	public static void main(String[] args) {

		boolean loop = true;
		
		while(loop) {
			clearScreen();
			System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
					+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
					+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
					+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
					+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
					+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
					+ "                                                   ");
			nowUserName();								//현재 로그인한 유저 이름 출력
			deleteAccountList();						//삭제할 계좌 출력
			if (number <= 2) {							//계좌 개수 2개미만인사람 해지불가
				System.out.println("계좌의 개수가 2개 이상부터 삭제 가능합니다.");
				pause("이전메뉴로 돌아갑니다");
				clearScreen();
				break;
			}
			
			infoMenu();									//상세설명 1

			deleteAccountNumber = scanner();			//삭제할 계좌 번호 입력
				
			if (deleteAccountNumber.equals("0")) {
					clearScreen();						//콘솔지우개
					break;
					}
				if(deleteAccountNumber.length() == 12) {
					
					clearScreen();
					remainingBalance();							//삭제할 계좌 잔액 확인
					infoMenu2();								//상세 설명 2 
					sendingAccountNumber = scanner();			//잔금 입금할 계좌 선택
						if (sendingAccountNumber.equals("0")) {
							clearScreen();						//콘솔지우개
							continue;
						}
					sendingAndDelete();							//입금, 삭제처리
					//accountFileDelete();						//*****(주의)****
					pause("최초 화면으로 돌아갑니다. ");
					clearScreen();								//콘솔지우개
				}
				else {
					clearScreen();	
					System.out.println("[입력오류] 입니다.");
					System.out.println("계좌번호는 하이픈('-')까지 총 12자리입니다. ");
					pause("최초 화면으로 돌아갑니다.");
					clearScreen();	
				}
				
			
		}
		
	}
	private static void accountFileDelete() {
		
		File FileDeleteIndividualAccount = new File(MyPath.INDIVIDUAL_ACCOUNT+ deleteAccountNumber +".csv");
		if(FileDeleteIndividualAccount.exists()) {
			FileDeleteIndividualAccount.delete();
		}
		
	}
	
	
	
	//---------------------------------------------------------------------


	private static void clearScreen() {
		    for (int i = 0; i < 43; i++)
		      System.out.println("");
	}
	

	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요..");
		scan.nextLine();
	}
	
	private static void sendingAndDelete() {
		
		FileInputStream in2;
		try {
			in2 = new FileInputStream(MyPath.INDIVIDUAL_ACCOUNT+ sendingAccountNumber +".csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(in2));
		 
		  String strLine = null, tmp;
		  String lastLine = null;
		  while ((tmp = br.readLine()) != null)
		  {
		     strLine = tmp;
		     lastLine = strLine;
		  }
		 
		  	String[] temp = lastLine.split(",");
		    sendingAccountRemainingMoney = temp[3];
		 
		  in2.close();
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//---------------------------------------------------------------------
		
		LocalDate today = LocalDate.now();
		String transType = "입금";
		int transMoney = Integer.parseInt(remainingMoney);
		int allReadyMoney = Integer.parseInt(sendingAccountRemainingMoney);
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(MyPath.INDIVIDUAL_ACCOUNT+ sendingAccountNumber +".csv", true));
			writer.write(String.format("%s,%s,%d,%d\n"
								,today
								,transType
								,transMoney
								,(transMoney + allReadyMoney)));
		
		writer.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		clearScreen();
		pause("잔액 입금 완료");
		clearScreen();
		pause("계좌 해지 진행 하겠습니다. ");
		
		//---------------------------------------------------------------------
		//실질적인 삭제부분
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERACCOUNTDATA));
			String txt = "";
			String line = null;
			
			while ((line = reader.readLine()) !=null) {
				if (!deleteAccountNumber.equals(line.split(",")[1])) {
					txt += line +"\n";
				}
					
			}
			reader.close();
			
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(MyPath.USERACCOUNTDATA));
			
			writer2.write(txt);
			writer2.close();
			clearScreen();
			
			pause("삭제완료");
			clearScreen();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void infoMenu2() {
		System.out.println();
		deleteAccountList();
		System.out.println("이전 메뉴로 돌아가시려면 '0' 을 입력해주세요.");
		System.out.println("————————————————————————————————————————————————————");
		System.out.println();
		System.out.println("해지하실 계좌를 제외한 잔액을 입금할 계좌번호를 입력해주세요. ");
		System.out.println("하이픈(-)까지 정확하게 입력 ");
		System.out.println("————————————————————————————————————————————————————");
		
	}

	private static void remainingBalance() {
		System.out.println();
		//계좌에 남은 잔액 확인 
		 FileInputStream in;
		try {
			in = new FileInputStream(MyPath.INDIVIDUAL_ACCOUNT+ deleteAccountNumber +".csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 
		  String strLine = null, tmp;
		  String lastLine = null;
		  while ((tmp = br.readLine()) != null)
		  {
		     strLine = tmp;
		     lastLine = strLine;
		  }
		 
		  	String[] temp = lastLine.split(",");
		  	clearScreen();
		  	System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
					+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
					+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
					+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
					+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
					+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
					+ "                                                   ");
		  	System.out.println("====================================================");
		    System.out.printf("해지할 계좌의 잔액은 [%s]원 입니다.\n"
						,temp[3]);
		    remainingMoney = temp[3];
		    System.out.println("————————————————————————————————————————————————————");
		 
		  in.close();
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void infoMenu() {
		
		System.out.println("이전 메뉴로 돌아가시려면 '0' 을 입력해주세요.");
		System.out.println("————————————————————————————————————————————————————");
		System.out.println();
		System.out.println("해지할 계좌번호를 입력해주세요. ");
		System.out.println("하이픈(-)까지 정확하게 입력 ");
		System.out.println("====================================================");
		
	}

	private static String scanner() {
			System.out.print("입력해주세요. : ");
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();

			return userInput;
	}

	private static void deleteAccountList() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERACCOUNTDATA));
			
			String line = null;
			System.out.println("[계좌번호]");
			number =1;
			while ((line = reader.readLine()) !=null) {
				String[] temp = line.split(",");
				if (CurrentUserNum.equals(temp[0])) {
					System.out.printf("- [%d]%s\n"
						,number++
						,temp[1]);
					//number++; //계좌 개수 새는 용도
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println();
	}

	private static void nowUserName() {
		System.out.println("====================================================");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.USERDATA));
			
			String line = null;
			
			while ((line = reader.readLine()) !=null) {
				String[] temp = line.split(",");
				if (CurrentUserNum.equals(temp[0])) {
					System.out.printf("[%s]"
						,temp[3]);
				}
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(" 고객님 안녕하세요 ");
		System.out.println("————————————————————————————————————————————————————");
	}
		
	

}

