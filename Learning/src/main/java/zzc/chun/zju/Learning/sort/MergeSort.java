package zzc.chun.zju.Learning.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 
				62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
		
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
	private static void sort(int[] a, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			sort(a, left, mid);
			sort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	private static void merge(int[]a , int left, int mid, int right){
		int i = left, j = mid + 1;
		int m = mid, n = right;
		int[] tmp = new int[a.length];
		int k = 0;
		
		while(i <= m && j <= n){
			if(a[i] < a[j]){
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		while (i <= m) {
			tmp[k++] = a[i++];
		}
		while (j <= n) {
			tmp[k++] = a[j++];			
		}

		// 将中间数组中的内容复制回原数组
		for(i = 0; i < k; i++){
			a[left + i] = tmp[i];
		}
	}

}

/**
 * 把 n 个记录看成 n 个长度为 l 的有序子表
 * 进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表
 * 重复第 2 步直到所有记录归并成一个长度为 n 的有序表为止。

以数组 array = [6, 5, 3, 1, 8, 7, 2, 4] 为例，首先将数组分为长度为 2 的子数组，并使每个子数组有序：

[6, 5]  [3, 1]  [8, 7]  [2, 4]
   ↓       ↓       ↓       ↓
[5, 6]  [1, 3]  [7, 8]  [2, 4]

然后再两两合并：
[6, 5, 3, 1]  [8, 7, 2, 4]
      ↓             ↓
[1, 3, 5, 6]  [2, 4, 7, 8]

最后将两个子数组合并：
[6, 5, 3, 1, 8, 7, 2, 4]
            ↓
[1, 2, 3, 4, 5, 6, 7, 8]

归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，
时间复杂度可以记为O(N)，故一共为O(N*logN)。因为归并排序每次都是在相邻的数据中进行操作，
所以归并排序在O(N*logN)的几种排序方法（快速排序，归并排序，希尔排序，堆排序）也是效率比较高的。

*/
