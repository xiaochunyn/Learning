package zzc.chun.zju.Learning.algorithm.dp.sequence;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

 参考链接： http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
 */
public class Lcs {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(LCS(s1.toCharArray(), s2.toCharArray()));
        sc.close();
    }

    public static int LCS(char []s1, char []s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 == 1 || len2 == 1) {
            return 0;
        }
        int [][]a = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    a[i][j] = a[i-1][j-1] + 1;
                } else {
                    a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
                }
            }
        }
        System.out.println("LCS: " + a[len1][len2]);

        int pos1 = len1, pos2 = len2;
        List<Character> list = new LinkedList<>();
        while (pos1 > 0 && pos2 > 0) {
            if (s1[pos1 - 1] == s2[pos2 - 1]) {
                list.add(s1[pos1 - 1]);
                pos1 --;
                pos2 --;
            } else if (a[pos1][pos2 - 1] >= a[pos1 - 1][pos2]) {
                pos2--;
            } else {
                pos1--;
            }
        }
        Collections.reverse(list);
        System.out.println(list);
        return a[len1][len2];
    }
}
