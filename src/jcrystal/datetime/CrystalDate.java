package jcrystal.datetime;
import java.util.*;
import java.text.ParseException;
public class CrystalDate{
	public static final java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("yyyyMMddHHmm");
	static {SDF.setTimeZone(TimeZone.getTimeZone("UTC"));}
	private final java.util.Date date;
	public CrystalDate(String text)throws ParseException{
		date = SDF.parse(text);
	}
	public CrystalDate(long time){
		date = new java.util.Date(time);
	}
	public CrystalDate(){
		date = new Date();
	}
	public String format(){
		return SDF.format(date);
	}
	public java.util.Date toDate(){
		return date;
	}
	public static java.util.Date toDate(CrystalDate cDate){
		return cDate == null ? null : cDate.date;
	}
	public static final java.text.SimpleDateFormat SDF_SIMPLE_TIME = new java.text.SimpleDateFormat("HH:mm");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE = new java.text.SimpleDateFormat("dd/MM/yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TEXT = new java.text.SimpleDateFormat("dd MMM yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TIME = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
	public CrystalDate add(int field, int value){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, value);
		return new CrystalDate(gc.getTimeInMillis());
	}
	public CrystalDate add(long time){
		return new CrystalDate(date.getTime() + time);
	}
}
