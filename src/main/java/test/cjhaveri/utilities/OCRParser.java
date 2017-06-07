package test.cjhaveri.utilities;

import com.asprise.ocr.Ocr;

import java.io.File;

/**
 * Created by chetanjhaveri on 6/6/17.
 */
public class OCRParser {

    public static void main(String[] args) {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String s = ocr.recognize(new File[] {new File("/Users/chetanjhaveri/Desktop/Santa_Croce.pdf")},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        System.out.println("Result: " + s);
        ocr.stopEngine();
    }
}
