package zzc.chun.zju.Learning.lintcode.palindrom;

import java.util.Scanner;

/**
* @ClassName: IsPalindrom  
* @author Captain Zhang   
* @date 2017年9月24日 下午9:19:13
* @version V1.0
* 
* @Description: 
给定一个字符串，判断其是否为一个回文串。只包含字母和数字，忽略大小写。

 注意事项
 **你是否考虑过，字符串有可能是空字符串？这是面试过程中，面试官常常会问的问题。

样例
"A man, a plan, a canal: Panama" 是一个回文。

"race a car" 不是一个回文。

挑战 
O(n) 时间复杂度，且不占用额外空间。 
*/
public class IsPalindrom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println(new IsPalindrom().isPalindrome(in.nextLine()));
		}
	}

	private boolean isPalindrome(String s) {
        // write your code here
		if(s == null || s.equals(" ") ||s.length() == 0){
			return true;
		}
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
        	while(start < s.length() && !isValid(s.charAt(start))){
        		start++;
        	}
        	// 这里要特别注意，不要出现越界的情况
        	if(start == s.length()){
        		return true;
        	}
        	while(end > 0 && !isValid(s.charAt(end))){
        		end--;
        	}
        	if(s.charAt(start) != s.charAt(end)){
        		return false;
        	}else {
        		start++;
            	end--;
			}        	
        }
        return true;
    }
	private static boolean isValid(char c){
		return Character.isDigit(c) || Character.isLetter(c);		
	}
}
/**
 * testcase
 *  " "
 *  .a
 *  A man, a plan, a canal: Panama 
 *  race a car 
 */
