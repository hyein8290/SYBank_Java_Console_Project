package com.group1.bankproject.bankproduct;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.group1.bankproject.MyPath;



/**
 * 
 * 환불가능한 상품 리스트를 구현한 클래스입니다.
 * 
 * @author 1조
 *
 */

public class RefundList{
	
	/**
	 * 환불가능한 적금 리스트를 생성하는 메소드입니다.
	 * 
	 */
	
	public ArrayList<Savings> savingsList() {
		
		
		try {
			
			String path_userData = MyPath.USERSAVINGDATA;
			
			 
			
			
			
			Scanner scan = new Scanner(new File(path_userData));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			
			ArrayList<Savings> savingsList = new ArrayList<Savings>();
			for (String line : user) {
				String[] userInfo = line.split(",");
				Savings savingObject = new Savings();
				savingObject.setUserNum(Integer.parseInt(userInfo[0])); //1
				savingObject.setSavingsAccount(userInfo[1]);
				savingObject.setSavingsNum(userInfo[2]);
				savingObject.setSavingsMoney(Integer.parseInt(userInfo[4]));
				savingObject.setRate(getSavingsRate(userInfo[2]));
				savingObject.setSavingsName(getSavingsName(userInfo[2]));
			
				savingsList.add(savingObject);
				
			}
			
			scan.close();
			
			return savingsList;  //ArrayList <userObject>를 return
				
			
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
			return null;
		
		
			
			
	}//List
	
	
	
	
	private String getSavingsName(String string) {
		try {
			String path = MyPath.SAVINGPRODUCT;
			String savingsName = "";
			
			
			Scanner scan = new Scanner(new File(path));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			for (String line : user) {
				String[] arr = line.split(",");
				
				if (string.equals(arr[0])){
					
					savingsName = arr[1];
					
				}
				
			
			}
			
			scan.close();
			
			return savingsName;
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		 
		return "";
	}



	private double getSavingsRate(String string) {
		
		try {
			String path = MyPath.SAVINGPRODUCT;
			double rate = 0;
			
			
			Scanner scan = new Scanner(new File(path));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			for (String line : user) {
				String[] arr = line.split(",");
				
				if (string.equals(arr[0])){
					
					rate = Double.parseDouble(arr[2])/100;
					
				}
				
			
			}
			
			scan.close();
			
			return rate;
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		 
		return 0;
	}
	

	/**
	 * 환불가능한 펀드 리스트를 생성하는 메소드입니다.
	 * 
	 */
	


	public ArrayList<Fund> fundList() {
		
		
		//add fundObject
		try {
			
			String path_userData = MyPath.USERFUNDDATA;
			
			 
			
			
			
			Scanner scan = new Scanner(new File(path_userData));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			
			ArrayList<Fund> fundList = new ArrayList<Fund>();
			for (String line : user) {
				String[] userInfo = line.split(",");
				Fund fundObject = new Fund();
				fundObject.setUserNum(Integer.parseInt(userInfo[0])); //1
				fundObject.setFundAccount(userInfo[1]);
				fundObject.setFundNum(userInfo[2]);
				fundObject.setFundMoney(Integer.parseInt(userInfo[3]));
				fundObject.setRate(getFundRate(userInfo[2]));
				fundObject.setFundName(getFundName(userInfo[2]));
			
				fundList.add(fundObject);
				
			}
			
			scan.close();
			
			return fundList;  //ArrayList <userObject>를 return
				
			
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
			return null;
		
		
			
			
	}//List

	private String getFundName(String string) {

		try {
			String path = MyPath.FUNDPRODUCT;
			String fundName = "";
			
			
			Scanner scan = new Scanner(new File(path));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			for (String line : user) {
				String[] arr = line.split(",");
				
				if (string.equals(arr[0])){
					
					fundName = arr[1];
					
				}
				
			
			}
			
			scan.close();
			
			return fundName;
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		 
		return "";
	}



	private double getFundRate(String userInfo) {
		
		
		
		try {
			String path = MyPath.FUNDPRODUCT;
			double rate = 0;
			
			
			Scanner scan = new Scanner(new File(path));
			ArrayList<String> user = new ArrayList<String>();
			
					
			while (scan.hasNextLine()) {
				user.add(scan.nextLine());
			}
			
			for (String line : user) {
				String[] arr = line.split(",");
				
				if (userInfo.equals(arr[0])){
					
					rate = Double.parseDouble(arr[2])/100;
					
				}
				
			
			}
			
			scan.close();
			
			return rate;
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		 
		return 0;
	}
	
	

}
