package com.liang.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternGroup {
	public static void main(String[]args){
		String poem=
				"Twas brillig, and the slithy toves\n"
				+ "Did gyre and gimble in the wabe";
		Pattern p=Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$");
		Matcher m=p.matcher(poem);
		while(m.find()){
			for(int j=0;j<m.groupCount();j++){
				System.out.print("["+m.group(j)+"]");
			}
			System.out.println();
		}
	}
}
