/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.db.datastore.query;

import java.util.function.Predicate;

import com.google.appengine.api.datastore.Entity;

import jcrystal.context.DataStoreContext;

public abstract class AbsBaseHelper <T extends AbsBaseHelper<T,Q>, Q>{
	protected com.google.appengine.api.datastore.FetchOptions fetchOptions;
	protected com.google.appengine.api.datastore.Transaction $txn = null;
	protected DataStoreContext dsContext;
	final T t;
	@SuppressWarnings("unchecked")
	protected AbsBaseHelper(DataStoreContext dsContext){
		t = (T)this;
		this.dsContext = dsContext;
	}
	
	public T limit(int limit){
		if(fetchOptions == null && $txn == null){
			T ret = create();
			ret.fetchOptions = com.google.appengine.api.datastore.FetchOptions.Builder.withLimit(limit);
			return ret;
		}
		else{
			fetchOptions = fetchOptions.limit(limit);
			return t;
		}
	}
	public T txn(){
		if(fetchOptions == null && $txn == null){
			T ret = create();
			ret.$txn = dsContext.getTxn();
			return ret;
		}
		else{
			t.$txn = dsContext.getTxn();
			return t;
		}
	}
	public T chunkSize(int chunkSize){
		if(fetchOptions == null && $txn == null){
			T ret = create();
			ret.fetchOptions = com.google.appengine.api.datastore.FetchOptions.Builder.withChunkSize(chunkSize);
			return ret;
		}
		else{
			fetchOptions = fetchOptions.chunkSize(chunkSize);
			return t;
		}
	}
	public abstract T create();
	public abstract Q create(Entity entidad);
	protected java.util.List<Q> processQuery(com.google.appengine.api.datastore.Query q, Predicate<Q> filtro){
		java.util.List<Q> ret = new java.util.ArrayList<>();
		com.google.appengine.api.datastore.PreparedQuery _pq = dsContext.service.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions)){
			Q $nuevo = create(ent);
			if(filtro==null || filtro.test($nuevo)){
				ret.add($nuevo);
			}
		}
		return ret;
	}
	protected java.util.List<Q> processQuery(com.google.appengine.api.datastore.Query q){
		java.util.List<Q> ret = new java.util.ArrayList<>();
		com.google.appengine.api.datastore.PreparedQuery _pq = dsContext.service.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions))
		ret.add(create(ent));
		return ret;
	}
	protected Q processQueryUnique(com.google.appengine.api.datastore.Query q){
		com.google.appengine.api.datastore.PreparedQuery _pq = dsContext.service.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions))
		return create(ent);
		return null;
	}
	protected Q processQueryUnique(com.google.appengine.api.datastore.Query q, Predicate<Q> filtro){
		com.google.appengine.api.datastore.PreparedQuery _pq = dsContext.service.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions)) {
			Q $nuevo = create(ent);
			if(filtro == null || filtro.test($nuevo)){
				return $nuevo;
			}
		}
		return null;
	}
}

