 package com.liang.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

public class StringDemo {
	public static int inc(int x){
		try{
			x=1;
			return x;
		}catch(Exception e){
			x=2;
			return x;
		}finally{
			x=3;
		}
	}
    public static String getSolrDate(String dateStr) {
        SimpleDateFormat sdf  =   new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date date = null;
        if(dateStr ==  null)date=new Date();
        else{
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));  //如果不设置日期，在时间在00-08的时候，会出现差一天的情况
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String result = sdf1.format(date) + "T" + sdf2.format(date) + "Z";
        return result;
    }
    public static List<Integer>findKClosestElements(List<Integer>arr,int k,int x){
    	Collections.sort(arr,(a,b)->a==b?a-b:Math.abs(a-x)-Math.abs(b-x));
    	arr=arr.subList(0, k);
    	arr.stream().forEach(a->System.out.print(a));
    	Collections.sort(arr);
    	System.out.println();
    	arr.stream().forEach(a->System.out.print(a));
    	return arr;
    }
	public static void main(String[]args) throws ParseException{
		String test="acount=? and uu =? or n=?";
		String[]tmp=test.split("and|or");
		Stream.of(tmp).forEach(x->System.out.println(x.length()));
		
		char[] foo, bar; 
		foo = new char[] {'a','b','c'}; 
		bar = new char[] {'a','b','c'}; 
		System.out.println(foo.hashCode() == bar.hashCode() ? "equal" : "not equal"); //false 
		System.out.println(foo.equals(bar) ? "equal" : "not equal"); //false
		System.out.println(Arrays.equals(foo, bar));  //true
		
		System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));  //-128-127预先缓存
		System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
		System.out.println(Integer.parseInt("128")==Integer.valueOf("128")); //将Integer对象自动拆箱
		
		System.out.println("CPU:"+Runtime.getRuntime().availableProcessors());
		
		String a="";
		if(a.isEmpty()){
			System.out.println("null");
		}
		int x=0;
		System.out.println(inc(x));
		System.out.println(x);
		
		System.out.println(getSolrDate("2017-06-01 07:49:31"));
		
		assert true:"error y";
		
		System.out.println(new Date());
		SimpleDateFormat sdf  =   new  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'" );
		System.out.println(sdf.format(new Date()).toString());
		
		List<Integer>arr=new LinkedList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		findKClosestElements(arr,4,3);
	}
}
