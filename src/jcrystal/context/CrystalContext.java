package jcrystal.context;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.TransactionOptions;

public class CrystalContext {
	public static final ThreadLocal<CrystalContext> userThreadLocal = new ThreadLocal<>();
	public static void set() {
		userThreadLocal.set(new CrystalContext());
	}
	public static void clear() {
		userThreadLocal.remove();
	}
	public static CrystalContext get() {
		CrystalContext ret = userThreadLocal.get();
		if(ret == null)
			userThreadLocal.set(ret = new CrystalContext());
		return ret;
	}
	
	public final com.google.appengine.api.datastore.DatastoreService datastore = com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService();
	private com.google.appengine.api.datastore.Transaction txn;
	
	public final com.google.appengine.api.datastore.Transaction getTxn(){
		if(txn == null)
			txn = datastore.beginTransaction(TransactionOptions.Builder.withXG(true));
		return txn;
	}
	public final void endTx(){
		if(txn != null)
			txn.commit();
	}
	public final boolean rollbackTx(){
		if(txn != null && txn.isActive()) {
			txn.rollback();
			return false;
		}
		txn = null;
		return true;
	}
	public final void delete(Key...keys){
		datastore.delete(txn, keys);
	}
	public static final void withinTxn(int retries, int delta, Runnable run){
		for(int e = 0; e < retries; e++){
			try {
				run.run();
				CrystalContext.get().endTx();
			}finally {
				if (CrystalContext.get().rollbackTx()) {
					break;
				}
			}
			try {
				Thread.sleep((e+1) * delta);
			} catch (InterruptedException e1) {
				break;
			}
		}
	}
	public static final void withinTxn(Runnable run){
		withinTxn(5, 500, run);
	}
}
