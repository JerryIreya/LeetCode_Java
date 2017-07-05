package String;

import java.util.HashMap;
import java.util.Map;

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
        String s = "kjqwehrtashvjasrdj";
        StringNum003Solution solution = new StringNum003Solution();
        System.out.println("The length of the longest substring without repeating characters is " + solution.lengthOfLongestSubstring(s));
    }
}

class StringNum003Solution {

    int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int maxRepeatIndex = -1;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer put = map.put(s.charAt(i), i);
            if (put != null) {
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
}
