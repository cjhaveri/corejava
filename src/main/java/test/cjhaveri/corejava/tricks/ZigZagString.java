package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 9/25/16.
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/
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
 * <p>
 * <p>
 * <p>
 * <p>
 * PAYPALISHIRING
 * 01234567890123
 * 04821357913260
 * PAHNAPLSIIGYIR
 * <p>
 * Rows = 3
 * 0,  4,  8,  2 (adding 4)
 * 1,3,5,7,9,1,3 (adding 2)
 * 2,  6,  0, (adding 4)
 * <p>
 * Rows = 5
 * 0,  6  2 (adding 6)
 * 1,  7  3 (adding 6)
 * 2,5,8,1, (adding 3)
 * 3,  9    (adding 6)
 * 4,  0,   (adding 6)
 */
public class ZigZagString {

    public String convert(String s, int numRows) {

        char [] transformed = new char[s.length()];

        for (int i=0; i < s.length(); i++) {
            //get the current char
            char n = s.charAt(i);
            //compute where it needs to go

            int goesAt;

            //detect if this is the middle row
            if (Math.ceil(numRows / 2.0) == i) {
                //in middle row
//                goesAt =
            }  else {
                //other rows

            }

        }
        return null;
    }
}
