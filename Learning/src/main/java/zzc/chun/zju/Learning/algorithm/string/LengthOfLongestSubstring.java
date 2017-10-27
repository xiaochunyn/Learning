package zzc.chun.zju.Learning.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by chun on 17-10-27.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.

 */
public class LengthOfLongestSubstring {
    /**
     * 解析：
     * 从头到尾遍历字符串，把出现过的字符都放入set中，
     *  遇到set中没有的字符就放入set,并更新最长字串长度res
     *  遇到set中存在的字符，从左边开始删除字符,直到删除重复的字符为止
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res=0, left=0, right=0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
