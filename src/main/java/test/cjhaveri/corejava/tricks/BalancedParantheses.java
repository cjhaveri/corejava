package test.cjhaveri.corejava.tricks;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParantheses {

    public static void main(String[] args) {

       //code to just fake out the system.in
        String inputLine = "3\n{{[[(())]]}}\n{[(])}\n}}\n";
        InputStream in2 = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(in2);


        Scanner in = new Scanner(System.in);
        int totalLines = in.nextInt();

        //loop on the number of lines
        for (int i = 0; i < totalLines; i++) {
            //next line
            String input = in.next();
            //System.out.println("Input is: " + input);
            Stack<String> stack = new Stack<>();
            //state to whether get out of this loop
            boolean toBreak = false;
            //go through each character
            for (int j = 0; !toBreak && j < input.length(); j++) {
                //each character
                String s = Character.toString(input.charAt(j));

                switch (s) {
                    case "(":
                    case "{":
                    case "[":
                        stack.add(s);
                        break;
                    case "}":
                    case "]":
                    case ")":
                        if (stack.isEmpty()) {
                            //just push into stack to signal bad case
                            stack.add(s);
                            //we're done
                            toBreak = true;
                            break;
                        } else {
                            String topOne = stack.peek();
                            String expectedTop;
                            if (s.equals("]")) {
                                expectedTop = "[";
                            } else if (s.equals("}")) {
                                expectedTop = "{";
                            } else {
                                expectedTop = "(";
                            }
                            if (!topOne.equals(expectedTop)) {
                                //we're done
                                toBreak = true;
                                break;
                            }  else {
                                stack.pop();
                            }
                        }


                }//end switch


            }//end for loop

            //if the stack is empty, then it's a good one, else not
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}

