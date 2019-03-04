package jcrystal.utils;

import java.util.Arrays;

public class EntityBatch {
	public static void put(IEntity...ents){
		put(Arrays.asList(ents));
	}
	public static void putTxn(IEntity...ents){
		putTxn(Arrays.asList(ents));
	}
	public static void put(Iterable<IEntity> ents){
		jcrystal.context.CrystalContext.get().datastore.put(new jcrystal.utils.IterableTransform<IEntity, com.google.appengine.api.datastore.Entity>(ents){ @Override public com.google.appengine.api.datastore.Entity transform(IEntity v) { return v.getRawEntity(); }});
	}
	public static void putTxn(Iterable<IEntity> ents){
		jcrystal.context.CrystalContext $ctx = jcrystal.context.CrystalContext.get();
		$ctx.datastore.put($ctx.getTxn(), new jcrystal.utils.IterableTransform<IEntity, com.google.appengine.api.datastore.Entity>(ents){ @Override public com.google.appengine.api.datastore.Entity transform(IEntity v) { return v.getRawEntity(); }});
	}
}
