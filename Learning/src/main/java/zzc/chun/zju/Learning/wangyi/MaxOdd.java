package zzc.chun.zju.Learning.wangyi;

/**
* @ClassName: MaxOdd    
* @author Captain Zhang   
* @date 2016年9月21日 下午5:55:11
*
* @Description: 
* 
* import java.util.Scanner;
	 
	 
	public class Main{
	     
	    public static void main(String[] args) {
	        Scanner s=new Scanner(System.in);
	        long num=s.nextInt();
	        long sum=0;
	        for(long i=num;i>0;i=i/2){
	            long temp=(i+1)/2;
	            sum+=temp*temp;
	        }
	        System.out.println(sum);
	    }
	}
	 
	 
	总体思路：
	因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
	 
	比如1 2 3 4 5 6 7 8 9 10
	即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后n/2
	得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
	依次类推
	 
	细节问题：
	当n为偶数，就有n/2个奇数，根据等差数列求和公式 即(（首项+末项）*项数)/2,我们知道n/2个奇数和为((1+n-1)*n/2)/2,
	即为(n/2) * (n/2),此时n为偶数，因此 (n/2) * (n/2) = ((n+1)/2)  *  ((n+1)/2)
	 
	当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)  *  ((n+1)/2)
	因此两种情况可以用一个等式来总结
* 
*/
public class MaxOdd {

	public static void main(String[] args){
		
	}
	
}
