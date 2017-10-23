package zzc.chun.zju.Learning.algorithm.dp.edit;

/**
 * Created by z81022404 on 2017/10/23.
 * https://leetcode.com/problems/edit-distance/description/
 *
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character

 思路：用f(i,j)表示字符串s2(0...i)转换成s1(0...j)需要的操作步数
    则有增加一个字符，f(i,j)=f(i-1,j)+1
    删除一个字符(s1删除一个字符)，f(i,j)=f(i,j-1)+1
    修改字符时，如果s1(i)==s2(j),f(i,j)=f(i-1,j-1),否则f(i,j)=f(i-1,j-1)+1
 */
public class editDistance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len2; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j < len1; j++) {
            dp[j][0] = j;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j< len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                }
            }
        }
        return dp[len1-1][len2-1];
    }

    public static void main(String[] args) {
        System.out.println(new editDistance().minDistance("a", ""));
        System.out.println(new editDistance().minDistance("a", "b"));
        System.out.println(new editDistance().minDistance("a", "b"));
    }
}
