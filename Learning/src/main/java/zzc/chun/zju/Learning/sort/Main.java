package zzc.chun.zju.Learning.sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String val = sc.nextLine();
        char[] a = val.toCharArray();
        int sum = a[0] - '0';
        for(int i = 1; i < a.length; i += 2){
            int v = a[i + 1] - '0';
            if(a[i] == '+'){
               sum += v;
            }
            if(a[i] == '-'){
                sum -= v;
            }
            if(a[i] == '*'){
                sum *= v;
            }
        }

        System.out.println(sum);
    }
}

/**

输入一行字符串，即一个表达式。其中运算符只有-，+，/。
        参与计算的数字只有0-9，保证表达式都是好合法的，排列规则如样例所示：
输入例子：
    3+5*7
输出例子：
    56

 **/
