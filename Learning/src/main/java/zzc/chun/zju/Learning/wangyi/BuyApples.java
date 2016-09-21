package zzc.chun.zju.Learning.wangyi;
import java.util.*;

/**
* @ClassName: BuyApples    
* @author Captain Zhang   
* @date 2016年9月21日 下午4:26:43
*
* @Description: 
* 	
* 题目描述：
* 	小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
* 	 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
*  
*	输入描述: 
*	输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
*	
*	输出描述: 
*	输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
*	
*	输入例子: 
*	20
*	
*	输出例子: 
*	3
*
*	思路分析：
*	这里给出了一个普通的解决方案，时间发杂度为O(n)
*	- 假设用户输入的苹果数量为count,装8个苹果的袋子为A， 装6个苹果的袋子为B
*	- 如果count<6,或者为奇数，直接返回-1
* 	- 如果count可以被8整出，则直接返回
*  	- 
*  	- 求出A的最大值，
*  	- 循环递减A的值，判断余数是否可以被6整出
*  	-	若可以,跳出循环，输出结果
*/
public class BuyApples {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int val = sc.nextInt();

		sc.close();

		System.out.println(minBags(val));
	}

	public static int minBags(int count){
		//最小组合
		int result = -1;

		//如果苹果数量小于6，或者为奇数，则这届返回 -1
		if(count < 6 || (count % 2) != 0){
			return result;
		}

		if(count % 8 == 0){
			return count / 8;
		}

		//装8个苹果袋子的最大值
		int a = count / 8;
		
		//对8取余后的余数
		int left = 0;

		 for(int i = a; i >= 0; i--){
		 	left = count - (i * 8);
		 	if(left % 6 == 0){
		 		result = i + (left / 6);
		 		break;
		 	}
		 }

		 return result;
	}

}