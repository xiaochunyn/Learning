package zzc.chun.zju.Learning.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {

		int[] a = {16,14,10,8,7,9,3,2,4,1,0};
		sort(a);
		System.out.println(Arrays.toString(a));
		
	}
	
	private static void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void buildMaxHeap(int[] a){
		int iParent = (int)Math.floor(a.length / 2) - 1;
		System.out.println("iParent   " + iParent);
		for(int i = iParent; i >= 0; i--){
			maxHeapify(a, i, a.length);
		}
	}
	
	private static void maxHeapify(int[] a, int index, int heapsize){
		int iMax, iLeft, iRight;
		
		while(true){
			iMax = index;
			iLeft = 2 * index + 1;
			iRight = 2 * (index + 1);
			
			System.out.println("iMax:  " + iMax + "  iLeft:  " + iLeft + "  iRight:  " + iRight);
			
			//找出左右节点中较大的值
			if(iLeft < heapsize && a[index] < a[iLeft]){
				iMax = iLeft;
			}
			if(iRight < heapsize && a[iMax] < a[iRight]){
				iMax = iRight;
			}
			
			if(iMax != index){
				swap(a, iMax, index);
				index = iMax;
			}else {
				break;
			}
			
		}
		
	}
	
	private static void sort(int[] a){
		buildMaxHeap(a);
		for(int i = a.length - 1; i > 0; i--){
			swap(a, 0, i);
			maxHeapify(a, 0, i);
		}
	}

}


/**
 * 参考自一下博文：
 * 	http://bubkoo.com/2014/01/14/sort-algorithm/heap-sort/
 * 二叉树的每个节点至多只有两颗子树（不存在度大于2的节点），二叉树有左右之分，次序不能颠倒。
 * 
 * 树和二叉树的主要区别：
 * 	1. 树的节点个数至少为1，而二叉树的节点个数可以为0
 * 	2. 树中节点的最大度数没有限制，而二叉树的节点的最大度数为2
 * 	3. 树的节点无左右之分，而二叉树的节点有左右之分
 * 
 * 堆：
 * 	堆（二叉树）可以视为一个完全二叉树，完全二叉树的一个“优秀”性质是
 * 	除了最底层之外，每一层都是满的
 * 	这使得堆可以利用数组来表示
 * 
 * 	对于给定的某个节点的下标i，可以很容易的计算出这节点的父节点、孩子节点的下标
 * 	parent = floor(i / 2) - 1
 * 	left = 2 * i + 1
 * 	right = 2(i + 1)
 * 
 * 	最大堆：
 * 		最大堆中的最大元素值出现在根节点
 * 		堆中每个父节点的元素值都大于等于孩子节点
 * 		其孩子节点也是一个最大堆
 * 
 *  堆排序原理：
 *  	堆排序就是把最大堆堆顶的最大数去除，将剩余的堆继续调整为最大堆
 * 		再次将堆顶的最大数取出，这个过程持续到剩余数只有一个时结束。
 * 		在堆中定义以下几种操作：
 * 			最大堆调整（Max-Heapify）:将堆的末端子节点做调整，使得子节点永远小于父节点
 * 			创建最大堆（Build-Max-Heap）: 将堆所有数据重新排序，使其成为最大堆
 * 			堆排序（Heap-sort）:	移除位在第一个数据的根节点，并做最大堆调整的递归算法
 * 
 */
