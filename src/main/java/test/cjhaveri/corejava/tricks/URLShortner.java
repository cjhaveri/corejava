package test.cjhaveri.corejava.tricks;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.stream.IntStream;

/**
 * Created by chetanjhaveri on 6/6/17.
 */
public class URLShortner {

    public static void main(String[] args) {

        //these are just random input that need an address
        int [] numbers = {1, 2, 3, 4, 5, 6, 7};

        try {

            //randomizer for salt
            SecureRandom randomNumberGenerator = SecureRandom.getInstanceStrong();

            for (int i=0; i < numbers.length; i++) {
                int randomStream = 0;
                while (randomStream <=0 ) {
                    randomStream = randomNumberGenerator.nextInt();
                }
                //take the number and format into a 8 digit string
                String numberStringFormat = StringUtils.leftPad(Integer.toString(numbers[i]), 8, "8") + randomStream;
                System.out.println(numberStringFormat);
                byte[] encoded = Base64.getEncoder().encode(numberStringFormat.getBytes(Charset.forName("UTF-8")));
                String encodedString = new String(encoded);
                System.out.println(encodedString);
                //give out the encoded string and also store it.

                //reverse the process now
                byte [] decoded = Base64.getDecoder().decode(encodedString.getBytes());

                String originalNumberStringFormat = new String(decoded, Charset.forName("UTF-8"));
                System.out.println(originalNumberStringFormat);

                //get original digit
                System.out.println("original string is at " + originalNumberStringFormat.substring(7,8));

                



            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }



    }
}
