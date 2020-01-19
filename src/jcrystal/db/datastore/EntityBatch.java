/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.db.datastore;

import java.util.Arrays;

import jcrystal.context.DataStoreContext;
import jcrystal.utils.IterableTransform;

public class EntityBatch {
	public static void put(DataStoreContext dsContext, IEntity...ents){
		put(dsContext, Arrays.asList(ents));
	}
	public static void putTxn(DataStoreContext dsContext, IEntity...ents){
		putTxn(dsContext, Arrays.asList(ents));
	}
	public static void put(DataStoreContext dsContext, Iterable<IEntity> ents){
		dsContext.service.put(new jcrystal.utils.IterableTransform<IEntity, com.google.appengine.api.datastore.Entity>(ents){ @Override public com.google.appengine.api.datastore.Entity transform(IEntity v) { return v.getRawEntity(); }});
	}
	public static void putTxn(DataStoreContext dsContext, Iterable<IEntity> ents){
		dsContext.service.put(dsContext.getTxn(), new jcrystal.utils.IterableTransform<IEntity, com.google.appengine.api.datastore.Entity>(ents){ @Override public com.google.appengine.api.datastore.Entity transform(IEntity v) { return v.getRawEntity(); }});
	}
}
