package String;

import java.util.Random;

/**
 * Created by wangyazhou on 17-7-5.
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class StringNum005 {
    public static void main(String[] args) {
//        String s = "flksjdffdjsklwlekfjosifwlfabcdefghijklmnopqqponmlkjihgfedcbawoefajdkfwoiefjasldfkj";
//        System.out.println(new StringNum005Solution().longestPalindrome(s));

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        //测试我的方法和别人的方法是否结果一致
        //如果测试时打印出了false，只是代表这个字符串中包含了长度相同的多个回文串，我找到的
        for (int j = 0; j < 200; j++) {
            Random random = new Random();
            int length = random.nextInt(1000);
            char[] strChars = new char[length];

            for (int i = 0; i < length; i++) {
                strChars[i] = chars[random.nextInt(52)];
            }

            String s = new String(strChars);

            StringNum005Solution solution = new StringNum005Solution();
            if (!solution.longestPalindrome(s).equals(solution.longestPalindrome2(s))) {
                System.out.println(false);
                System.out.println(solution.longestPalindrome(s));
                System.out.println(solution.longestPalindrome2(s));
                System.out.println(s);
            }
//            else {
//                System.out.println(true);
//            }
        }
    }
}

class StringNum005Solution {
    String longestPalindrome(String s) {
        if (null == s)
            //如果s为null，返回null
            return null;
        if (s.length() < 2)
            //如果s的长度小于2，返回s
            return s;

        int lastEnd = 0;
        int lastStart = 0;
        int maxLength = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int left;
            int right = i + 1;


            if (s.charAt(i) == s.charAt(i + 1)) {
                left = i;
            } else
                left = i - 1;

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    if (maxLength < (right - 1 - left - 1)) {
                        maxLength = right - left - 2;
                        lastEnd = right - 1;
                        lastStart = left + 1;
                    }
                    break;
                }
                left--;
                right++;
            }
        }
//        System.out.println("lastStart: " + lastStart + ",  lastEnd: " + lastEnd);
        return s.substring(lastStart, lastEnd + 1);
    }

    String longestPalindrome2(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }

}
