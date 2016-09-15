package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: CalCharacterCount
* @Description: TODO   
* @author Captain Zhang   
* @date 2016年9月15日 下午5:46:47
* @version V1.0
* 
*/
public class CalCharacterCount {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please input a string: ");		
		String aString = scanner.nextLine().toLowerCase();
		
		System.out.print("Please input a character that you want to find: ");		
		char[] c = scanner.nextLine().toLowerCase().toCharArray();
		
		//及时关闭输入流
		scanner.close();
		
		//查找字符个数
		int sum = 0;
		
		for(int i = 0; i < aString.length(); i ++){
			if(aString.charAt(i) == c[0]){
				++sum;
			}
		}
		
		System.out.println(sum);
		
	}
}
