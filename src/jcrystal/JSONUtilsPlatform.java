/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal;

import java.util.List;

import org.json.JSONObject;

public class JSONUtilsPlatform {
	public static String json(com.google.appengine.api.datastore.GeoPt a){return "["+Float.toString(a.getLatitude())+","+Float.toString(a.getLongitude())+"]";}
	public static String json(com.google.appengine.api.datastore.Email a){return JSONObject.quote(a.getEmail());}
	public static String jsonQuote(com.google.appengine.api.datastore.GeoPt a){return "["+Float.toString(a.getLatitude())+","+Float.toString(a.getLongitude())+"]";}
	public static String jsonQuote(com.google.appengine.api.datastore.Email a){return JSONObject.quote(a.getEmail());}
	public static String jsonQuote(List<com.google.appengine.api.datastore.GeoPt> puntos){
		boolean coma=false;
		String ret = "[";
		for(com.google.appengine.api.datastore.GeoPt pt : puntos){
			if(coma)ret += ",["+JSONObject.doubleToString(pt.getLatitude()) + "," + JSONObject.doubleToString(pt.getLongitude()) + "]";
				else ret += "["+JSONObject.doubleToString(pt.getLatitude()) + "," + JSONObject.doubleToString(pt.getLongitude()) + "]";
			coma = true;
		}
		return ret+"]";
	}
}
