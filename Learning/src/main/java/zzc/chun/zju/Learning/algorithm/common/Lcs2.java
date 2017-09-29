package zzc.chun.zju.Learning.algorithm.common;

import java.util.Scanner;

/**
 * Created by JokerZ on 2017/9/29.
 *  最长公共子串和最长公共子序列的区别：子串是串的一个连续的部分，子序列则是从不改变序列的顺序，
 *  而从序列中去掉任意的元素而获得新的序列；也就是说，子串中字符的位置必须是连续的，子序列则可以不必连续。
 *
 *  方法一： 暴力破解
 *  其实看到这个问题我们直接可以用暴力的方式解决这个问题。给定两个字符串A和B，我们可以通过从A的第一个字符
 *  开始与B对应的每一个字符进行对比的方式找到最长的公共字串。如果此时没有找到匹的字母，则移动到A的第二个字
 *  符处，然后从B的第一个字符处进行对比，以此类推。

 *  方法二：动态规划
 *  从底部开始解决问题，将所有小问题解决掉，然后合并成一个整体的解决方案。
 *  使用一个数组建立一张表，用于存放被分解成众多子问题的解。
 *
 *  构建矩阵
 *  当字符匹配的时候，我们并不是简单的给相应元素赋上1，而是赋上其左上角元素的值加一。我们用两个标记变量来标
 *  记矩阵中值最大的元素的位置，在矩阵生成的过程中来判断当前生成的元素的值是不是最大的，据此来改变标记变量的
 *  值，那么到矩阵完成的时候，最长匹配子串的位置和长度就已经出来了。
 *
 *   a b c d e f g
 * x 0 0 0 0 0 0 0
 * y 0 0 0 0 0 0 0
 * z 0 0 0 0 0 0 0
 * a 1 0 0 0 0 0 0
 * b 0 2 0 0 0 0 0
 * c 0 0 3 0 0 0 0
 * d 0 0 0 4 0 0 0
 *
 */
public class Lcs2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(LCS(s1, s2));
        sc.close();
    }

    private static int LCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int longest = 0;
        int [][]a = new int[len1][len2];

        for (int j = 0; j < len2; j++) {
            a[0][j] = (s1.charAt(0) == s2.charAt(j) ? 1 : 0);
        }
        for (int i = 0; i < len1; i ++) {
            a[i][0] = (s1.charAt(i) == s2.charAt(0) ? 1 : 0);

            for (int k = 1; k < len2; k++) {
                if (s1.charAt(i) == s2.charAt(k)) {
                    a[i][k] = a[i - 1][k - 1] + 1;
                } else {
                    a[i][k] = 0;
                }
            }
        }

        // start1, start2 分别代表s1, s2代表相同字符串开始的位置
        int start1 = -1, start2 = -1;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (a[i][j] > longest) {
                    longest = a[i][j];
                    start1 = i - longest + 1;
                    start2 = j - longest + 1;
                }
            }
        }
        if (longest > 0) {
            System.out.println("s1 start at: " + start1 +
                    "\ns2 start at: " + start2);
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