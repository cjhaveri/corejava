package test.cjhaveri.corejava.tricks;

import java.util.Arrays;

/**
 * Created by chetanjhaveri on 10/8/16.
 */
public class ReverseSentence {

    public String reverseSentence(String input) {

        String [] words = input.split(" ");
        System.out.println(Arrays.toString(words));

        for (int i=0; words != null && i < words.length; i++) {
            //compute the corresponding last one

            int correspondingLastOne = words.length - 1 - i;
            String current = words[i];
            words[i] = words[correspondingLastOne];
            words[correspondingLastOne] = current;

            if (correspondingLastOne <= i) {
                System.out.println("reached the last one to be swapped");
                break;
            }  else {

                System.out.println(i + ":" + correspondingLastOne);
            }
        }

        return Arrays.toString(words);

    }

    public static void main(String[] args) {

        String input = "Google awesome not";

        ReverseSentence a = new ReverseSentence();
        System.out.println(a.reverseSentence(input));
    }
}
