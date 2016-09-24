package test.cjhaveri.experiments;

/**
 * Created by chetanjhaveri on 6/2/16.
 */
public class AddressLoader {

    public static void main(String[] args) {
        String zip = "ZIP";
        AddressType zip1 = AddressType.valueOf(zip);

        if (zip1 != null) {
            System.out.println("zip1 is null");
        }
    }
}
