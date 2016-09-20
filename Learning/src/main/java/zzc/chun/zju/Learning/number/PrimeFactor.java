package zzc.chun.zju.Learning.number;
import java.util.*;

/**
* @ClassName: PrimeFactor    
* @author Captain Zhang   
* @date 2016年9月20日 上午10:26:10
*
* @Description: 
* 
* 	题目描述
*	功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
*	
*	最后一个数后面也要有空格
*	 详细描述：
*	函数接口说明：
*	
*	public String getResult(long ulDataInput)
*	
*	输入参数：
*	
*	long ulDataInput：输入的正整数
*	
*	返回值：
*	
*	String
*	
*	输入描述:
*	输入一个long型整数
*	
*	输出描述:
*	按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
*	
*	输入例子:
*	180
*	输出例子:
*	2 2 3 3 5
* 
* 
*   分析：
*   在数论里，某一正整数的质因子指能整除该数的质数整数。
* 
* 	两个没有共同质因子的正整数称为互质。
*	数字1与任何正整数（包括1 本身）都是互质。
*	正整数的因数分解给出一连串的质因子；所有质因子相乘后。质因子如重复会以指数表示。
* 
*/
public class PrimeFactor {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long val = sc.nextLong();
		
		sc.close();
		
		System.out.println(getResult(val));
	}
	
	public static String getResult(long val){
		int prime = 2;
		StringBuilder sb = new StringBuilder();
		
		while(val != 1){
			while(val % prime == 0){
				sb.append(prime).append(" ");
				val = val / prime;
			}
			prime ++;
		}
		
		return sb.toString();
	}
}
