package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: CountOfOne  
* @author Captain Zhang   
* @date 2016年9月26日 下午9:54:22
* @version V1.0
* 
* @Description: 
* 
*  题目描述
	
	输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
	
	输入描述:
	 输入一个整数（int类型）
	
	
	输出描述:
	 这个数转换成2进制后，输出1的个数
	
	输入例子:
	5
*/
public class CountOfOne {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int val = sc.nextInt();
		
		sc.close();
		
		String b = Integer.toBinaryString(val);
		
		System.out.println(b);
		
		int count = 0;
		for(int i = 0; i < b.length(); i++){
			if(b.charAt(i) == '1'){
				count ++;
			}
		}
		System.out.println(count);
	}
}
