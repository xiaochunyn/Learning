package zzc.chun.zju.Learning.number;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;


/**
* @ClassName: NoRepeatInt  
* @author Captain Zhang   
* @date 2016年9月20日 下午9:11:13
* @version V1.0
* 
* @Description: 
* 
*  	题目描述
	
	输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
	
	输入描述:
	输入一个int型整数
	
	
	输出描述:
	按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
	
	输入例子:
	9876673
	
	输出例子:
	37689
		
	思路分析：
	如能理解Set, HashSet, LinkedHashSet等 之间的区别，此题就简单了。
*/
public class NoRepeatInt {

	public static void main(String[] args){
		HashSet<Character> list = new LinkedHashSet<Character>();
		
		Scanner sc = new Scanner(System.in);
		
		String val = sc.nextLine().trim();
		
		sc.close();
		
		for(int i = val.length() - 1; i >= 0; i--){
			list.add(val.charAt(i));
		}
		
		for(Character v : list){
			System.out.print(v);
		}
		
	}
}
