package jcrystal.datetime;
import java.util.*;
import java.text.ParseException;
public class CrystalTime{
	public static final java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("HHmm");
	static {SDF.setTimeZone(TimeZone.getTimeZone("UTC"));}
	private final java.util.Date date;
	public CrystalTime(String text)throws ParseException{
		date = SDF.parse(text);
	}
	public CrystalTime(long time){
		date = new java.util.Date(time);
	}
	public CrystalTime(){
		date = new Date();
	}
	public String format(){
		return SDF.format(date);
	}
	public java.util.Date toDate(){
		return date;
	}
	public static java.util.Date toDate(CrystalTime cDate){
		return cDate == null ? null : cDate.date;
	}
	public static final java.text.SimpleDateFormat SDF_SIMPLE_TIME = new java.text.SimpleDateFormat("HH:mm");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE = new java.text.SimpleDateFormat("dd/MM/yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TEXT = new java.text.SimpleDateFormat("dd MMM yyyy");
	public static final java.text.SimpleDateFormat SDF_SIMPLE_DATE_TIME = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static CrystalTime now(){
		return new CrystalTime(System.currentTimeMillis());
	}
	public static CrystalTime today(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		return new CrystalTime(gc.getTimeInMillis());
	}
	public static CrystalTime toMonth(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		gc.set(GregorianCalendar.DAY_OF_MONTH, 1);
		return new CrystalTime(gc.getTimeInMillis());
	}
	public static CrystalTime toWeek(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.HOUR_OF_DAY, 0);
		gc.set(GregorianCalendar.MINUTE, 0);
		gc.set(GregorianCalendar.MILLISECOND, 0);
		gc.set(GregorianCalendar.DAY_OF_WEEK, 0);
		return new CrystalTime(gc.getTimeInMillis());
	}
	public CrystalTime add(int field, int value){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, value);
		return new CrystalTime(gc.getTimeInMillis());
	}
	public CrystalTime add(long time){
		return new CrystalTime(date.getTime() + time);
	}
}
