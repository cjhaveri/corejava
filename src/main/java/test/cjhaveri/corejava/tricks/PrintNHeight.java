package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 6/6/17.
 */
public class PrintNHeight {

    public static void main(String[] args) {

        int HEIGHT = 9;
        for (int i=1; i <= HEIGHT; i++){
            System.out.print(i);
            for (int j=0; j <=HEIGHT; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
