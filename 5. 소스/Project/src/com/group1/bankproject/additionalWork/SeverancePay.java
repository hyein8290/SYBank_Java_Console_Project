package com.group1.bankproject.additionalWork;

import java.util.Scanner;
/**
 * 
 * @author 1조
 * 퇴직금을 계산하기 위한 메소드입니다.
 * 넘겨받은 값을 계산하기위한 클래스이며, 그외의 기능은 지원하지 않습니다.
 */
public class SeverancePay {
	
	private int thisMonth;
	private int lastMonth;
	private int twoMonthAgo;
	private Scanner scan = new Scanner(System.in);
	
	public SeverancePay() {
		
	}
	/**
	 * 
	 * @param thisMonth 이달 월급
	 * @param lastMonth 지난달 월급
	 * @param twoMonthAgo 지지난달 월급
	 */
	public SeverancePay(int thisMonth, int lastMonth, int twoMonthAgo) {
		this.thisMonth = thisMonth;
		this.lastMonth = lastMonth;
		this.twoMonthAgo = twoMonthAgo;
	}
	
	
	public int getThisMonth() {
		return thisMonth;
	}
	/**
	 * @param thisMonth
	 * 이번달 월급을 할당받는 값입니다.
	 */
	public void setThisMonth(int thisMonth) {
		this.thisMonth = thisMonth;
	}
	
	public int getLastMonth() {
		return lastMonth;
	}
	/**
	 * 지난달 월급을 할당받는 값입니다.
	 * @param thisMonth
	 */
	public void setLastMonth(int lastMonth) {
		this.lastMonth = lastMonth;
	}
	
	public int getTwoMonthAgo() {
		return twoMonthAgo;
	}
	/**
	 * @param thisMonth
	 * 지지난달 월급을 할당받는 값입니다.
	 */
	public void setTwoMonthAgo(int twoMonthAgo) {
		this.twoMonthAgo = twoMonthAgo;
	}
	
	@Override
	public String toString() {
		return String.format("severancePay [thisMonth=%s, lastMonth=%s, twoMonthAgo=%s]", thisMonth, lastMonth,
				twoMonthAgo);
	}
	
	public void calculate() {
		
		clearScreen();
		logo();
		
		line1();
		System.out.println("예상 퇴직금");
		line2();
		
		System.out.printf(	"예상 퇴직금은 %,d원입니다.\r\n"
				,(this.thisMonth + this.lastMonth + this.twoMonthAgo)/3);
		
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
	
	private static void clearScreen() {
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
