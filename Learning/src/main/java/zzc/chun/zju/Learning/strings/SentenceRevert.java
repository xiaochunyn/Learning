package zzc.chun.zju.Learning.strings;

import java.util.*;

/**
* @ClassName: SentenceRevert    
* @author Captain Zhang   
* @date 2016年9月26日 下午3:55:54
*
* @Description: 
* 
* 	题目描述
	
	将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
	所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
	
	接口说明
		
		 * 反转句子
		 * 
		 * @param sentence 原句子
		 * @return 反转后的句子
		
		public String reverse(String sentence);
	 
	输入描述:
	将一个英文语句以单词为单位逆序排放。	
	
	输出描述:
	得到逆序的句子
	
	输入例子:
	I am a boy
	
	输出例子:
	boy a am I
	
	思路解析：
	方案一：
		从后向前遍历字符串，遇到空格则截取字串
		i + 1 为 beginIndex
		这里设置一个变量pos,表示substring 的endindex
		注意： 句子开头没有空格，所以i为0时，直接从0开始截取子串即可
		
	方案二：
		使用空格，将字符串切分为数组
		后续遍历输出即可
	
	两种方案OJ输出性能一致，time=22ms, mem=402
		
	注意：
	substring的截取使用
	“abcd”.substring(1,1) 输出为空
	“abcd”.substring(1,2) 输出为b
	“abcd”.substring(1,3) 输出为bc
	
	
*/

public class SentenceRevert {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String sentence = sc.nextLine().trim();
		
		sc.close();
		
		System.out.println(reverse1(sentence));
	}
	
	public static String reverse(String sentence){
		StringBuilder sb = new StringBuilder();
		
		//endindex
		int pos = sentence.length();
		
		for(int i = sentence.length() - 1; i >=0 ; i--){
			if(sentence.charAt(i) == ' '){
				sb.append(sentence.substring(i + 1, pos)).append(" ");
				pos = i;
			}
			if(i == 0){
				sb.append(sentence.substring(0, pos));
			}
		}
		return sb.toString();
		
	}
	
	public static String reverse1(String sentence){
		StringBuilder sb = new StringBuilder();
		
		String[] val ;
		val = sentence.split(" ");
		
		for(int i = val.length - 1; i >= 0; i--){
			sb.append(i == 0 ? val[i] : val[i] + " ");
		}
		return sb.toString();
	}

}
