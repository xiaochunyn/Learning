package zzc.chun.zju.Learning.strings;

import java.util.*;

/**
* @ClassName: NoRepeatChar    
* @author Captain Zhang   
* @date 2016年9月23日 下午4:38:07
*
* @Description: 
* 
* 	题目描述
	
	编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
	
	输入描述:
	输入N个字符，字符在ACSII码范围内。
	
	
	输出描述:
	输出范围在(0~127)字符的个数。
	
	输入例子:
	abc
	
	输出例子:
	3
	
*/
public class NoRepeatChar {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String val = sc.nextLine();
		
		sc.close();
		
		Set<Character> set = new HashSet<Character>();
		
		char tmp;
		
		for(int i = 0; i < val.length(); i ++){
			tmp = val.charAt(i);
			set.add(tmp);
		}
		
		System.out.println(set.size());
	}
}
