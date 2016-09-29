package zzc.chun.zju.Learning.strings;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
* @ClassName: Test  
* @author Captain Zhang   
* @date 2016年9月18日 下午8:42:54
* @version V1.0
* 
* @Description: TODO 
*/
public class Test {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	*/
	public static void main(String[] args) {
		System.out.println((int)'b');
		
		System.out.println((char)98);
		
		System.out.println(5 / 8);
		System.out.println(7 / 8);
		
		String string = "asdfgfd";
		System.out.println(string.substring(0, 3) + "          " + string);
		
		System.out.println(1 << 5);
		
		Set<String> set = new TreeSet<String>();
		
		set.add("c");
		set.add("a");
		set.add("a");
		set.add("b");
		for(String s:set){
			System.out.println(s);
		}
		
		//aaaa
		String a = "abc";
		System.out.println(a.substring(0,1) + "a   aaa");
		
	}

}

