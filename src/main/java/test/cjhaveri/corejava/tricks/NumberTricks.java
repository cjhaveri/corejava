package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 10/3/16.
 * Based on http://javarevisited.blogspot.sg/2013/06/how-to-add-two-integer-numbers-without-plus-arithmetic-operator-java-example.html?m=1
 *
 */
public class NumberTricks {

    public int addTwoNumberWithoutPlus() {
        int a = 5;
        int b = 6;

        while (b != 0){
            int carry = (a & b) ; //CARRY is AND of two bits

            a = a ^b; //SUM of two bits is A XOR B
            System.out.println(a);
            b = carry << 1; //shifts carry to 1 bit to calculate sum
            System.out.println(b);
        }
        System.out.println(a);
        return a;
    }

    public void swapTwoNumbers(int a, int b) {

        System.out.println("a = " + a + ", b = " + b);

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println("a = " + a + ", b = " + b);
    }



    public static void main(String[] args) {

        NumberTricks nt = new NumberTricks();

        nt.swapTwoNumbers(5,12);

        int a = 1024;
        while (a != 0) {
            a = a >> 1;
            System.out.println(a);
        }
    }

}
