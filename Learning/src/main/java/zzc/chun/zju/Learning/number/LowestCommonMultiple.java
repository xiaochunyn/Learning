package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: LowestCommonMultiple    
* @author Captain Zhang   
* @date 2016年10月20日 下午8:04:04
*
* @Description: 
* 
* 题目描述
* 
* 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
* 
* 输入描述:
* 输入两个正整数A和B。
* 
* 输出描述:
* 输出A和B的最小公倍数。
* 
* 输入例子:
* 5 
* 7
* 
* 输出例子:
* 35
* 
* 解题思路：
* 最小公倍数其实就是两个数的成绩除以最大公约数，所以本题的实质还是求最大公约数
* 求最大公约数的经典算法叫辗转相除法也叫欧几里得算法，算法思想是：
* 求a和b的最大公约数是，若a%b为0，则说明b为最大公约数，否则a和b的最大公约数与a%b的最大公约数相同。
* 
*/
public class LowestCommonMultiple {

	public static int nod(int a, int b){
		if(a < b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if(a % b != 0){
			return nod(b, a % b);
		}else{
			return b;
		}
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			System.out.println(a * b / nod(a, b));			
			
		}
		scanner.close();
	}
}
