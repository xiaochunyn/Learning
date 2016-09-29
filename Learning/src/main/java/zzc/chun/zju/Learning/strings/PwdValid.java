package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: PwdValid    
* @author Captain Zhang   
* @date 2016年9月29日 下午5:37:23
*
* @Description: 
* 
* 	题目描述
*	
*	密码要求:
*	 
*	1.长度超过8位
*	 
*	2.包括大小写字母.数字.其它符号,以上四种至少三种
*	 
*	3.不能有相同长度超2的子串重复
*	 
*	说明:长度超过2的子串
*	
*	输入描述:
*	一组或多组长度超过2的子符串。每组占一行
*		
*	输出描述:
*	如果符合要求输出：OK，否则输出NG
*	
*	输入例子:
*	021Abc9000
*	021Abc9Abc1
*	021ABC9000
*	021$bc9000
*	
*	输出例子:
*	OK
*	NG
*	NG
*	OK
* 
*/
public class PwdValid {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int lowercase = 0; 
		int uppercase = 0;
		int digit = 0;
		int others = 0;
		
		String val ;
		while(scanner.hasNext()){
			lowercase = 0;
			uppercase = 0;
			digit = 0;
			others = 0;
			
			val = scanner.nextLine();
			
			if(val.length() < 8){
				System.out.println("NG");
				continue;
			}
			
			for(int i = 0; i < val.length(); i ++){
				if(val.charAt(i) >= '0' && val.charAt(i) <= '9'){
					digit = 1;
				}else if(val.charAt(i) >= 'A' && val.charAt(i) <= 'Z'){
					uppercase = 1;
				}else if (val.charAt(i) >= 'a' && val.charAt(i) <= 'z'){
					lowercase = 1;
				}else {
					others = 1;
				}
			}
			
			if(lowercase + uppercase + digit + others < 3){
				System.out.println("NG");
				continue;
			}
			
			String subString ;
			for(int i = 0; i < val.length() - 3; i++){
				subString = val.substring(i, i + 3);
				if(val.substring(i + 3).contains(subString)){
					System.out.println("NG");
					continue;
				}
			}
			System.out.println("OK");
		}
		
		scanner.close();
	}

}

