package zzc.chun.zju.Learning.lintcode.palindrom;

import java.util.Scanner;

/**
* @ClassName: PalindromNumber  
* @author Captain Zhang   
* @date 2017年9月24日 下午7:03:48
* @version V1.0
* 
* @Description: 
* 判断一个正整数是不是回文数。

回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。

样例
11, 121, 1, 12321 这些是回文数。

23, 32, 1232 这些不是回文数。 
*/
public class PalindromNumber {

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println(new PalindromNumber().isPalindrome(scanner.nextInt()));
		}
	}
	
	 public boolean isPalindrome(int num) {
	        // write your code here
	        String s = Integer.toString(num);
	        int start = 0;
	        int end = s.length() - 1;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(start) == (s.charAt(end))) {
	                start++;
	                end--;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
}
