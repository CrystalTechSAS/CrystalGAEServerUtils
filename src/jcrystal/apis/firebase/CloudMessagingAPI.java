package jcrystal.apis.firebase;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import jcrystal.JSONUtils;
import jcrystal.utils.InternalException;

public class CloudMessagingAPI {
	public static String GLOBAL_CLOUD_KEY;
	
	private final String cloudKey;
	private String to;
	
	public CloudMessagingAPI(String cloudKey) {
		this.cloudKey = "key="+(cloudKey == null ? GLOBAL_CLOUD_KEY : cloudKey);
	}
	public CloudMessagingAPI() {
		this(null);
	}
	
	public CloudMessagingAPI to(String to) {
		this.to = to;
		return this;
	}
	
	private void validate() {
		if(cloudKey == null)
			throw new NullPointerException("Not defined cloud key");
		if(to == null)
			throw new NullPointerException("Not defined target");
	}
	
	public int sendPushNotification(String title, String mensaje){
		return sendPushNotification(title, null, mensaje);
	}
	
	public int sendPushNotification(String title, String sound, String mensaje){
		validate();
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", cloudKey);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.connect();
	        
			OutputStream out = connection.getOutputStream();
			String ret;
			if(sound == null)
            		ret = "{\"to\":"+ JSONUtils.json(to)+", \"notification\": { \"title\":"+JSONUtils.json(title)+", \"text\": "+JSONUtils.json(mensaje)+"}}";
			else
            		ret = "{\"to\":"+ JSONUtils.json(to)+", \"notification\": { \"title\":"+JSONUtils.json(title)+", \"sound\": "+JSONUtils.json(sound)+", \"text\": "+JSONUtils.json(mensaje)+"}}";
			System.out.println(ret);
			out.write(ret.getBytes(Charset.forName("UTF-8")));
			out.flush();

			int resp = connection.getResponseCode();
			connection.disconnect();
			if(resp >= 300 || resp < 200)
				throw new InternalException(500, "Error connecting with firebase");
			return resp;
		} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalException(500, "Error connecting with firebase");
		}
	}
	public int sendPushNotification(){
		validate();
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", cloudKey);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.connect();
	        
			OutputStream out = connection.getOutputStream();
			String ret = "{\"to\":"+ JSONUtils.json(to)+"}";
			out.write(ret.getBytes(Charset.forName("UTF-8")));
			out.flush();

			int resp = connection.getResponseCode();
			connection.disconnect();
			if(resp >= 300 || resp < 200)
				throw new InternalException(500, "Error connecting with firebase");
			return resp;
		} catch (Exception ex) {
    			ex.printStackTrace();
			throw new InternalException(500, "Error connecting with firebase");
		}
	}
	public int sendPushData(String title, String body, String data){
		validate();
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", cloudKey);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.connect();
	        
			OutputStream out = connection.getOutputStream();
			String ret = "{\"to\":" + JSONUtils.json(to)+", \"notification\":{\"title\":"+JSONUtils.json(title)+",\"text\":"+JSONUtils.json(body)+"},\"data\": "+data+"}";
			out.write(ret.getBytes(Charset.forName("UTF-8")));
			out.flush();
            
			int resp = connection.getResponseCode();
			connection.disconnect();
			if(resp >= 300 || resp < 200)
				throw new InternalException(500, "Error connecting with firebase");
			return resp;
		} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalException(500, "Error connecting with firebase");
		}
	}
	public int sendPushData(String data){
		validate();
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", cloudKey);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.connect();
	        
			OutputStream out = connection.getOutputStream();
			String ret = "{\"to\":" + JSONUtils.json(to)+",\"data\": "+data+"}";
			out.write(ret.getBytes(Charset.forName("UTF-8")));
			out.flush();
            
			int resp = connection.getResponseCode();
			connection.disconnect();
			if(resp >= 300 || resp < 200)
				throw new InternalException(500, "Error connecting with firebase");
			return resp;
		} catch (Exception ex) {
    			ex.printStackTrace();
    			throw new InternalException(500, "Error connecting with firebase");
		}
	}
	public ServerUtils withServerKey(String server_key) {
		return new ServerUtils(server_key);
	}
	public static class ServerUtils{
		private String SERVER_KEY;
		private String topic;
		private ServerUtils(String server_key) {
			this.SERVER_KEY = server_key;
		}
		public ServerUtils withTopic(String topic) {
			this.topic = topic;
			return this;
		}
		public int subscribeToTopic(String token){
			token = token.replace("/", "");
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL("https://iid.googleapis.com/iid/v1/"+token+"/rel"+topic).openConnection();
				connection.setRequestMethod("POST");
				connection.setConnectTimeout(30000);
				connection.setRequestProperty("Authorization", SERVER_KEY);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);
				connection.connect();
				OutputStream out = connection.getOutputStream();
				out.close();
	            
				int resp = connection.getResponseCode();
				connection.disconnect();
				if(resp >= 300 || resp < 200)
					throw new InternalException(500, "Error connecting with firebase");
				return resp;
			} catch (Exception ex) {
	        		ex.printStackTrace();
	        		throw new InternalException(500, "Error connecting with firebase");
			}
		}
	}
}
