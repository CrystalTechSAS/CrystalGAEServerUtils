/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.context;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.TransactionOptions;

public class DataStoreContext {
	public final com.google.appengine.api.datastore.DatastoreService service = com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService();
	private com.google.appengine.api.datastore.Transaction txn;
	
	public final com.google.appengine.api.datastore.Transaction getTxn(){
		if(txn == null)
			txn = service.beginTransaction(TransactionOptions.Builder.withXG(true));
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
		service.delete(txn, keys);
	}
	public final void withinTxn(int retries, int delta, Runnable run){
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
