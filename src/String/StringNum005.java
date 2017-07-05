package String;

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
        // TODO: 17-7-5 这个算法没有实现
    }
}

class StringNum005Solution {
    public String longestPalindrome(String s) {
        if (null == s)
            //如果s为null，返回null
            return null;
        if (s.length() < 2)
            //如果s的长度小于2，返回s
            return s;
        //默认取字符串的第一个字符，如果接下来没有找到长度大于1的回文串，就直接返回第一个字符
        String result = s.substring(0, 1);

        out:
        for (int i = 0; i < s.length(); i++) {

            //如果i之后的字符串的长度小于已经得到的回文串的长度，不再去找，因为找到也没有现在的长
            if (s.length() - 1 - i < result.length())
                break;

            int tempI = i;//用来记录回文串的开始角标
            int j = s.length() - 1;//用来记录回文串的结束角标

            for (; j >= i; j--) {
                if (s.charAt(tempI) == s.charAt(j)) {
                    tempI++;
                    if (tempI == j)
                        break out;
                    continue;
                } else
                    break out;
            }

            //如果在内层循环中没有跳出外层循环，就重新给result赋值
            result = s.substring(i, j);
        }
        return result;
    }
}
