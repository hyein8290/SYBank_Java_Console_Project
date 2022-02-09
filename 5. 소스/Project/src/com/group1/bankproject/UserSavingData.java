package com.group1.bankproject;

import java.util.Calendar;
/**
 * UserSavingData클래스입니다. 고객 적금 계좌 데이터를 저장합니다.
 * @author 1조
 *
 */
public class UserSavingData {
	
	private int num;
	   private String savingAccount;
	   private int savingProductNum;
	   //월 납입금액, 계좌 총금액
	   private int perMonth;
	   private int savingAccoutSum;
	   private Calendar joinDate;
	   
	   /**
	    * 생성자 입니다. 원하는 값으로 객체를 생성합니다.
	    * @param num  고객번호
	    * @param savingAccount 적금계좌
	    * @param savingProductNum 적금상품번호
	    * @param perMonth 월납입금액
	    * @param savingAccountSum 계좌총금액
	    * @param joinDate 가입날짜 
	    */
	   public UserSavingData(int num, String savingAccount, int savingProductNum, int perMonth, int savingAccountSum, Calendar joinDate) {
	      this.num = num;
	      this.savingAccount = savingAccount;
	      this.savingProductNum = savingProductNum;
	      this.perMonth = perMonth;
	      this.savingAccoutSum = savingAccountSum;
	      this.joinDate = joinDate;
	            
	   }
	   /**
	    * 고객적금계좌데이터의 고객번호를 가져옵니다.
	    * @return 고객적금계좌데이터 고객번호
	    */
	   public int getNum() {
	      return num;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 고객번호를 설정합니다.
	    * @param num 고객적금계좌데이터 고객번호
	    */
	   public void setNum(int num) {
	      this.num = num;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 적금계좌번호를 가져옵니다. 
	    * @return 적금계좌번호
	    */
	   public String getSavingAccount() {
	      return savingAccount;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 적금계좌번호를 설정합니다. 
	    * @param savingAccount 고객적금계좌데이터 적금계좌번호
	    */
	   public void setSavingAccount(String savingAccount) {
	      this.savingAccount = savingAccount;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 적금상품번호를 가져옵니다. 
	    * @return 고객적금계좌데이터 적금상품번호
	    */
	   public int getSavingProductNum() {
	      return savingProductNum;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 적금상품번호를 설정합니다. 
	    * @param savingProductNum 고객적금계좌데이터 적금상품번호
	    */
	   public void setSavingProductNum(int savingProductNum) {
	      this.savingProductNum = savingProductNum;
	   }

	   
	   /**
	    * 고객적금계좌데이터의 월납입금액을 가져옵니다. 
	    * @return 고객적금계좌데이터 월납입금액
	    */
	   public int getPerMonth() {
	      return perMonth;
	   }
	   /**
	    * 고객적금계좌데이터의 월납입금액을 설정합니다. 
	    * @param perMonth 고객적금계좌데이터 월납입금액
	    */
	   public void setPerMonth(int perMonth) {
	      this.perMonth = perMonth;
	   }

	   /**
	    * 고객적금계좌데이터의 계좌총금액을 가져옵니다.
	    * @return 고객적금계좌데이터 계좌총금액
	    */
	   public int getSavingAccoutSum() {
	      return savingAccoutSum;
	   }

	   /**
	    * 고객적금계좌데이터의 계좌총금액을 설정합니다. 
	    * @param savingAccoutSum 고객적금계좌데이터 계좌총금액
	    */
	   public void setSavingAccoutSum(int savingAccoutSum) {
	      this.savingAccoutSum = savingAccoutSum;
	   }
	   
	   /**
	    * 고객적금계좌데이터의 가입날짜를 가져옵니다.
	    * @return 고객적금계좌데이터 가입날짜
	    */
	   public Calendar getJoinDate() {
	      return joinDate;
	   }
	   /**
	    * 고객적금계좌데이터의 가입날짜를 설정합니다.
	    * @param joinDate 고객적금계좌데이터 가입날짜
	    */
	   public void setJoinDate(Calendar joinDate) {
	      this.joinDate = joinDate;
	   }
	   /**
	    * 고객적금계좌데이터 객체의 상태를 문자열로 변환합니다.
	    */
	   @Override
	   public String toString() {
	      return String.format(
	            "UserSavingData [num=%s, savingAccount=%s, savingProductNum=%s, perMonth=%s, savingAccoutSum=%s, joinDate=%s]",
	            num, savingAccount, savingProductNum, perMonth, savingAccoutSum, joinDate);
	   }

}
