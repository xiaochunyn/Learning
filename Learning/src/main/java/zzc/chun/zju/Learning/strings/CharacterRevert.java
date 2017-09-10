package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: CharacterRevert    
* @author Captain Zhang   
* @date 2016年10月20日 下午8:57:09
*
* @Description: 
* 
*	题目描述
*	
*	将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
*	 
*	输入参数：
*	inputString：输入的字符串
*	 
*	返回值：
*	输出转换好的逆序字符串
*	 
*	输入描述:
*	输入一个字符串，可以有空格
*	
*	输出描述:
*	输出逆序的字符串
*	
*	输入例子:
*	I am a student
*	
*	输出例子:
*	tneduts a ma I
* 
*/
public class CharacterRevert {

	public static void main(String[] args){
		
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()){
			String str = reader.nextLine();
			
			for(int i = str.length() - 1; i >= 0; i--){
				System.out.print(str.charAt(i));
			}
			System.out.println();
		}
		reader.close();
	}
}
