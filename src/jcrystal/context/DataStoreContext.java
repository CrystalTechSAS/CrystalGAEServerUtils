/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.context;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.TransactionOptions;

public class DataStoreContext {
	public final com.google.appengine.api.datastore.DatastoreService service = com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService();
	private com.google.appengine.api.datastore.Transaction txn;
	
	private final com.google.appengine.api.datastore.Transaction getTxn(){
		if(txn == null)
			txn = service.beginTransaction(TransactionOptions.Builder.withXG(true));
		return txn;
	}
	public final Entity get(Key key) throws EntityNotFoundException {
		return service.get(txn, key);
	}
	public final void withoutTxn(Runnable r) throws EntityNotFoundException {
		com.google.appengine.api.datastore.Transaction prev = txn;
		txn = null;
		r.run();
		txn = prev;
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
		service.delete(txn, keys);
	}
	public final void withinTxn(int retries, int delta, Runnable run){
		getTxn();
		for(int e = 0; e < retries; e++){
			try {
				run.run();
				endTx();
			}finally {
				if (rollbackTx()) {
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
	public final void withinTxn(Runnable run){
		withinTxn(5, 500, run);
	}
}
