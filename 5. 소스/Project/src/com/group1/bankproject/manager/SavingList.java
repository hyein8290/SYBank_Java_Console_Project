package com.group1.bankproject.manager;


public class SavingList {
	
	private String num;
	private String product;
	private String rate;
	private String mon;
	
	 public SavingList() {
		
	}

	public SavingList(String num, String product, String rate, String mon) {
		this.num = num;
		this.product = product;
		this.rate = rate;
		this.mon = mon;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	@Override
	public String toString() {
		return String.format("SavingList [num=%s, product=%s, rate=%s, mon=%s]", num, product, rate, mon);
	}
	 
	

}
