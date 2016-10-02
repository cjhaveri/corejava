package test.cjhaveri.corejava.tricks;

import java.util.Arrays;

public class ArrayUtil {
    public ArrayUtil() {
    }

    static boolean sameArrays(int[] a, int[] b) {

        if (a == null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else if (a != null && b == null) {
            return false;
        } else if (a.length != b.length) {
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;

    }
}