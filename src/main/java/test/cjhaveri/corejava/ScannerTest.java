package test.cjhaveri.corejava;

import java.util.*;
import java.io.*;


public class ScannerTest{
    public static void main(String []argh)
    {



        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String nextLine = sc.nextLine();
            if (nextLine == null || nextLine.equals("")) {
                break;
            } else {
                System.out.printf("%d %s%n", i++, nextLine);
            }
        }
        sc.close();


    }
}

