package com.liang.algo;
/**
 * 压缩子符串 eeeeeaaaff ,e5a3f2
 * @author Lyon
 * @date 2016/04/05
 */
public class CompressStr {
	public static String Compress(String str){
		String res="";
		char[]src=str.toCharArray();
		char c=src[0];
		int j=0;
		for(int i=0;i<src.length;i++){
			if(src[i]==c)
				j++;
			else {
				res+=""+c+j;
				c=src[i];
				j=1;
			}
		}
		res+=""+c+j;  //加上最后一个字符
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="eeeeeaaaffg";
		System.out.println(Compress(str));
	}

}
