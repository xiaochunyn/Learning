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
