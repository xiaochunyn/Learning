package zzc.chun.zju.Learning.algorithm.dp.edit;

/**
 * 题目：
 * 给定两个字符串str1和str2,再给定三个整数ic, dc 和 rc,
 * 分别代表插入,删除,和替换一个字符的代价，返回str1编辑成str2的最小代价.
 *
 * 解答：
 * 如果str1的长度为M, str2的长度为N, 经典动态规划的方法可以达到时间复杂度为O(M*N),
 * 额外空间复杂度为O(M*N).
 *
 * 先用动态规划的方法,首先生成大小为(M+1)*(N+1)的矩阵dp,dp[i][j]的值代表str[0...i-1]
 * 编辑成str2[0...j-1]的最小代价。举个例子,str1="ab12cd3",str2="adcdf", ic=5, dc=3,
 * rc=2. dp是一个8*6的矩阵,最终计算结果如下：
 *
 *      ""  a   b   c   d   f
 * ""   0   5   10  15  20  25
 * a    3   0   5   10  15  20
 * b    6   3   0   5   10  15
 * 1    9   6   3   2   7   12
 * 2    12  9   6   5   4   6
 * c    15  12  9   6   7   6
 * d    18  15  12  9   6   9
 * 3    21  18  15  12  9   8
 *
 * 下面具体说一下dp矩阵的每个位置的值是如何计算的
 * 1. dp[0][0]=0, 表示str1空的子串编辑成str2空的子串的代价为0
 * 2. 矩阵dp第一列即dp[0...M-1][0]. dp[i][0]表示str1[0...i-1]编辑成空串的最小代价,
 *      毫无疑问,是把str1[0...i-1]所有字符删除的代价，所以dp[i][0]=dc*i
 *
 * 3. 矩阵dp第一行即dp[0][0...N-1].dp[0][j]表示空串编辑成str2[0...j-1]的最小代价,
 *      毫无疑问,是在空串里插入str2[0...j-1]所有字符的代价,所以dp[0][j]=ic*j
 *
 * 4. 其他位置按照从左到右，再从上到下来计算，dp[i][j]的值值可能来自以下四种情况：
 *      １. str[0...i-1]可以先编辑成str[0...i-2],也就是删除字符str1[i-1],然后由
 *      str1[0...i-2]编辑成str2[0...j-1],dp[i-1][j]表示str１[0...i-2]编辑成str2[0...j-1]
 *      的最小代价,那么dp[i][j]可能等于dc+dp[i-1][j]
 *
 *      2. str1[0...i-1]可以优先编辑成str2[0...j-2],然后将str2[0...j-2]插入字符str2[j-1],
 *      编辑成str2[0...j-1],dp[i][j-1]表示str1[0...i-2]编辑成str2[0...j-1]的最小代价,
 *      那么dp[i][j]可能等于ic+dp[i][j-1]
 *
 *      3. 如果str[i-1]!=str2[j-1], 先把str1[0...i-1]中str2[0...j-2]的部分变成str2[0...j-2],
 *      然后把字符str1[i-1]替换成str2[i-1],这样str1[0...i-1]就编辑成str2[0...j-1]了,那么
 *      dp[i][j]可能等于rc+dp[i][j]
 *
 *      4. 如果str1[i-1] == str2[j-1],先把str1[0...i-1]中str1[0...i-2]的部分变成str2[0...j-2],
 *      因为此时字符str1[i-1]==str2[j-1],所以str1[0...j-1]已经编辑成str2[0...j-1]了.
 *      dp[i-1][j-1]表示str1[0...i-2]编辑成str2[0...i-2]的最小代价，那么dp[i][j]可能等于dp[i-1][j-1]
 *
 * 5. 以上四种情况，选最小值作为dp[i][j]的值,那么dp[i][j]可能等于dp[i-1][j-1]
 *
 */
public class editCost {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        if (str1 ==null || str2 == null) {
            return 0;
        }
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int row = str1.length() + 1;
        int col = str2.length() + 1;
        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = ic * j;
        }

        for (int i = 1; i < row; i ++) {
            for (int j = 1; j < col; j ++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(new editCost().minEditCost("ab12cd3", "abcdf", 5, 3, 2));
    }
}
