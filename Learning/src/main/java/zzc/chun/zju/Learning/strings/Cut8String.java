package zzc.chun.zju.Learning.strings;

import java.sql.SQLNonTransientConnectionException;
import java.util.Scanner;

/**
* @ClassName: Cut8String
* @author Captain Zhang   
* @date 2016年9月18日 下午8:21:24
* @version V1.0
* 
* @Description: 
*     
*     题目描述

•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

输入描述:
连续输入字符串(输入2次,每个字符串长度小于100)


输出描述:
输出到长度为8的新字符串数组

输入例子:
abc
123456789

输出例子:
abc00000
12345678
90000000

思路分析：
方法一：
如果字符串长度大于8，则进行截取，直到长度小于8
pos标志位+8

如果，字符串长度小于pos,
	则截取(pos-8) 到  s.length()
	然后用0补齐8位
	
	
方法二：
首先判断字符串长度是否是8的倍数
	如果是8的倍数，直接8个一组输出
	否则，补0后输出	
*/

public class Cut8String {

	public static void main(String[] args){
		
		String[] arr = new String[2];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++){
			arr[i] = scanner.nextLine();			
		}

		scanner.close();
		
		System.out.println(converts(arr));
		
	}
	
	
	//方法一
	private static String convert(String[] arr){
		
		StringBuilder sb = new StringBuilder();
				
		
		for(String s : arr){
			
			int pos = 8;
			
			while(s.length() >= pos){
				sb.append(s.substring(pos - 8, pos)).append("\n");
				pos += 8;
			}
			
			if(s.length() < pos){
				sb.append(s.substring(pos - 8, s.length()));		
				
				for(int i = s.length(); i< pos; i++){
					sb.append("0");
				}
			}
				
			sb.append("\n");			
		}
				
		return sb.toString();
	}
	
	//方法二：
	public static String converts(String[] arr){
		StringBuilder result = new StringBuilder();
		
		for(String string : arr){
			StringBuilder sb = new StringBuilder(string);
			
			if(string.length() % 8 != 0){
				int len = 8 - string.length()%8 ;
				
				for(int i = 0; i < len; i++){
					sb.append("0");
				}
			}
			
			int pos = 0;
			while(pos != sb.length()){
				//System.out.println(sb.substring(pos, pos+8));
				result.append(sb.substring(pos, pos + 8)).append("\n");
				pos += 8;
			}
		}
		
		return result.toString();
		
	}
	
	
	
}


    
