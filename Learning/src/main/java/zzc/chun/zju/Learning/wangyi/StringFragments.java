package zzc.chun.zju.Learning.wangyi;

import java.util.Scanner;

/**
* @ClassName: StringFragments  
* @author Captain Zhang   
* @date 2017年9月10日 上午11:25:46
* @version V1.0
* 
* @Description: 
* 	字符串碎片
	时间限制：1秒
	空间限制：32768K
	一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
	
	输入描述:
	输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
		
	输出描述:
	输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
	
	如样例所示: s = "aaabbaaac"
	所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
	
	输入例子1:
	aaabbaaac
	
	输出例子1:
	2.25 
	
	分析：
	计算有多少个碎片，用总长度除它即可	
*/
public class StringFragments {

	public static void main(String[] args) {
		String val;
		Scanner sc = new Scanner(System.in);
					
		val = sc.nextLine();
		char tmp = val.charAt(0);
		double subString = 1;
		for(int i = 1; i < val.length(); i++){
			if(tmp != val.charAt(i)){
				subString ++;
				tmp = val.charAt(i);
			}
		}
//		System.out.println(val.length());
//		System.out.println(subString);
		System.out.printf(String.format("%.2f", val.length() / subString));
		
		sc.close();
	}
}
