import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class YelpClient {

	final static int PORT = 80;

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://www.yelp.com/biz/the-velo-rouge-cafe-san-francisco");
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(String key: headers.keySet()) {
			System.out.println(key);
			List<String> values = headers.get(key);
			for(String value: values) {
				System.out.println("\t" + value);
			}
			
			
		}
//		BufferedReader reader = new BufferedReader(
//				new InputStreamReader(connection.getInputStream()));
//		String line;
//		while((line = reader.readLine()) != null) {
//			System.out.println(line);
//		}
		
	}
}
