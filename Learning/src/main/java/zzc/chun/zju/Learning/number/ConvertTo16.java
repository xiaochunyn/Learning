package zzc.chun.zju.Learning.number;
import java.util.*;

// 链接：https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
// 来源：牛客网

// 题目描述
// 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

// 输入描述:
// 输入一个十六进制的数值字符串。

// 输出描述:
// 输出该数值的十进制字符串。

// 输入例子:
// 0xA

// 输出例子:
// 10

public class ConvertTo16{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(convert1(sc.nextLine().substring(2)));

        System.out.println(convert2(sc.nextLine().substring(2)));

        sc.close();
    }

    private static int convert1(String val){
        return Integer.parseInt(val, 16);
    }

    private static int convert2(String val){
        int sum = 0;;
        for(int i = 0; i < val.length(); i ++){
            char tmp = val.charAt(i);
            int num = 0;

            if(tmp >= 'a' && tmp <= 'z'){
                num = tmp - 97 + 10;
            } else if(tmp >= 'A' && tmp <= 'Z'){
                num = tmp - 65 + 10;
            }else{
                num = tmp;
            }
            sum += num * Math.pow(16, val.length() - i - 1);
        }
        return sum;
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