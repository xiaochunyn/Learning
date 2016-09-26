package zzc.chun.zju.Learning.strings;

import java.util.*;

/**
* @ClassName: StringRevert    
* @author Captain Zhang   
* @date 2016年9月26日 下午3:22:42
*
* @Description: 
* 
	* 题目描述
	
	写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
	
	输入描述:
	输入N个字符
	
	
	输出描述:
	输出该字符串反转后的字符串
	
	输入例子:
	abcd
	
	输出例子:
	dcba
*/
public class StringRevert {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String val = sc.nextLine();
		
		sc.close();
		
		for(int i = val.length() - 1; i >= 0; i --){
			System.out.print(val.charAt(i));
		}
	}
}
