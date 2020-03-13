package jcrystal.db.query;

import java.util.List;

import com.google.appengine.api.datastore.Query;

import jcrystal.db.datastore.query.AbsBaseHelper;

public class Page<T> {
	final AbsBaseHelper<?, T> helper;
	final com.google.appengine.api.datastore.Query query;
	
	String newCursor;
	String prevCursor;
	
	public Page(AbsBaseHelper<?, T> helper, Query query) {
		super();
		this.helper = helper;
		this.query = query;
	}
	public void setNewCursor(String newCursor) {
		this.newCursor = newCursor;
	}
	public void setPrevCursor(String prevCursor) {
		this.prevCursor = prevCursor;
	}
	public String getNewCursor() {
		return newCursor;
	}
	public String getPrevCursor() {
		return prevCursor;
	}
	public com.google.appengine.api.datastore.Query getQuery() {
		return query;
	}
	public List<T> getResult() {
		if(prevCursor == null)
			return helper.fill(this);
		else
			return helper.cursor(prevCursor).fill(this);
	}
	
}
