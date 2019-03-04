package jcrystal.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FBUser {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("MM/DD/YYYY");
	
	public String id;
	public String name;
	public String about;
	public String birthday;
	public String email;
	public String last_name;
	public String first_name;
	public String gender;
	
	
	/* FROMJSON */
	public FBUser(){
	}
	public FBUser(org.json.JSONObject json)throws org.json.JSONException{
		this.id = json.has("id")?json.getString("id"):null;
		this.name = json.has("name")?json.getString("name"):null;
		this.about = json.has("about")?json.getString("about"):null;
		this.birthday = json.has("birthday")?json.getString("birthday"):null;
		this.email = json.has("email")?json.getString("email"):null;
		this.last_name = json.has("last_name")?json.getString("last_name"):null;
		this.first_name = json.has("first_name")?json.getString("first_name"):null;
		this.gender = json.has("gender")?json.getString("gender"):null;
	}
	public Date getBirthday() {
		if(birthday==null || birthday.length() != 10)
			return null;
		try {
			return SDF.parse(birthday);
		} catch (ParseException e) {
			return null;
		}
	}
	public static java.util.ArrayList<FBUser> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<FBUser> ret = new java.util.ArrayList<FBUser>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new FBUser(json.getJSONObject(e)));
		}
		return ret;
	}
	/* END */
}

