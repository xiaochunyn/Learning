package zzc.chun.zju.Learning.sort;

/**
 * Created by chun on 17-3-23.
 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
 * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * eg: [1 4 2 3]
 *
 * first loop:  i = 1, j = 0; 4 > 1, 不用交换
 * second loop: i = 2; j = 1; 2 < 4, a[j + 1] = a[j] 即 a[2] = 4
 *              a[j + 1] = a[j],即a[1] = 2; 此时数组为： [ 1 2 4 3 ]
 *
 * third loop： i = 3； j = 2; 3 < 4, a[j + 1] = a[j] 即 a[3] = 4
 *              a[j + 1] = tmp, 即 a[2] = 3; 此时数组为： [1 2 3 4]
 */
public class InsertSort {
    public static void main(String[] args){
        int[] a = new int[]{1, 4, 2, 3};
        insertSort(a);
        System.out.println("*********************************");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println("*********************************");
    }

    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i - 1;
            for (; j >= 0 && tmp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

}
