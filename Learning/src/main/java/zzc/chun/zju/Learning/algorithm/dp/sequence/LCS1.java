package zzc.chun.zju.Learning.algorithm.dp.sequence;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Joker.Z on 2017/9/29.
 * 最长公共子序列与最长公共子串的区别在于最长公共子序列不要求在原字符串中是连续的，比如ADE和ABCDE的最长公共子序列是ADE。

 我们用动态规划的方法来思考这个问题如是求解。首先要找到状态转移方程：

 符号约定，C1是S1的最右侧字符，C2是S2的最右侧字符，S1‘是从S1中去除C1的部分，S2'是从S2中去除C2的部分。

 LCS(S1,S2)等于下列3项的最大者：
 （1）LCS（S1，S2’）
 （2）LCS（S1’，S2）
 （3）LCS（S1’，S2’）--如果C1不等于C2； LCS（S1'，S2'）+C1--如果C1等于C2；

 边界终止条件：如果S1和S2都是空串，则结果也是空串。

 下面我们同样要构建一个矩阵来存储动态规划过程中子问题的解。这个矩阵中的每个数字代表了该行和该列之前的LCS的长度。
 与上面刚刚分析出的状态转移议程相对应， 矩阵中每个格子里的数字应该这么填，它等于以下3项的最大值：

 （1）上面一个格子里的数字
 （2）左边一个格子里的数字
 （3）左上角那个格子里的数字（如果 C1不等于C2）； 左上角那个格子里的数字+1（ 如果C1等于C2）

 举个例子：
 　　　　  G　　C　　T　　A

 　　 0　　0　　0　　0　　0

 G　 0　　1　　1　　1　　1

 B　 0　　1　　1　　1　　1

 T　 0　　1　　1　　2　　2

 A  0　　1　　1　　2　　3

 填写最后一个数字时，它应该是下面三个的最大者：
 （1）上边的数字2
 （2）左边的数字2
 （3）左上角的数字2+1=3,因为此时C1==C2
 所以最终结果是3。

 在填写过程中我们还是记录下当前单元格的数字来自于哪个单元格，以方便最后我们回溯找出最长公共子串。
 有时候左上、左、上三者中有多个同时达到最大，那么任取 其中之一，但是在整个过程中你必须遵循固定的
 优先标准。在我的代码中优先级别是左上>左>上。

 输出一个最长公共子序列并不难（网上很多相关代码），难点在于输出所有的最长公共子序列，因为 LCS 通
 常不唯一。总之，我们需要在动态规划表上进行回溯 —— 从table[m][n]，即右下角的格子，开始进行判断：
 如果格子table[i][j]对应的X[i-1] == Y[j-1]，则把这个字符放入 LCS 中，并跳入table[i-1][j-1]中继续进行判断；

 如果格子table[i][j]对应的 X[i-1] ≠ Y[j-1]，则比较table[i-1][j]和table[i][j-1]的值，跳入值较大的格子继续进行判断；

 直到 i 或 j 小于等于零为止，倒序输出 LCS 。

 如果出现table[i-1][j]等于table[i][j-1]的情况，说明最长公共子序列有多个，故两边都要进行回溯（这里用到递归）。

 参考链接： http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
          http://blog.csdn.net/lisonglisonglisong/article/details/41596309

 Testcase:
 ABCBDAB
 BDCABA

 The length of LCS is: 4
 BCAB
 BCBA
 BDAB
 */
public class LCS1 {
    private String s1;
    private String s2;
    private int [][]table;
    private Set<String> set = new TreeSet<>();

    public LCS1(String a, String b) {
        this.s1 = a;
        this.s2 = b;
    }

    private int lcs(int len1, int len2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        table = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i ++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[len1][len2];
    }

    private void traceBack(int i, int j, String s) {
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s += s1.charAt(i - 1);
                --i;
                --j;
            } else {
                if (table[i - 1][j] > table[i][j - 1]) {
                    --i;
                } else if (table[i - 1][j] < table[i][j - 1]) {
                    --j;
                } else {
                    traceBack(i - 1, j, s);
                    traceBack(i, j - 1, s);
                    return;
                }
            }
        }

        set.add(new StringBuffer(s).reverse().toString());
    }

    private void PrintCLS() {
        int len1 = s1.length();
        int len2 = s2.length();
        int length = lcs(len1, len2);

        String str = "";
        traceBack(len1, len2, str);

        System.out.println("The length of LCS is: " + length);
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        LCS1 lcs = new LCS1(a, b);
        lcs.PrintCLS();
    }
}
