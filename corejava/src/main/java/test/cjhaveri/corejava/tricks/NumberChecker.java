package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 9/23/16.
 */
public class NumberChecker {

    public static void main(String[] args) {

        String[] test = {"a", "1", "1.1", "1.24", "0", "-1", null};
        for (String input : test) {

            if (input != null && input.matches("[-+]?\\d+(\\.\\d+)?")) {
                System.out.println(input + " is a number!");
            } else {
                System.out.println(input + " is not a number");
            }
        }


    }
}
