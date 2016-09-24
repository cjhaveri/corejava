package test.cjhaveri.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class KeystoreUtil {

	public static void main(String[] args) {

		try {
			KeyStore ks = KeyStore.getInstance("JCEKS");
			// InputStream is = new FileInputStream(new File(
			// "/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/security/cacerts"));
			InputStream is = new FileInputStream(new File("/tmp/mynewcacerts"));

			ks.load(is, "newone".toCharArray());
			for (Enumeration<String> aliases = ks.aliases(); aliases.hasMoreElements();) {
				String alias = aliases.nextElement();
				if (ks.isKeyEntry(alias)) {
					System.out.println(alias + " is a key");
				} else if (ks.isCertificateEntry(alias)) {
					System.out.println(alias + "is a certificate");
				} else {
					System.out.println("none matched :(");
				}
			}

			// ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// ks.store(bos, "newone".toCharArray());
			//
			// byte[] toBeWritten = bos.toByteArray();
			// FileOutputStream fos = new FileOutputStream(new
			// File("/tmp/mynewcacerts"));
			// fos.write(toBeWritten);
			// fos.close();

		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
