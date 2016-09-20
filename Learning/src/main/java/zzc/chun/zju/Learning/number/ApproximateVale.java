package zzc.chun.zju.Learning.number;

import java.util.*;

/**
* @ClassName: ApproximateVale    
* @author Captain Zhang   
* @date 2016年9月20日 上午10:54:16
*
* @Description: 
* 
* 	题目描述
*	
*	写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
*	
*	输入描述:
*	输入一个正浮点数值
*	
*	输出描述:
*	输出该数值的近似整数值
*	
*	输入例子:
*	5.5
*	
*	输出例子:
*	6
* 
* 	思想:java的Math里面有三个函数，1.Math.ceil()表示向上取值Math.ceil(25.9)；  //26  
*
*	 2.Math.floor()表示向下取值Math.floor(25.9);// 25
*	
*	 3.Marh.round()表示四舍五入取值Math.floor(25.9);// 26
*
*/
public class ApproximateVale {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		float val = sc.nextFloat();
		
		System.out.println(Math.round(val));
		
		sc.close();
		
	}
}
