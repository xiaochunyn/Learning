package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: AppearOnce    
* @author Captain Zhang   
* @date 2016年10月25日 下午4:27:17
*
* @Description: 
*	题目描述
*	
*	找出字符串中第一个只出现一次的字符
*	 
*	输入描述:
*	输入一个非空字符串
*	
*	
*	输出描述:
*	输出第一个只出现一次的字符，如果不存在输出-1
*	
*	输入例子:
*	asdfasdfo
*	
*	输出例子:
*	o
*
*	解体思路：
*	用空格替代第i个元素，得到一个新的字符串str
*	用原字符串长度减去新字符串的长度
*	如果他们的差值为1，即只有一个元素用空格替代了
* 
*/
public class AppearOnce {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			int count = -1;
			for(int i = 0; i < str.length(); i++){
				if(str.length() - str.replaceAll(str.charAt(i)+"", "").length() == 1){
					System.out.println(str.charAt(i));
					count = 0;
				}
			}
			if(count == -1){
				System.out.println(count);
			}
		}
		scanner.close();
	}
}
