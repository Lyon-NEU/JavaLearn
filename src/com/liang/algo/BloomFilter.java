package com.liang.algo;

import java.util.BitSet;

public class BloomFilter {
	private static final int DEFAULT_SIZE=1<<25; 
	private static final int []seeds=new int[]{5, 7, 11, 13, 31, 37, 61};
	private BitSet bits=new BitSet(DEFAULT_SIZE);
	private SimpleHash[]func=new SimpleHash[seeds.length];
	public BloomFilter(){
		for(int i=0;i<seeds.length;i++){
			func[i]=new SimpleHash(DEFAULT_SIZE,seeds[i]);
		}
	}
	public void add(String value){
		for(SimpleHash sh:func){
			bits.set(sh.hash(value),true);
		}
	}
	public boolean contains(String value) 
	{
		if (value ==null) {
			return false;
		}
		boolean ret =true;
		for (SimpleHash f : func) 
		{
			ret = ret && bits.get(f.hash(value));
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}
class SimpleHash{
	private int capacity;
	private int seed;
	
	public SimpleHash(int capacity,int seed){
		this.capacity=capacity;
		this.seed=seed;
	}
	public int hash(String value){
		int result=0;
		int len=value.length();
		for(int i=0;i<len;i++){
			result=seed*result+value.charAt(i);
		}
		return (capacity-1)&result;
	}
}