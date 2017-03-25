package zzc.chun.zju.Learning.sort;

/**
 * Created by chun on 17-3-24.
 */
public class ShellSort {
    public static void main(String[] args){
//        System.out.println(Math.ceil(3));
//        System.out.println(3/2);
//        System.out.println(5/2);

        int a[] = {1, 54, 6, 3, 78, 34, 12, 45, 56, 100};
        int d = a.length;
        // int i, j, tmp;

        while(true){

            //int d = (int)Math.ceil(a.length / 2);
            d = (int)Math.ceil(d / 2);
            System.out.println("d is :"  + d);
            for(int i = 0; i < d; i++){

                for(int j = i + d; j < a.length; j += d){
                    int tmp = a[j];
                    int k = j - d;
                    for(; k >= 0 && a[k] > tmp; k -= d){
                        a[k + d] = a[k];
                    }
                    a[k + d] = tmp;
                }
            }

            if(d == 1){
                break;
            }
        }
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }
}
