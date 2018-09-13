import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class YelpClient {

	final static int PORT = 80;

	//propagate exception to simplify demonstration code
	public static void main(String[] args) throws Exception {

		//create URL object
		URL url = new URL("https://www.yelp.com/biz/the-velo-rouge-cafe-san-francisco");

		//create secure connection 
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		//set HTTP method
		connection.setRequestMethod("GET");		
		connection.connect();

		printHeaders(connection);

		printBody(connection);

	}

	public static void printHeaders(URLConnection connection) {
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(String key: headers.keySet()) {
			System.out.println(key);
			List<String> values = headers.get(key);
			for(String value: values) {
				System.out.println("\t" + value);
			}
		}		
	}

	public static void printBody(URLConnection connection) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		} 
	}
}
