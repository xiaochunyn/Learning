package zzc.chun.zju.Learning.strings;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
* @ClassName: DictionarySort  
* @author Captain Zhang   
* @date 2016年9月26日 下午8:49:23
* @version V1.0
* 
* @Description: 
* 
*  	题目描述
	
	给定n个字符串，请对n个字符串按照字典序排列。 
	输入描述:
	输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
	
	
	输出描述:
	数据输出n行，输出结果为按照字典序排列的字符串。
	
	输入例子:
	9
	cap
	to
	cat
	card
	two
	too
	up
	boat
	boot
	
	输出例子:
	boat
	boot
	cap
	card
	cat
	to
	too
	two
	up
	
*/
public class DictionarySort {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		List<String> set = new Vector<String>();
		//The number of strings
		int n = scanner.nextInt();
		
		for(int i = 0; i <= n; i++){
			set.add(scanner.nextLine());
		}
		
		scanner.close();
		
		Collections.sort(set);
		
		for(String s : set){
			System.out.println(s);
		}
		
	}
}
