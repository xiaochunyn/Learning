package zzc.chun.zju.Learning.number;

import java.util.Scanner;

/**
* @ClassName: HexConvert    
* @author Captain Zhang   
* @date 2016年9月19日 下午5:19:24
*
* @Description: 
* 	写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
*
*	输入描述:
*	输入一个十六进制的数值字符串。
*	
*	输出描述:
*	输出该数值的十进制字符串。
*	
*	输入例子:
*	0xA
*	
*	输出例子:
*	10	
*
* 定义
*	16进制即逢16进1，其中用A，B，C，D，E，F（字母不区分大小写）这六个字母来分别表示10，11，12，13，14，15。故而有16进制每一位上可以是从小到大为0、1、2、3、4、5、6、7、8、9、A、B、C、D、E、F共16个大小不同的数。
*	转换
*	编辑
*	16进制到十进制
*	16进制数的第0位的权值为16的0次方，第1位的权值为16的1次方，第2位的权值为16的2次方……
*	所以，在第N（N从0开始）位上，如果是是数 X （X 大于等于0，并且X小于等于 15，即：F）表示的大小为 X * 16的N次方。
*	例：2AF5换算成10进制:
*	用竖式计算：
*	第0位： 5 * 16^0 = 5
*	第1位： F * 16^1 = 240
*	第2位： A * 16^2= 2560
*	第3位： 2 * 16^3 = 8192
*	-------------------------------------
*	10997
*	直接计算就是：
*	5 * 16^0 + F * 16^1 + A * 16^2 + 2 * 16^3 = 10997
**/
public class HexConvert {
	public static void main(String[] args){

//				
//		char a = 'A';
//		char aa = '0';
//		int b = aa;
//		System.out.println(b);
//		
//		System.out.println((char)(97));
		
		Scanner sc = new Scanner(System.in);
		
		//去掉0x前面两位
		String a ;
		while(sc.hasNext()){
			a = sc.nextLine().substring(2);
			System.out.println(convert(a));
		}
				
		sc.close();
						
	}
	
	public static int convert(String s){
	
		int sum = 0;

		char tmp;		
		 
		for(int i = 0; i < s.length(); i++){
			int val = 0;
			tmp = s.charAt(i);
			if(tmp >= '0' && tmp <= '9'){
				//特别注意，这里的tmp值为tmp的ACSII值，而非数字之值 ，如 ‘0’ 的ASCII为48
				val = tmp - '0';
			}else if(tmp >= 'A' && tmp <= 'F'){
				val = tmp - 'A' + 10;
			}else if(tmp >= 'a' && tmp <= 'f'){
				val = tmp - 'a' + 10;
			}else {
				break;
			}
			
			sum += val * Math.pow(16, s.length() - i - 1);
			
		}
		return sum;
	}
	
}
