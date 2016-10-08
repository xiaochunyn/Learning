package zzc.chun.zju.Learning.strings;
import java.util.*;

/**
* @ClassName: RmLeastCharacter    
* @author Captain Zhang   
* @date 2016年10月8日 上午10:42:06
*
* @Description: 
* 
* 	题目描述
*	
*	实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
*	输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
*	
*	输入描述:
*	字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
*		
*	输出描述:
*	删除字符串中出现次数最少的字符后的字符串。
*	
*	输入例子:
*	abcdd
*	
*	输出例子:
*	dd
*
**/
public class RmLeastCharacter {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			String str = sc.nextLine();

			if(str.length() > 20){
				continue;
			}

			int max[] = new int[26];

			char[] ch = str.toCharArray();

			int min = Integer.MAX_VALUE;

			for(int i = 0; i < ch.length; i++){
				max[ch[i] - 'a']++;
				min = min > max[ch[i] - 'a'] ? max[ch[i] - 'a'] : min;
			}

			for(int i = 0; i < max.length; i ++){
				if(max[i] == min){
					str = str.replaceAll(String.valueOf((char)(i + 97)), "");
				}
			}
			System.out.println(str);
		}
		
		sc.close();

    }
}

