package zzc.chun.zju.Learning.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = {4, 6, 8, 3, 5, 7, 1};
		quickSort(a, 0, a.length - 1);
		for(int i = 0;i < a.length; i++){
			System.out.print(a[i] + "   ");
		}
	}
		
	private static int patition(int[] a, int left, int right){
		int storeIndex = left;
		// 最后一个元素作为基准 pivot
		int pivot = a[right];
				
		for(int i = left; i < right; i++){
			if(a[i] < pivot){
				swap(a, storeIndex, i);
				storeIndex++;
			}
		}
		
		swap(a, right, storeIndex);
		return storeIndex;
	}
	
	private static void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void quickSort(int[] a, int left, int right){
		if(left > right){
			return;
		}
		int storeIndex = patition(a, left, right);
		quickSort(a, left, storeIndex - 1);
		quickSort(a, storeIndex + 1, right);
	}

}
