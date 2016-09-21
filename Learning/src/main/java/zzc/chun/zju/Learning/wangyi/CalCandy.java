package zzc.chun.zju.Learning.wangyi;

import java.util.Scanner;

/**
* @ClassName: CalCandy    
* @author Captain Zhang   
* @date 2016年9月21日 上午11:56:33
*
* @Description: 
* 
* 	题目描述：
* 	A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
	A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
	现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。 
	输入描述:
	输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
	范围均在-30到30之间(闭区间)。
		
	输出描述:
	输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
	如果不存在这样的整数A，B，C，则输出No
	
	输入例子:
	1 -2 3 4
	
	输出例子:
	2 1 3
	
	思路分析：
	仔细分析题目，将数学思维转化即可
*/

public class CalCandy {
	
	public static void main(String []args){
	
		Scanner sc = new Scanner(System.in);
		
		int a = 0, b = 0, c = 0, d = 0;
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		sc.close();
		
		int A, B, C;
		
		A = (a + c) / 2;
		B = (b + d) / 2;
		C = d - B;
		
		if((A - B == a) && (B - C == b) && (A + B == c) && (B + C == d)){
			System.out.println(A + " " + B + " " + C);
		}else{
			System.out.println("No");
		}
	}

}
