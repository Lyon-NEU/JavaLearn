package com.liang.algo;
import static java.lang.Math.*;

public class SequencePrefix {
	
	private static String getString(int n){
		char[] buf=new char[(int)floor(log(25*(n+1))/log(26))];
		for(int i=buf.length-1;i>=0;i--){
			n--;
			buf[i]=(char)('A'+n%26);
			n/=26;
		}
		return new String(buf);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getString(10));
	}

}
