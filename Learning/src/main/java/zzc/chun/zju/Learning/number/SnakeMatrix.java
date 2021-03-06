package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: SnakeMatrix    
* @author Captain Zhang   
* @date 2016年10月26日 下午8:11:02
*
* @Description: 
* 
*	题目描述
*	
*	题目说明
*	蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
*	 
*	样例输入
*	5
*	样例输出
*	1 3 6 10 15
*	2 5 9 14
*	4 8 13
*	7 12
*	11
*	接口说明
*	原型
*	void GetResult(int Num, char * pResult);
*	输入参数：
*	        int Num：输入的正整数N
*	输出参数：
*	        int * pResult：指向存放蛇形矩阵的字符串指针
*	        指针指向的内存区域保证有效
*	返回值：
*	        void
*	
*	输入描述:
*	输入正整数N（N不大于100）
*	
*	输出描述:
*	输出一个N行的蛇形矩阵。
*	
*	输入例子:
*	4
*	
*	输出例子:
*	1 3 6 10
*	2 5 9
*	4 8
*	7 
* 
*/
public class SnakeMatrix {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			
			//每行开始的数值
			int start = 1;
			for(int i = 0; i < num; i++){
				start = start + i;
				System.out.print(start);
				int tmp = start;
				for(int j = i + 2; j <= num; j++){
					tmp += j;
					
					System.out.print(" " + tmp);
										
				}
								
				System.out.println();
			}
		}
		sc.close();
	}
}
