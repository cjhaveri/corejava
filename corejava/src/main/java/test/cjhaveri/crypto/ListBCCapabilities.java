package test.cjhaveri.crypto;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

/**
 * List the available capabilities for ciphers, key agreement, macs, message
 * digests, signatures and other objects in the BC provider.
 */
public class ListBCCapabilities {
	public static void main(String[] args) {
		Provider provider = Security.getProvider("BC");

		Iterator<Object> it = provider.keySet().iterator();

		while (it.hasNext()) {
			String entry = (String) it.next();

			// this indicates the entry actually refers to another entry

			if (entry.startsWith("Alg.Alias.")) {
				entry = entry.substring("Alg.Alias.".length());
			}

			String factoryClass = entry.substring(0, entry.indexOf('.'));
			String name = entry.substring(factoryClass.length() + 1);

			System.out.println(factoryClass + ": " + name);
		}
	}
}