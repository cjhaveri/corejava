package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 10/14/16.
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 *
 */
public class WeightedSum {

    public int calculateWeight(String input) {

        int totalLength = 0;
        int currentDepth = 0;
        for (int i=0; i < input.length() && input !=null; i++) {

            char current = input.charAt(i);
            if (current == '{') {
                currentDepth++;
            } else if (current == '}') {
                currentDepth--;
            } else if (current != ',') {
                totalLength += Integer.parseInt(Character.toString(current)) * currentDepth;
//                totalLength += (current * currentDepth);
            }
        }

        return totalLength;
    }

    public static void main(String[] args) {

        WeightedSum s = new WeightedSum();
        System.out.println(s.calculateWeight("{{1,1},2,{1,1}}"));

    }
}
