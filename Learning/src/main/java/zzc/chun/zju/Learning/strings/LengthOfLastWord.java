package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: LengthOfLastWord
* @Description: 
* 计算字符串最后一个单词的长度，单词以空格隔开。
* 
* 输入描述:
* 一行字符串，非空，长度小于5000。
* 
* 输出描述:
* 整数N，最后一个单词的长度。
* 
* 输入例子:
* hello world
* 
* 输出例子:
* 5
*    
* @author Captain Zhang   
* @date 2016年9月15日 下午4:20:41
* @version V1.0
* 
*/
public class LengthOfLastWord {

	public static void main(String []args) {
		
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine().trim();
        sc.close();
        int len = 0;
        
        if(s.length() == 0 || s.equals("NULL")){
            len = 0;
            return;
        }
                
        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == ' '){
                len = s.length() - i - 1;
                break;
            }else{
                len = s.length();
            }
        }
        
        System.out.println(len);
    }
    
}

