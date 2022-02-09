package com.group1.bankproject;

public class Screen {

	public static void clearScreen() {
		for (int i = 0; i < 42; i++) {
			System.out.println("");
		}

		System.out.println("███████╗██╗   ██╗██████╗  █████╗ ███╗   ██╗██╗  ██╗\r\n"
						 + "██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝\r\n"
						 + "███████╗ ╚████╔╝ ██████╔╝███████║██╔██╗ ██║█████╔╝ \r\n"
						 + "╚════██║  ╚██╔╝  ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ \r\n"
						 + "███████║   ██║   ██████╔╝██║  ██║██║ ╚████║██║  ██╗\r\n"
						 + "╚══════╝   ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝\r\n"
						 + "                                                   ");

	}
	
	public static void equalLine() {
		System.out.println("====================================================");
	}

	public static void minusLine() {
		System.out.println("----------------------------------------------------");
	}
}
