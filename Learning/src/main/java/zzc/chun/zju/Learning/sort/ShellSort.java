package zzc.chun.zju.Learning.sort;

/**
 * Created by chun on 17-3-24.
 */
public class ShellSort {
    public static void main(String[] args){

        int a[] = {4, 2, 5, 7, 3, 9, 6, 8};

        shellSort(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println("\n************************************************");

    }

    private static void shellSort(int[] a){
        int gap = a.length;
        int tmp;

        for(gap = gap / 2; gap > 0; gap /= 2){
            for(int i = gap; i < a.length; i ++){
                for(int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap){
                    tmp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = tmp;
                }

            }
        }
    }

}

/**
 * 算法思路：
 * 	1. 先取一个整数d1(d1 < n), 把全部记录分成d1个组，
 * 		所有距离为d1的倍数的记录看成一个组，然后在各组进行插入排序
 * 	2. 然后取d2(d2 < d1)
 * 	3. 重复上述分组和排序操作；
 * 		直到取di = 1(i >= 1)位置，即所有记录成为一个组
 * 		然后对这个组进行插入排序。
 * 		一般选d1约为n/2, d2为d1/2, d3为d2/2 .... di = 1
 *
 *  eg: [ 6 2 4 1 5 9 ]
 *
 *  1. gap = 6 / 2 = 3, 故分为三组
 *  [6 1]
 *  [2 5]
 *  [4 9]
 *
 *  2. 对上面的分组进行排序
 *  *[1 6]
 *  [2 5]
 *  [4 9]
 *
 *  3. gap > 0,继续分组
 *  gap = gap / 2 = 1, 此时对整个数组进行插入排序
 *  [1 2 4 6 5 9]
 *
 */
