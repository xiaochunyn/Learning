package zzc.chun.zju.Learning.sort;

/**
 * Created by chun on 17-3-23.
 */
public class InsertSort {
    public static void main(String[] args){
        System.out.println("IK");
        int[] a = new int[]{1, 4, 2, 3};

        insertSort(a);
        System.out.println("*********************************");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println("*********************************");
    }

    private static int[] insertSort(int a[]){
        for(int i = 1; i < a.length; i ++){
            int tmp = a[i];
            int j = i - 1;
            for(; j >= 0 && tmp < a[j]; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }

        for(int i = 0; i < a.length; i++){
            System.out.println("Sorted:  " + a[i]);
        }

        return a;
    }
}
