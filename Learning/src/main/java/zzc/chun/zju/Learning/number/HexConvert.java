package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: HexConvert    
* @author Captain Zhang   
* @date 2016年9月19日 下午5:19:24
*
* @Description: 
* 	写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
*
*	输入描述:
*	输入一个十六进制的数值字符串。
*	
*	输出描述:
*	输出该数值的十进制字符串。
*	
*	输入例子:
*	0xA
*	
*	输出例子:
*	10
*
*
*
*/
public class HexConvert {
	public static void main(String[] args){

//				
//		char a = 'A';
//		int b = a;
//		System.out.println(b);
//		
//		System.out.println((char)(97));
		
		Scanner sc = new Scanner(System.in);
		
		//去掉0x前面两位
		String a = sc.nextLine().substring(2);
		
		sc.close();
		
		System.out.println(convert(a));
		
	}
	
	public static int convert(String s){
	
		int sum = 0;
		int val = 0;
		char tmp;
		
		 
		for(int i = s.length() - 1; i >= 0; i--){
			tmp = s.charAt(i);
			if(tmp >= '0' && tmp <= '9'){
				val = tmp;
			}
			if(tmp >= 'A' && tmp <= 'F'){
				val = tmp - 'A' + 10;
			}
			if(tmp >= 'a' && tmp <= 'f'){
				val = tmp - 'a' + 10;
			}
			
			sum += val * Math.pow(16, i-1);
			
		}
		return sum;
	}
	
}
