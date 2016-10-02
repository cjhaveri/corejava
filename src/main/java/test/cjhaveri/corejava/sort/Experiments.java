package test.cjhaveri.corejava.sort;

import java.nio.charset.Charset;

import test.cjhaveri.crypto.Utils;

public class Experiments {

	public static void main(String[] args) {
		String a = "!Chetan";
		byte[] array = a.getBytes(Charset.forName("UTF-8"));

		System.out.println("Array length:" + array.length);
		for (byte each : array) {
			System.out.println(each);
		}

		System.out.println("Hex:" + Utils.toHex(array));

		String b = new String(array, Charset.forName("UTF-8"));
		System.out.println(b);
	}

}
