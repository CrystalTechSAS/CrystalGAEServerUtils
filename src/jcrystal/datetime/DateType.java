package jcrystal.datetime;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public enum DateType {
	DATE_TIME("yyyyMMddHHmm", "dd/MM/yyyy HH:mm"),
	TIME("HHmm", "HH:mm"),
	DATE("yyyyMMddHHmm","dd/MM/yyyy"),
	DATE_SECONDS("yyyyMMddHHmmss", "dd/MM/yyyy HH:mm"),
	TIME_SECONDS("HHmmss", "HH:mm:ss"),
	DATE_MILIS("yyyyMMddHHmmssSSS", "dd/MM/yyyy HH:mm"),
	TIME_MILIS("HHmmssSSS", "HH:mm:ss");
	
	public final SimpleDateFormat FORMAT;
	public String format;
	public String userFormat;
	DateType(String format, String userFormat){
		FORMAT = new SimpleDateFormat(this.format = format);
		FORMAT.setTimeZone(CrystalDateUtils.DEFAULT_TIME_ZONE);
		this.userFormat = userFormat;
	}
}
