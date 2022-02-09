package com.group1.bankproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class project {
	
	public static void main(String[] args) throws IOException {
	String password = "";
	String id1 = "";
	String id2 = "";
	String id3 = "";
	String id = "";
	List<String> passWord = new ArrayList<String>();
	String path ="C:\\class\\java\\file\\project\\비밀번호.txt";
	BufferedWriter writer
	= new BufferedWriter(new FileWriter(path));
	Random rnd = new Random();
	String[] list = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; //0,1,2
	
		for (int i=0;i<1000;i++) {
			id1 = list[(int)(Math.random()*list.length)];
			id2 = list[(int)(Math.random()*list.length)];
			id3 = list[(int)(Math.random()*list.length)];
			password = String.format("%04d\r\n", rnd.nextInt(9999));
			id = id1 + id2 + id3 + password;
			writer.write(id);
			
		}
		
		writer.close();
		
		
		
		
		
		
	}

}
