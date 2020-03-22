/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.db.firestore;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.appengine.api.datastore.Text;

public class EntityUtils {
	public static JSONArray getJsonArray(Map<String, Object> ent, String key) {
		String temp = getString(ent, key);
		if(temp == null)
			return null;
		return new JSONArray(temp);
	}
	public static JSONObject getJsonObject(Map<String, Object> ent, String key) {
		String temp = getString(ent, key);
		if(temp == null)
			return null;
		return new JSONObject(temp);
	}
	public static String getString(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return null;
			if(t instanceof Text)
			return ((Text)t).getValue();
		return (String)t;
	}
	public static boolean getBoolean(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return false;
			return (Boolean)t;
	}
	public static boolean getBoolean(Map<String, Object> ent, String key, boolean defaultValue){
		Object t = ent.get(key);
		if(t==null)return defaultValue;
			return (Boolean)t;
	}
	
	public static int getInt(Map<String, Object> ent, String key, int defaultValue){
		Object t = ent.get(key);
		if(t==null)return defaultValue;
		if(t instanceof Long)
			return ((Long)t).intValue();
		return (Integer)t;
	}
	public static double getDouble(Map<String, Object> ent, String key, double defaultValue){
		Object t = ent.get(key);
		if(t==null)return defaultValue;
		if(t instanceof Double)
			return (double)t;
		if(t instanceof Float)
			return ((Float)t).doubleValue();
		if(t instanceof Long)
			return ((Long)t).doubleValue();
		if(t instanceof Integer)
			return ((Integer)t).doubleValue();
		return (double)t;
	}
	public static int getInt(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return 0;
			if(t instanceof Long)
			return ((Long)t).intValue();
		return (Integer)t;
	}
	public static Integer getInteger(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return null;
			if(t instanceof Long)return ((Long)t).intValue();
			return (Integer)t;
	}
	public static long getLong(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return 0;
			if(t instanceof Integer)return ((Integer)t).longValue();
			return (Long)t;
	}
	public static long getLong(Map<String, Object> ent, String key, long defaultValue){
		Object t = ent.get(key);
		if(t==null)return defaultValue;
		if(t instanceof Integer)return ((Integer)t).longValue();
		if(t instanceof Long)return ((Long)t).longValue();
		return defaultValue;
	}
	public static Long getLongObj(Map<String, Object> ent, String key){
		Object t = ent.get(key);
		if(t==null)return null;
			if(t instanceof Integer)return ((Integer)t).longValue();
			return (Long)t;
	}
}
