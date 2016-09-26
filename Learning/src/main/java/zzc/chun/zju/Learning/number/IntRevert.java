package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: IntRevert    
* @author Captain Zhang   
* @date 2016年9月26日 下午1:52:55
*
* @Description: 
* 
	* 题目描述
	
	描述：
	输入一个整数，将这个整数以字符串的形式逆序输出
	程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
	 
	
	输入描述:
	输入一个int整数
	
	
	输出描述:
	将这个整数以字符串的形式逆序输出
	
	输入例子:
	1516000
	
	输出例子:
	0006151
	
	思路分析:
	直接接收字符串，此题就比较简单了
	
	拓展：
	一个整数对10取余，可以取得最后一位数
	eg: 123 逆序输出 为321
		123 % 10  =  3
		12	% 10  =  2
		1	% 10  =  1
	
*/
public class IntRevert {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String val = sc.nextLine();
		
		sc.close();
		
		for(int i = val.length() - 1; i >= 0; i --){
			System.out.print(val.charAt(i));
		}
//		int tmp;
//		
//		while(val >= 0){
//			
//			tmp = val % 10 + '0';
//			
//			if(tmp == '0'){
//				System.out.print((char)'0');
//			}else{
//				System.out.print((char) tmp );
//			}
//			
//			val = val / 10;			
//		}
	}
}
