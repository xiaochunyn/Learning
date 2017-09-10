package zzc.chun.zju.Learning.wangyi;

import java.math.BigInteger;
import java.util.Scanner;

/**
* @ClassName: ReverseAdding  
* @author Captain Zhang   
* @date 2017年9月10日 上午9:44:05
* @version V1.0
* 
* @Description: 
* 
*  网易2018年秋招笔试题 - 相反数
*  大致题意：
*  输入一个整数n(n >= 1 && n <= 10^5), 将n反转，求反转后的数和n的和
*  注：100反转之后为1
*  
*  input:
*  203  （反转之后为302）
*  
*  output：
*  505
*  
*  分析：
*  主要是求N的反转数
*/
public class ReverseAdding {

	public static void main(String[] args){
		while(true){
			int val;
			Scanner scanner = new Scanner(System.in);
			val = scanner.nextInt();
			int reverse = 0;
			int remain = val;
			while(remain > 0){
				reverse = reverse * 10 + remain % 10;
				remain /= 10;
			}
			System.out.println(reverse);
			System.out.println(val + reverse);
			scanner.close();
		}
	}
}
