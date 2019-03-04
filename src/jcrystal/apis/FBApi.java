package jcrystal.apis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;

import org.json.JSONObject;
import org.json.JSONTokener;

import jcrystal.utils.InternalException;

public class FBApi {
	public static void main(String...args) {
		getUserInfo("EAAGpbQBsfIIBAP9MTWdS1eX8CIwi9xqVuoOQcHZBiXFRM5VnCZBACefVpU11JxFm8IeNQfH3p6apI765xawStdaJvVmyVZCUDuaxTFU2JohmOdCVxjC0xQ5NK6VZApQOZAcyl3yq7bw4PRSMg2wrls8AH7Kpi87SH2Eho2NeggKyZC5kXafJ1BRygvbQJoupQmDbXb0FXNnDR59k0e8cQ6TWRspTojyfbb2CAYlGofwAZDZD");
	}
	public static FBUser getUserInfo(String token){
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://graph.facebook.com/v2.11/me?fields=id,name,about,birthday,email,gender,first_name,last_name&access_token="+token).openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(30000);
			connection.connect();
			
			int resp = connection.getResponseCode();
			System.out.println(resp);
			if(resp>= 200 && resp < 300) {
				JSONObject json = new JSONObject(new JSONTokener(connection.getInputStream()));
				System.out.println(json.toString());
				connection.disconnect();
				FBUser ret = new FBUser(json);
				if(json == null || ret.id == null)
					throw new InternalException(500, "Unauthorized user");
				return ret;
			}
			if(resp >= 300 || resp < 200) {
				throw new InternalException(500, "Error connecting with facebook");
			}
			connection.disconnect();
			throw new InternalException(500, "Unauthorized user");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalException(500, "Unauthorized user");
		}
	}
}
