package jcrystal.datetime;
import java.util.*;
import java.text.ParseException;
public class CrystalDateMilis{
	public static final java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
	static {SDF.setTimeZone(TimeZone.getTimeZone("UTC"));}
	private final java.util.Date date;
	public CrystalDateMilis(String text)throws ParseException{
		date = SDF.parse(text);
	}
	public CrystalDateMilis(long time){
		date = new java.util.Date(time);
	}
	public CrystalDateMilis(){
		date = new Date();
	}
	public String format(){
		return SDF.format(date);
	}
	public java.util.Date toDate(){
		return date;
	}
	public static java.util.Date toDate(CrystalDateMilis cDate){
		return cDate == null ? null : cDate.date;
	}
	public static final java.text.SimpleDateFormat SDF_SIMPLE_TIME = new java.text.SimpleDateFormat("HH:mm");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE = new java.text.SimpleDateFormat("dd/MM/yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TEXT = new java.text.SimpleDateFormat("dd MMM yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TIME = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static CrystalDateMilis now(){
		return new CrystalDateMilis(System.currentTimeMillis());
	}
	public static CrystalDateMilis today(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		return new CrystalDateMilis(gc.getTimeInMillis());
	}
	public static CrystalDateMilis toMonth(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		gc.set(GregorianCalendar.DAY_OF_MONTH, 1);
		return new CrystalDateMilis(gc.getTimeInMillis());
	}
	public static CrystalDateMilis toWeek(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		gc.set(GregorianCalendar.DAY_OF_WEEK, 0);
		return new CrystalDateMilis(gc.getTimeInMillis());
	}
	public CrystalDateMilis add(int field, int value){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, value);
		return new CrystalDateMilis(gc.getTimeInMillis());
	}
	public CrystalDateMilis add(long time){
		return new CrystalDateMilis(date.getTime() + time);
	}
}
