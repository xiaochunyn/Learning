package zzc.chun.zju.Learning.strings;

import java.util.Scanner;

/**
* @ClassName: CharacterSort    
* @author Captain Zhang   
* @date 2016年10月11日 下午7:14:07
*
* @Description: 
*	题目描述
*	
*	编写一个程序，将输入字符串中的字符按如下规则排序。
*	规则1：英文字母从A到Z排列，不区分大小写。
*	      如，输入：Type 输出：epTy
*	规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。
*	    如，输入：BabA 输出：aABb
*	规则3：非英文字母的其它字符保持原来的位置。
*	    如，输入：By?e 输出：Be?y
*	样例：
*	    输入：
*	   A Famous Saying: Much Ado About Nothing(2012/8).
*	    输出：
*	   A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
*
*	思路解析：
*	1. 将字符串转化为字符数组chs[]，
*	2. 提取所有字符，放入临时数组tmp[]
*	3. 遍历tmp[],如果元素在a~z,或 A~Z之间
*		将其加入到chs[]
*/
public class CharacterSort {

	public static void  main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			String aString = scanner.nextLine();
			
			char[] chs = aString.toCharArray();
			char[] tmp = new char[aString.length()];
			
			int m = 0;
			
			for(int i = 0; i < 26; i++){
				for(int j = 0; j < chs.length; j++){
					if(chs[j] - 'a' == i || chs[j] - 'A' == i){
						tmp[m++] = chs[j];
					}
				}
			}
			
			int n = 0;
			
			for(int i = 0; i < aString.length(); i++){
				if(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z'){
					chs[i] = tmp[n++];
				}
			}
			
			System.out.println(String.valueOf(chs));
		}
		
		scanner.close();
		
	}
}
