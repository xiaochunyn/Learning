package zzc.chun.zju.Learning.lintcode.palindrom;

import java.util.Scanner;

/**
* @ClassName: LogestPalindrom  
* @author Captain Zhang   
* @date 2017年9月24日 下午8:53:24
* @version V1.0
* 
* @Description: 
给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。

数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。

 注意事项
假设字符串的长度不会超过 1010。

给出 s = "abccccdd" 返回 7

一种可以构建出来的最长回文串方案是 "dccaccd"。

解析：
这个题关键的一点就是如何处理奇数个的字符。

如果处理好了奇数个字符，那么这个题就会迎刃而解。原因在于如果是偶数个的字符，一定可以构造回文数。
但是奇数个的就不行。所有的奇数个的字符数都要减去1。

最后所有的奇数字符串中只可以保留一个完整的，就是它是多长就在最大回文串中加上多少。但是可想而知，
这个奇数的回文串一定是位于整个调整后的回文串的最中间。
否则难以构成回文串。

比如"abbba"是个回文串但是有3个"b",只能放中间才能构成回文串。如果是"abbbccca"有3个"b",
3个"c"这时就无法构成回文串，如果想构成回文串那么这两个奇数个的字符

要有一个字符的个数减去1，然后把剩下的那个个数为3的字符放在最中间"acbbbca"或者"abcccba"
当然对称的部分顺序也是可以调换的"cabbbac","bacccab"。

最关键的一步就是如何处理奇数个的字符。

通过前面的叙述应该很明白了。就是奇数个的字符。都减去1，再在最后的基础上，判断是否有奇数个的字符。
如果有那么结果加上1返回就可以了。
*/
public class LogestPalindrom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println(new LogestPalindrom().longestPalindrome(in.nextLine()));
		}
	}
	public int longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        boolean hasOod = false;
        int []a =  new int[52];
        for(int i = 0; i < a.length;i++) {
            a[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if (Character.isUpperCase(tmp)){
                a[tmp - 'A' + 0]++;
            } else {
                a[tmp - 'a' + 26] ++;
            }            
        }
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += (a[i]/2)*2;
            if (a[i]%2 == 1) {
                hasOod = true;
            }
        }
        // 如果有多个字母都只出现一次，只用一个，所以这里加一
        if(hasOod) {
            sum++;
        }
        return sum;
    }
}

