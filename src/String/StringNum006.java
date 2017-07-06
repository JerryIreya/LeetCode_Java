package String;

/**
 * Created by wangyazhou on 17-7-6.
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class StringNum006 {
    public static void main(String[] args) {

    }
}

class StringNum006Solution {

    public String convert(String s, int numRows) {
        if (s.length() < numRows)
            return s;

        return null;
    }
}
