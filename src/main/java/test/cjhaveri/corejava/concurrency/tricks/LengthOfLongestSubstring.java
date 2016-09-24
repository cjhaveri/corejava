package test.cjhaveri.corejava.concurrency.tricks;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
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
 * Created by chetanjhaveri on 9/24/16.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> uniqueCharacters = new HashSet<>(52);
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; s != null && i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (uniqueCharacters.contains(currentCharacter)) {
                //commit max length
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                //reset the max length
                currentLength = 0;
                //clear out memory
                uniqueCharacters.clear();
            }
            uniqueCharacters.add(currentCharacter);
            currentLength++;
        }

        //repeat for the last one
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

}
