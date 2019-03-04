package jcrystal.entity.queries;

import java.util.function.Predicate;

import com.google.appengine.api.datastore.Entity;

public abstract class AbsBaseHelper <T extends AbsBaseHelper<T,Q>, Q>{
	protected com.google.appengine.api.datastore.FetchOptions fetchOptions;
	protected com.google.appengine.api.datastore.Transaction $txn = null;
	final T t;
	@SuppressWarnings("unchecked")
	protected AbsBaseHelper(){t = (T)this;}
	
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
			ret.$txn = jcrystal.context.CrystalContext.get().getTxn();
			return ret;
		}
		else{
			t.$txn = jcrystal.context.CrystalContext.get().getTxn();
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
		com.google.appengine.api.datastore.PreparedQuery _pq = jcrystal.context.CrystalContext.get().datastore.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions)){
			Q $nuevo = create(ent);
			if(filtro.test($nuevo)){
				ret.add($nuevo);
			}
		}
		return ret;
	}
	protected java.util.List<Q> processQuery(com.google.appengine.api.datastore.Query q){
		java.util.List<Q> ret = new java.util.ArrayList<>();
		com.google.appengine.api.datastore.PreparedQuery _pq = jcrystal.context.CrystalContext.get().datastore.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions))
		ret.add(create(ent));
		return ret;
	}
	protected Q processQueryUnique(com.google.appengine.api.datastore.Query q){
		com.google.appengine.api.datastore.PreparedQuery _pq = jcrystal.context.CrystalContext.get().datastore.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions))
		return create(ent);
		return null;
	}
	protected Q processQueryUnique(com.google.appengine.api.datastore.Query q, Predicate<Q> filtro){
		com.google.appengine.api.datastore.PreparedQuery _pq = jcrystal.context.CrystalContext.get().datastore.prepare($txn, q);
		for(com.google.appengine.api.datastore.Entity ent : fetchOptions==null?_pq.asIterable():_pq.asIterable(fetchOptions)) {
			Q $nuevo = create(ent);
			if(filtro.test($nuevo)){
				return $nuevo;
			}
		}
		return null;
	}
}

