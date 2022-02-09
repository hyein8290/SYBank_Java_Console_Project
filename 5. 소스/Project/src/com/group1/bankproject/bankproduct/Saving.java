
package com.group1.bankproject.bankproduct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

import com.group1.bankproject.MyPath;
import com.group1.bankproject.additionalWork.CurrentUser;

/**
 * Saving 클래스입니다. 적금 상품 가입 서비스에 사용됩니다.
 * @author kujun-kang
 *
 */
public class Saving {

	
	private static Scanner scan;
	private static int selectProductNum;
	private static int perMoney;
	private static int num;
	
	static {
		scan = new Scanner(System.in);
		num = CurrentUser.getNum();
	}
	//---------------------------------------------------------------------
	/**
	 * 적금 상품 가입 서비스를 제공하는 프로그램 진입점입니다.
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
			System.out.println("====================================================");
			main(); 								//상품 1~10번 화면
			System.out.println("————————————————————--------------------------——————");
			int input = scanner(); 					//화면에서 숫자 입력받기
			clearScreen();
			selectProductNum = input;				//유효성검사
			
			if (input == 0 || input ==1 || input ==2 || input ==3 || input ==4 || input ==5 || input ==6 || input ==7 || input == 8 || input ==9 || input ==10) {
				if (input == 1) {
					//System.out.println("====================================================");
					explaion(); 					//선택된 상품 상세설명창
					input = scanner();
						if(input ==1 || input ==2) {//유효성검사
							if (input == 1) {
								perMoney = perMonth();//월납입금 입력 
									if(perMoney >0 && perMoney <=50) {
										add();		//고객적금계좌데이터에 입력
										pause("[가입]을 환영합니다!");
										
										clearScreen();
										pause("메인화면으로 돌아가겠습니다.");
										clearScreen();
										continue;
									} else {
										System.out.println();
										System.out.println("[오류] 월 납입금은 최소 1만원 부터 최대 50만원까지입니다.");
										pause("[선택화면]으로 돌아갑니다.");
										clearScreen();
										continue;
									}
								
							}
							else if (input == 2) {	//적금가입 거부시
								System.out.println("아니요를 선택하셨습니다.");
								pause("[선택화면]으로 돌아갑니다.");
								clearScreen();
								}
							
						}
							else {						//적금가입에서 1,2 외 다른거 입력시
							System.out.println();
							System.out.println("[오류] 1과 2만 입력하실 수 있습니다.");
							System.out.println();
							pause("[선택화면]으로 돌아갑니다");
							continue;
						}
						
					}
				if (input == 7) {
					explaion2(); 					//선택된 상품 상세설명창
					input = scanner();
						if(input ==1 || input ==2) {//유효성검사
							if (input == 1) {
								perMoney = perMonth();//월납입금 입력 
									if(perMoney >0 && perMoney <=10) {
										add();		//고객적금계좌데이터에 입력
										pause("[가입]을 환영합니다!");
										
										pause("메인화면으로 돌아가겠습니다.");
										clearScreen();
										break;
									} else {
										System.out.println();
										System.out.println("[오류] 월 납입금은 최소 1만원 부터 최대 10만원까지입니다.");
										pause("[선택화면]으로 돌아갑니다.");
										clearScreen();
										continue;
									}
								
							}
							else if (input == 2) {	//적금가입 거부시
								System.out.println("아니요를 선택하셨습니다.");
								pause("[선택화면]으로 돌아갑니다.");
								clearScreen();
								}
							
						}
							else {						//적금가입에서 1,2 외 다른거 입력시
							System.out.println();
							System.out.println("[오류] 1과 2만 입력하실 수 있습니다.");
							System.out.println();
							pause("[선택화면]으로 돌아갑니다");
							continue;
						}
				}
					if (input == 0) {
						clearScreen();
						System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
								+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
								+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
								+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
								+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
								+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
								+ "                                                   ");
						System.out.println("====================================================");
						main2(); //상품 11~20번 화면
						System.out.println("————————————————————--------------------------——————");
						input = scanner();
						clearScreen();
							if (input == 0) {
								continue;
							}else {
								System.out.println("[오류] 화면에 출력되는 숫자만 입력하실 수 있습니다.");
								pause("[선택화면]으로 돌아갑니다");
							}
						
					}
					
					} 
			else if (input == 99) {
				ProductMain.main(null);
			}
						else {
					System.out.println();
					System.out.println("[오류] 화면에 출력되는 숫자만 입력하실 수 있습니다.");
					System.out.println();
					
					pause("[선택화면]으로 돌아갑니다");
				}
				
			
//			break;
		}

	}
	//---------------------------------------------------------------------
	

	
	private static void clearScreen() {
	    for (int i = 0; i < 43; i++)
	      System.out.println("");
}
	
	private static void add() {

		
		Random rnd = new Random();
		//현재 로그인되어있는 고객 번호 
		//num = CurrentUser.getNum();
		//저축계좌번호  (하이픈 없이 10자리)
		String savingAccount = String.format("%s", "112" + (rnd.nextInt(899)+100) + (rnd.nextInt(8999)+1000));
		System.out.println("고객님의 적금계좌번호는 [" + savingAccount.substring(0,3)
												+"-" +savingAccount.substring(3,6) 
												+"-" +savingAccount.substring(6,10) + "] 입니다.");
		//선택한 적금상품번호
//		selectProductNum
		//월 납입금액 
//		perMoney
		
		//가입날짜
		LocalDate joinDay = LocalDate.now();
		LocalDate nowDay = LocalDate.now();
		//LocalDate nowDay = LocalDate.of(2023, 10, 1);
		
		LocalDate startDate = nowDay;
		LocalDate endDate = joinDay;
		
		//12개월부터는 1로 나오게됨
//		Period period = Period.between(endDate, startDate);
//		System.out.println(period.getMonths());
		
		//개월수 무한 중첩
//		System.out.println(ChronoUnit.MONTHS.between(endDate, startDate));
		
		
		
		//고객적금계좌저장 
		//고객번호,적금계좌번호,적금상품번호,월납입금액,계좌총금액,가입날짜
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(MyPath.USERSAVINGDATA, true));
			
			
			writer.write(String.format("%d,%s,%d,%d,%d,%s\n"
										, num
										, savingAccount.substring(0,3)
										+"-" +savingAccount.substring(3,6) 
										+"-" +savingAccount.substring(6,10)
										, selectProductNum
										, perMoney*10000
										, (ChronoUnit.MONTHS.between(endDate, startDate)+1*(perMoney*10000))
										, joinDay));
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static int perMonth() {
		System.out.print("월 납입금을 정해주세요(만원) : ");
		Scanner sc = new Scanner(System.in);
		try {
			int inputNum = sc.nextInt();
			return inputNum;
		} catch (Exception e) {
		}
		return 0;
	}

	private static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요..");
		scan.nextLine();
	}

	private static void explaion2() {
		System.out.println();
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		System.out.println("====================================================");
		System.out.println("선택하신 상품의 상세 페이지입니다.");
		System.out.println("————————————————————--------------------------——————");
		System.out.println("[번호]\t[상품명]\t\t    [금리율]\t[가입기간]");
		System.out.println("7	DreamBig정기적금(10만원)   	    6.9	     12");
		System.out.println("====================================================");
		System.out.println("\n"
				+ "복잡하지 않고 간단한 적금\n"
				+ "언제 어디서나 쉽고 빠르게!\n"
				+ "이 예금은 예금자 보호법에 따라 예금보험 공사가 보호하되,\n"
				+ "보호 한도는 본 은행에 있는 귀하의 모든 예금보호 대상 금융상품의\n"
				+ "원금과 소정의 이자를 합하여 1인당 “최고 5천만원”이며,\n"
				+ "5천만원을 초과하는 나머지 금액은 보호하지 않습니다. \n"
				+ "적립금액 월 최대 10만원\n"
				+ "가입기간 12개월\n"
				+ "만기시 예상 최대 지급액 : " + (int)((10*12)+((10*12)*0.069)) + "만원\n"
				+ "가입하시겠습니까? (예:1/아니요:2)\n"
				+ "");
		System.out.println("————————————————————--------------------------——————");
	}
	
	
	private static void explaion() {
		System.out.println();
		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ "                                                   ");
		System.out.println("====================================================");
		System.out.println("선택하신 상품의 상세 페이지입니다.");
		System.out.println("————————————————————--------------------------——————");
		System.out.println("[번호]\t[상품명]\t\t   \t[금리율]\t[가입기간]");
		System.out.println("1	M-Dream Big 자유적금 (모바일)     4	     12");
		System.out.println("====================================================");
		System.out.println("\n"
				+ "복잡하지 않고 간단한 적금\n"
				+ "언제 어디서나 쉽고 빠르게!\n"
				+ "이 예금은 예금자 보호법에 따라 예금보험 공사가 보호하되,\n"
				+ "보호 한도는 본 은행에 있는 귀하의 모든 예금보호 대상 금융상품의\n"
				+ "원금과 소정의 이자를 합하여 1인당 “최고 5천만원”이며,\n"
				+ "5천만원을 초과하는 나머지 금액은 보호하지 않습니다. \n"
				+ "적립금액 월 최대 50만원\n"
				+ "가입기간 12개월\n"
				+ "만기시 예상 최대 지급액 : " + (int)((50*12)+((50*12)*0.04)) + "만원\n"
				+ "가입하시겠습니까? (예:1/아니요:2)\n"
				+ "");
		System.out.println("————————————————————--------------------------——————");
	}

	private static void main2() {
		System.out.println("가입을 원하시는 상품의 번호를 선택하시고 상세 설명을 참고하세요.");
		System.out.println("————————————————————--------------------------——————");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
			
			String line = null;
			
			System.out.println("[번호]\t[상품명]\t\t\t      [금리율][가입기간]");
			
			while((line = reader.readLine())!=null) {
				
				String[]temp = line.split(",");
				if(Integer.parseInt(temp[0]) > 10) {
					System.out.printf("%4s\t%-23s\t%s\t %s\n"
							,temp[0]
							,temp[1]
							,temp[2]
							,temp[3]);
				}
				
				
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("\t\t    이전페이지로 가시려면 '0'을 입력하세요");
	}

	private static int scanner() {
		try {
			
			System.out.print("입력해주세요 : ");
			
			Scanner sc = new Scanner(System.in);
			
			int inputNum = sc.nextInt();
			return inputNum;
		} catch (Exception e) {
			System.out.println("올바르지 않은 입력입니다.");
			System.out.println("[선택화면]으로 돌아갑니다.");
			System.out.println("계속하시려면 엔터키를 누르세요..");
			scan.nextLine();
		
			
		}
		
		return 0;
	}

	private static void main() {
		System.out.println("가입을 원하시는 상품의 번호를 선택하시고 상세 설명을 참고하세요.");
		System.out.println("————————————————————--------------------------——————");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyPath.SAVINGPRODUCT));
			
			String line = null;
			
			System.out.println("[번호]\t[상품명]\t\t\t      [금리율][가입기간]");
			
			while((line = reader.readLine())!=null) {
				
				String[]temp = line.split(",");
				if(Integer.parseInt(temp[0]) <= 10) {
					System.out.printf("%4s\t%-23s\t%s\t %s\n"
							,temp[0]
							,temp[1]
							,temp[2]
							,temp[3]);
				}
				
				
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("\t\t    다음페이지로 가시려면 '0'을 입력하세요");
		System.out.println("\t\t  상품선택 창으로 가시려면'99'을 입력하세요");
	}

}
