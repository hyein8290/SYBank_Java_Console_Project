package com.group1.bankproject.additionalWork;

import java.util.Scanner;
/**
 * 
 * @author 1조
 * 주휴수당을 계산하기위한 클래스 입니다.
 * 넘겨받은 값을 계산하기위한 클래스이며, 그외의 기능은 지원하지 않습니다.
 */
public class HolidayPay {
	
	private int hourPay;
	private int albaTime;
	private int weekday;
	private Scanner scan = new Scanner(System.in);
	
	public HolidayPay() {
		
	}
	/**
	 * 넘겨받은값을위한 생성자입니다.
	 * @param hourPay 시급
	 * @param albaTime 하루 근무시간
	 * @param weekday 일주일 근무일수
	 */
	public HolidayPay(int hourPay, int albaTime, int weekday) {
		this.hourPay = hourPay;
		this.albaTime = albaTime;
		this.weekday = weekday;
	}
	
	public int getHourPay() {
		return hourPay;
	}
	/**
	 * @param hourPay
	 *시급을 할당받는 값입니다.
	 */
	public void setHourPay(int hourPay) {
		if (hourPay <0) {
			return;
		}
		this.hourPay = hourPay;
	}
	public int getAlbaTime() {
		return albaTime;
	}
	/**
	 * @param albaTime
	 * 하루 근무시간을 할당받는 값입니다.
	 */
	public void setAlbaTime(int albaTime) {
		if (albaTime <0 || albaTime > 24) {
			return;
		}
		this.albaTime = albaTime;
	}
	public int getWeekday() {
		return weekday;
	}
	/**
	 * @param weekday
	 * 평일을 할당받는 값입니다.
	 */
	public void setWeekday(int weekday) {
		if (weekday < 0 || weekday > 7) {
			return;
		}
		this.weekday = weekday;
	}
	
	@Override
	public String toString() {
		return String.format("holidayPay [hourPay=%s, albaTime=%s, weekday=%s]", hourPay, albaTime, weekday);
	}
	/**
	 * 주휴수당을 계산하는 메소드입니다.
	 * 할당받은 값을 주휴수당으로 계산하여 출력합니다.
	 */
	public void calculate() {
		
		clearScreen();
		logo();
		
		line1();
		System.out.println("주휴수당");
		line2();
		
		if (this.albaTime * this.weekday < 15) {
			System.out.println("주휴수당 조건이 충족되지 않았습니다.");
		} else {
			System.out.printf(	  "주휴수당 : %,d\r\n"
								+ "주휴수당 포함 일급 : %,d\r\n"
								,this.hourPay * this.albaTime
								,((this.hourPay * this.albaTime * this.weekday) + (this.hourPay * this.albaTime))/this.weekday
									);
		}
		line1();
		pause();
	}
	
	private void pause() {
		System.out.println();
		System.out.println("계속하시려면 엔터키를 누르세요..");
		try {
			scan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void clearScreen() {
	    for (int i = 0; i < 42; i++) {
	      System.out.println("");
	    }
	}
	
	private static void line1() {
		System.out.println("====================================================");
	}

	private static void line2() {
		System.out.println("----------------------------------------------------");
	}
	
	private static void logo() {
		System.out.println(	"███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
				+ 			"██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
				+ 			"███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
				+ 			"╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
				+ 			"███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
				+ 			"╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
				+ 			"                                                   ");
		
	}
	
}
