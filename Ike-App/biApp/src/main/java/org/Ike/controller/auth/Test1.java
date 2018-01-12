package org.Ike.controller.auth;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	
	public String nnrtn3(){
		System.out.println("2");
		return null;
	}
	
	public static void mains(String[] args){
		long temp = 0l;
		long count = 0l;
		String tempv;
		for(long i =0l;i<100000000l;i++){
			temp = i*i;
			tempv = String.valueOf(temp);
			if(temp>10000000000000l){
				break;
			}
			if(tempv.endsWith("0")||tempv.endsWith("5")){
				count+=1l;
			}
		}
		
		//632456
		System.out.println(count);
	}
	
	public static void main(String[] args){
		Map<String,String> t1 = new HashMap<String,String>();
		t1.put("1", "a");
		t1.put("2", "b");
		t1.put("3", "c");
		t1.put("4", "1d");
		t1.put("5", "2d");
		t1.put("6", "3d");
		t1.put("7", "4d");
		t1.put("8", "5d");
		t1.put("8", "6d");
		t1.put("10", "7d");
		t1.put("11", "8d");
		t1.put("12", "9d");
		t1.put("13", "d");
		t1.put("14", "d");
		t1.put("15", "d");
		
	}

}
