/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.db.datastore.query;

import java.util.function.Predicate;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;

import jcrystal.context.DataStoreContext;

public abstract class AbsBaseHelper <T extends AbsBaseHelper<T,Q>, Q>{
	protected com.google.appengine.api.datastore.FetchOptions fetchOptions;
	protected com.google.appengine.api.datastore.Transaction $txn = null;
	protected com.google.appengine.api.datastore.Key ancestor;
	boolean custom = false;
	protected DataStoreContext dsContext;
	final T t;
	@SuppressWarnings("unchecked")
	protected AbsBaseHelper(DataStoreContext dsContext){
		t = (T)this;
		this.dsContext = dsContext;
	}
	private T createCustomInstance() {
		if(custom)
			return t;
		else{
			T ret = create();
			ret.custom = true;
			return ret;
		}
	}
	public T ancestor(com.google.appengine.api.datastore.Key ancestor){
		T ret = createCustomInstance();
		ret.ancestor = ancestor;
		return ret;
	}
	public T limit(int limit){
		T ret = createCustomInstance();
		if(ret.fetchOptions == null)
			ret.fetchOptions = com.google.appengine.api.datastore.FetchOptions.Builder.withLimit(limit);
		else
			ret.fetchOptions = ret.fetchOptions.limit(limit);
		return ret;
	}
	public T txn(){
		T ret = createCustomInstance();
		ret.$txn = dsContext.getTxn();
		return ret;
	}
	public T chunkSize(int chunkSize){
		T ret = createCustomInstance();
		if(ret.fetchOptions == null)
			ret.fetchOptions = com.google.appengine.api.datastore.FetchOptions.Builder.withChunkSize(chunkSize);
		else
			ret.fetchOptions = ret.fetchOptions.chunkSize(chunkSize);
		return ret;
	}
	public com.google.appengine.api.datastore.Query createWithOptions(String kind){
		com.google.appengine.api.datastore.Query ret = new Query(kind);
		if(ancestor != null)
			ret.setAncestor(ancestor);
		return ret;
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

