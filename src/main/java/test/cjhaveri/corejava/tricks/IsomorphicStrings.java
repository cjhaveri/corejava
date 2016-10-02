package test.cjhaveri.corejava.tricks;

import java.util.HashMap;

/**
 * Solution for: https://leetcode.com/problems/isomorphic-strings/
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * Created by chetanjhaveri on 9/24/16.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {


        //easy for null check
        if (s == null && t == null) {
            return false;
        } else if (s == null && t != null) {
            return false;
        } else if (s != null && t == null) {
            return false;
        } else if (s.length() !=  t.length()) {
            return false;
        }

        //now the real work
        //go through each string, and build a substitution map
        //confirm each instance of substituation is done correctly

        //buid memory
        int MAP_SIZE = 52;
        HashMap<Character, Character> substitutionMap = new HashMap<Character,Character>(MAP_SIZE);
        //go through s
        for (int i=0; i < s.length(); i++) {
            //capture each character
            char sN = s.charAt(i);
            char tN = t.charAt(i);
            //check memory
            if (substitutionMap.containsKey(sN)) {
                char tHit = substitutionMap.get(sN);
                //if a mismatch
                if (tHit != tN) {
                    return false;
                }
            } else {
                //build memory
                substitutionMap.put(sN, tN);
            }
        }
        return true;

    }

}
