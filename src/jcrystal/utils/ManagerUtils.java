package jcrystal.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.appengine.api.datastore.GeoPt;
import jcrystal.utils.InternalException;

public class ManagerUtils {
	public static void assertFuture(Date date, String msg){
		if(date.getTime() <= System.currentTimeMillis())throw new InternalException(21, msg);
	}
	public static void assertNotEmpty(String val, String msg){
		if(isEmpty(val))throw new InternalException(21, msg);
	}
	public static void assertNotNull(Object val, String msg){
		if(val == null)throw new InternalException(21, msg);
	}
	public static void assertEq(Object obj1, Object obj2, String msg){
		if(!Objects.equals(obj1, obj2))throw new InternalException(22, msg);
	}
	public static void asserT(boolean cond, String msg){
		if(!cond)throw new InternalException(22, msg);
	}
	public static void asserT(int code, String msg, boolean cond){
		if(cond)throw new InternalException(code, msg);
	}
	public static boolean isEmpty(String val){
		return val == null || val.trim().isEmpty();
	}
	public static GeoPt geoPt(double lat, double lng){
		return new GeoPt((float)lat, (float)lng);
	}
	public static <T> T[] sort(T[] array, Comparator<T> comp) {
		Arrays.sort(array, comp);
		return array;
	}
	public static <T> List<T> sort(List<T> list, Comparator<T> comp) {
		Collections.sort(list, comp);
		return list;
	}
	
	public static boolean equal(long v1, long v2) {
		return v1 == v2;
	}
	public static boolean equal(long v1, Long v2) {
		return v2 != null && v1 == v2.longValue();
	}
	public static boolean equal(Long v1, long v2) {
		return v1 != null && v1.longValue() == v2;
	}
	public static boolean equal(Long v1, Long v2) {
		return (v1 == null && v2 == null) || (v1 != null && v2 != null && v1.longValue() == v2.longValue());
	}
}
