package zzc.chun.zju.Learning.sort;

/**
 * Created by chun on 17-10-10.
 * 合并另个有序的数组,使合并后的数组也是有序的
 * eg:
 * array1: [2 5 9 12 20]
 * array2: [1 3 4 8 11]
 *
 * result:
 * [1 2 3 4 5 8 9 11 12 20]
 */
public class MergeArrays {
    public static void main(String []agrs) {
        int []a = {2, 5, 9, 12, 20};
        int []b = {1, 3, 4, 8, 11};
        int result[] = sort(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] sort(int []a, int []b) {
        int []result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }
}
