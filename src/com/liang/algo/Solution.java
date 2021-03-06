package com.liang.algo;

import java.util.Collections;
import java.util.List;

public class Solution {
	public List<Integer>findKClosestElements(List<Integer>arr,int k,int x){
		int n=arr.size();
		if(x<arr.get(0)){
			return arr.subList(0, k);
		}
		else if(x>=arr.get(n-1)){
			return arr.subList(n-k, k);
		}
		else{
			int index=Collections.binarySearch(arr, x);
			if(x<0)
				index=-index-1;
			int low=Math.max(0, index-k-1),high=Math.min(arr.size()-1,index+k-1);
			while(high-low>k-1){
				if(low<0||(x-arr.get(low))<=(arr.get(high)-x)){
					high--;
				}
				else if(high>arr.size()-1||(x-arr.get(low))>(arr.get(high))-x){
					low++;
				}
				else{
					System.out.println("unhandled case"+" "+low+" "+high);
				}
			}
			return arr.subList(low, high+1);
		}
	}
}
