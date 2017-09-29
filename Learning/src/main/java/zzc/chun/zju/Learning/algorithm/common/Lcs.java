package zzc.chun.zju.Learning.algorithm.common;

import java.util.Scanner;

/**
 * Created by Joker Z on 2017/9/29.
 *  最长公共子串和最长公共子序列的区别：子串是串的一个连续的部分，子序列则是从不改变序列的顺序，
 *  而从序列中去掉任意的元素而获得新的序列；也就是说，子串中字符的位置必须是连续的，子序列则可以不必连续。
 *
 *  方法一： 暴力破解
 *  其实看到这个问题我们直接可以用暴力的方式解决这个问题。给定两个字符串A和B，我们可以通过从A的第一个字符
 *  开始与B对应的每一个字符进行对比的方式找到最长的公共字串。如果此时没有找到匹的字母，则移动到A的第二个字
 *  符处，然后从B的第一个字符处进行对比，以此类推。
 */
public class Lcs {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(LCS(str1, str2));
        sc.close();
    }
    private static int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 == 0 || len2 == 0) {
            return 0;
        }
        int longest = 0;
        int start1 = -1, start2 = -1;

        for(int i = 0; i < len1; i ++) {
            for(int j = 0; j < len2; j++) {
                int length = 0;
                int m = i;
                int n = j;
                while (m < len1 && n < len2) {
                    if (str1.charAt(m) != str2.charAt(n))
                        break;
                    length++;
                    ++m;
                    ++n;
                }
                if (length > longest) {
                    longest = length;
                    start1 = i;
                    start2 = j;
                }
            }
        }
        if (longest > 0) {
            System.out.println("s1 start at: " + start1 + "\ns2 start at: " + start2);
            System.out.println("Longest Common String: " + str1.substring(start1, start1 + longest));
        }
        return longest;
    }
}

/**
 * Testcase
 XXYXXYYYXYXYYXXYYYYYXXYXXXYXXYXYXXXXYXXYYYXYYXYXYXXXYYXXXYYXYYXYXYXYXXXXXXXXXYXXXX
 YYYYYXYYYXYYXXXYYYXXYYXXYXXXYYYYYYYYXXYXYYYYXYXYYXYX
 out: 9

 XXYXYYYXXYXYYYYXYXYYYXYYYYYXYX
 XYY
 out: 3

 YXXXXXY
 YXYXXYYYYXXYYYYXYYXXYYXXYXYYYYYYXYXYYXYXYYYXXXXXX
 out: 6

 XYXXYYYXXXYYXXYYYYXXYYYXYYYXXXXXYYXXYXYXXXYY
 out: 0
 */