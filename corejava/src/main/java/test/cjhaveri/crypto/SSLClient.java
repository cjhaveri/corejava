package test.cjhaveri.crypto;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SSLClient {

	public static void main(String[] args) throws Exception {

		System.setProperty("javax.net.debug", "all");
		String httpsURL = "https://www.yahoo.com/";
		URL myurl = new URL(httpsURL);
		HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
		con.connect();
		// InputStream ins = con.getInputStream();
		// InputStreamReader isr = new InputStreamReader(ins);
		// BufferedReader in = new BufferedReader(isr);
		//
		// in.close();

		con.disconnect();

	}
}
