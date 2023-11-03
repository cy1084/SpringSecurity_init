package com.test.secu.utils;

public class CustomList {
	
	private String[] strs= new String[0];
	
	public int size() {
		return strs.length;
	}
	public boolean remove(int idx) { //3
		String[] tmpStrs=strs;
		strs=new String[strs.length-1];
		
		for(int i=0;i<idx;i++) {
			strs[i]=tmpStrs[i];
		}
		for(int i=idx;i<tmpStrs.length;i++) {
			strs[i-1]=tmpStrs[i];
		}
		
		return true;
	}
	public boolean add(String str) {
		String[] tmpStrs=strs;
		strs=new String[strs.length+1];
		for(int i=0;i<tmpStrs.length;i++) {
			strs[i]=tmpStrs[i];
		}
		strs[strs.length-1]=str;
		
		return true;
	}
	
	public String toString() {
		
		String pStr="[";
		for(String str:strs) {
			pStr += str+",";
		}
		
		return pStr.substring(0,pStr.length()-1)+"]";
	}
	
	public static void main(String[] args) {
		/*
		String[] strs=new String[1]; //길이 1
		strs[0]="치킨집";
		
		String[] tmpStr=strs;  //이걸 해주면 메모리를 새로 생성해도 tmpStr이 외우고 있음(2)
		strs=new String[strs.length+1]; //길이는 2로 늘었지만 메모리를 다시 생성했으므로 strs[0]은 null로 초기화(1)
		strs[0]=tmpStr[0];
		strs[1]="당구장";
		
		tmpStr=strs;
		strs=new String[strs.length+1];
		strs[0]=tmpStr[0];
		strs[1]=tmpStr[1];
		strs[2]="쿠우쿠우";
		*/
		CustomList c= new CustomList();
		System.out.println(c);
		
		c.add("1");
		c.add("2");
		c.remove(0);
		System.out.println(c);
		
		//String[] strs=new String[2];
		//strs[0]="치킨집";
		//strs[1]="당구장";
		
	}

}
