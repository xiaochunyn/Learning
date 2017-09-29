package zzc.chun.zju.Learning.algorithm.common;

import java.util.Scanner;

/**
 * Created by z81022404 on 2017/9/29.
 */
public class Lcs3 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(LCS(s1.toCharArray(), s2.toCharArray()));
        sc.close();
    }

    private static int LCS(char []s1, char []s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        int maxLen = len1 > len2 ? len1 : len2;
        int []max = new int[maxLen];
        int []maxIndex = new int[maxLen];
        int []c = new int[maxLen];

        int i, j;
        for(i = 0; i < len2; i++){
            for (j = len1 - 1; j >= 0; j--) {
                if (s2[i] == s1[j]) {
                    if (i ==0 || j == 0) {
                        c[j] = 1;
                    } else {
                        c[j] = c [j - 1] + 1;
                    }
                } else {
                    c[j] = 0;
                }

                // 如果是大于，暂时只有一个是最长的，且把后面的置零
                if (c[j] > max[0]) {
                    max[0] = c[j];
                    maxIndex[0] = j;
                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                    }
                } else if (c[j] == max[0]){
                    // 有多个是相同长度的字串
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break;
                        }
                    }
                }
            }
        }
        for (j = 0; j < maxLen; j++) {
            if (max[j] > 0) {
                System.out.println(("第" + (j + 1) + "个公共子串:"));
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++)
                    System.out.print(s1[i]);
                System.out.println(" ");
            }
        }
        return c[0];
    }
}
