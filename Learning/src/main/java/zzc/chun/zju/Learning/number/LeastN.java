package zzc.chun.zju.Learning.number;

import java.util.Arrays;
import java.util.Scanner;

/**
* @ClassName: LeastN    
* @author Captain Zhang   
* @date 2016年10月24日 下午8:52:53
*
* @Description: 
*	题目描述
*	
*	输入n个整数，输出其中最小的k个。
*
*	输入描述 :
*	输入说明 : 
*	1 输入两个整数 
*	2 输入一个整数数组
*		
*	输出描述:
*	输出一个整数数组
*	
*	输入例子:
*	5 2
*	1 3 5 7 2
*	
*	输出例子:
*	1 2 
*	
*	思路解析：
*	此题难度不大，注意输出不以空格结尾
*/
public class LeastN {

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()){
			StringBuilder result = new StringBuilder();
			
			String []str1 = reader.nextLine().split(" ");
			String []str2 = reader.nextLine().split(" ");
			
			//整数个数
			int num = Integer.valueOf(str1[0]);
			
			//前n个最小值
			int n = Integer.valueOf(str1[1]);
			
			//输入的数据
			int [] array = new int[num];
			for(int i = 0; i < num; i++){
				array[i] = Integer.valueOf(str2[i]);
			}
			
			Arrays.sort(array);
			
			for(int i = 0; i < n; i++){
				result.append(array[i]).append(" ");
			}
			System.out.println(result.substring(0, result.length() - 1));
		}
		
		reader.close();
	}
}
