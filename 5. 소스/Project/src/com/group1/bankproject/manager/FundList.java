package com.group1.bankproject.manager;


public class FundList {
	private String num;
	private String product;
	private String profit;
	private String mon;
	private String rate;
	public FundList() {
		
	}
	public FundList(String num, String product, String profit, String mon, String rate) {
		super();
		this.num = num;
		this.product = product;
		this.profit = profit;
		this.mon = mon;
		this.rate = rate;
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
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}
