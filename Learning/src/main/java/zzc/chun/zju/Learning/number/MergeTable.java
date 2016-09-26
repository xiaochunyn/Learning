package zzc.chun.zju.Learning.number;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
* @ClassName: MergeTable  
* @author Captain Zhang   
* @date 2016年9月20日 下午7:58:58
* @version V1.0
* 
* @Description: 
* 	题目描述
	
	数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
	即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
	
	输入描述:
	先输入键值对的个数
	然后输入成对的index和value值，以空格隔开
	
	
	输出描述:
	输出合并后的键值对（多行）
	
	输入例子:
	4
	0 1
	0 2
	1 2
	3 4
	
	输出例子:
	0 3
	1 2
	3 4

 	思路分析：
 	将数值存储到Map中
 	如果，key存在，则累计求和
 	否则直接put到map中
 	
 	注意：
 	HashMap是没有根据key值进行排序的
 	可以用TreeMap
 	
*/
public class MergeTable {

	public static void main(String[] args){
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		
		int key = 0; 
		int val = 0;
		
		for(int i = 0; i < count; i++){
			key = scanner.nextInt();
			val = scanner.nextInt();
						
			//如果Key存在，则累计求和
			if(map.containsKey(key)){
				map.put(key, val + map.get(key));
			}else{
				//直接放入map
				map.put(key, val);
			}
		}
		
		scanner.close();
		
		for(int k : map.keySet()){
			System.out.println(k + " " + map.get(k));
		}
		
	}
}
