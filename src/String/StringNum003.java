package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wangyazhou on 17-7-5.
 * <p>
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class StringNum003 {

    public static void main(String[] args) {
//        String s = "kjqwehrtashvjasrdj";
//        StringNum003Solution solution = new StringNum003Solution();
//        System.out.println("The length of the longest substring without repeating characters is " + solution.lengthOfLongestSubstring(s));

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        //测试我的方法和别人的方法是否结果一致
        for (int j = 0; j < 200; j++) {
            Random random = new Random();
            int length = random.nextInt(1000);
            char[] strChars = new char[length];

            for (int i = 0; i < length; i++) {
                strChars[i] = chars[random.nextInt(52)];
            }

            StringNum003Solution solution = new StringNum003Solution();

            String s = new String(strChars);
            if (solution.lengthOfLongestSubstring(s) != solution.lengthOfLongestSubstring2(s)) {
                System.out.println("false");
            }
//            else {
//                System.out.println("true");
//            }
        }
    }
}

class StringNum003Solution {

    int lengthOfLongestSubstring(String s) {
        //如果s是null或者s的长度为0，直接返回0
        if (s == null || s.length() == 0)
            return 0;

        //如果s的长度是1，直接返回1
        if (s.length() == 1)
            return 1;

        //定义一个HashMap，键值对中，s中的每个字符做键，该字符在s中的角标位置做值。
        Map<Character, Integer> map = new HashMap<>();

        //该变量记录重复字符中角标最大的字符的角标位置，初始值为-1，表示没有重复
        int maxRepeatIndex = -1;
        //该变量记录最大的没有重复字符的字串的长度
        int maxLength = 0;

        //从第一个字符到最后一个字符开始遍历
        for (int i = 0; i < s.length(); i++) {
            //遍历一个字符，就put到map中，根据HashMap的put方法可知，如果map中已经有了该字符为键的键值对，会把之前的值替换掉并返回
            Integer put = map.put(s.charAt(i), i);
            //如果put不是null，说明刚刚遍历了一个重复的字符
            if (put != null) {
                //如果目前重复字符的最大角标小于刚刚重复字符的角标，就替换
                if (maxRepeatIndex < put)
                    maxRepeatIndex = put;
            }
            int tempMaxLength = i - maxRepeatIndex;
            if (maxLength < tempMaxLength) {
                maxLength = tempMaxLength;
            }
        }
        return maxLength;
    }

    /**
     * LeetCode上别人的算法
     */
    int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
