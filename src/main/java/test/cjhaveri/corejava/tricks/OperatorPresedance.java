package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 6/12/17.
 */
public class OperatorPresedance {

    public static void main(String[] args) {
        //prints 14
        //8/4 = 2
        //7 * 2 = 14
        //14 - 4 = 10
        int a = 7 * 8 / 4 - 4;
        System.out.println(a);
    }
}
