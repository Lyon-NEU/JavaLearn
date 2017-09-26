package com.liang.algo;
/**
 * 查找两个有序数组的<br>中位数</br>；
 * 当数组长度为奇数是中位数为最中间的元素，当为偶数是最中间两个数的平均数;
 * 应该是两个数组排序后的第K个数，归并排序中的第K个元素
 * @author Liang
 *
 */
public class FindMedianArrays {
	public double findMedian(int []arr1,int[]arr2){
		int len1=arr1.length;
		int len2=arr2.length;
		int index=(len1+len2)/2;
		boolean isOdd=(len1+len2)%2==1;
		if(isOdd){
			return find(arr1,len1,arr2,len2,index);
		}
		else{
			return (find(arr1,len1,arr2,len2,index)+find(arr1,len1,arr2,len2,index))/2;
		}
	}
	/**
	 * 返回两个数组中的第K个元素
	 * @param arr1 
	 * @param len1
	 * @param arr2
	 * @param len2
	 * @param index
	 * @return
	 */
	public double find(int[]arr1,int len1,int[] arr2,int len2,int index){
		int i=0,j=0;
		boolean is1=false;
		boolean is2=false;
		int k;
		for(k=0;k<=index;k++){
			if(k>=len1){
				is2=true;
				j++;
			}
			else if(k>=len2){
				is1=true;
				i++;
			}
			else if(arr1[i]<arr2[j]){
				is1=true;
				i++;
			}
			else{
				is2=true;
				j++;
			}
		}
		if(j-1<0){
			return arr1[i-1];
		}
		if(i-1<0){
			return arr2[j-1];
		}
		return Math.max(arr1[i-1], arr2[j-1]);
	}
	public static void main(String[]args){
		System.out.println("Find Median Sorted Array");
	}
}
