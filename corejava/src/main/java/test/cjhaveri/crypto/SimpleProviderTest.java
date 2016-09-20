package test.cjhaveri.crypto;

import java.security.Security;

/**
 * Obtained from Beginning Java Cryptography Basic class to confirm the Bouncy
 * Castle provider is installed.
 * 
 * installed bcprov-jdk15on-154.jar in
 * /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/ext
 */
public class SimpleProviderTest {
	public static void main(String[] args) {
		String providerName = "BC";
		if (Security.getProvider(providerName) == null) {
			System.out.println(providerName + " provider not installed");
		} else {
			System.out.println(providerName + " is installed.");
		}
	}
}