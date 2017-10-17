package zzc.chun.zju.Learning.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chun on 17-10-13.
 *
 * http://www.lintcode.com/zh-cn/problem/3sum/

 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 注意事项

 在三元组(a, b, c)，要求a <= b <= c

 结果不能包含重复的三元组。

 样例
 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：
 (-1, 0, 1)

 (-1, -1, 2)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 对数组进行排序,这样就方便调整，二来输出不需要排序
        Arrays.sort(arr);

        int i = 0, last = arr.length - 1;
        while (i < last) {
            int a = arr[i], j = i + 1, k = last;
            while (j < k) {
                int b = arr[j], c = arr[k];
                int sum = a + b + c;
                if (sum == 0) {
                    res.add(new ArrayList<Integer>(){{add(a);add(b);add(c);}});
                }
                if (sum <= 0) {
                    // 注意不能含有相同的索引
                    while (arr[j] == b && j < k) ++j;
                }
                if (sum >= 0) {
                    while (arr[k] == c && j < k) --k;
                }
            }
            while (arr[i] == a && i < last) ++i;
        }

        return res;
    }

    public List<List<Integer>> method2 (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int b = nums[j], c = nums[k];
                int sum = a + b + c;
                if (sum == 0) {
                    res.add(new ArrayList<Integer>(){{add(a); add(b); add(c);}});
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String []args) {
        int a[] = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(a));

        int b[] = new int[]{-8, -2, -1, 0, 1, 2, 3, 6, 7, 8};
        System.out.println(new ThreeSum().threeSum(b));

        int c[] = new int[]{-2,0,0,2,2};

        System.out.println(new ThreeSum().method2(a));
        System.out.println(new ThreeSum().method2(b));
        System.out.println(new ThreeSum().method2(c));
    }
}
