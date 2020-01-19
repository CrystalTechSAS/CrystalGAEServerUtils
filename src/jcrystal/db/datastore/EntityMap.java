package jcrystal.db.datastore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.google.appengine.api.datastore.EmbeddedEntity;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings({"rawtypes","unchecked"})
public class EntityMap<T> implements Map<String, T>{
	private EmbeddedEntity rawEntity;
	private Entity parentEntity;
	private String propertyName;
	public EntityMap(Entity parentEntity, String propertyName) {
		this.parentEntity = parentEntity;
		this.propertyName = propertyName;
		if(parentEntity.hasProperty(propertyName))
			this.rawEntity = (EmbeddedEntity)parentEntity.getProperty(propertyName);
		else 
			parentEntity.setUnindexedProperty(propertyName, this.rawEntity = new EmbeddedEntity());
	}
	public EmbeddedEntity getRawMap() {
		return rawEntity;
	}
	public EntityMap(Entity parentEntity, String propertyName, Map<String, T> map) {
		parentEntity.setUnindexedProperty(propertyName, this.rawEntity = new EmbeddedEntity());
		putAll(map);
	}
	@Override
	public void clear() {
		parentEntity.setUnindexedProperty(propertyName, this.rawEntity = new EmbeddedEntity());
	}
	@Override
	public boolean containsKey(Object arg0) {
		return rawEntity.hasProperty((String)arg0);
	}
	@Override
	public boolean containsValue(Object arg0) {
		return false;
	}
	@Override
	public Set<Entry<String, T>> entrySet() {
		Map ret = rawEntity.getProperties();
		return ((Map<String, T>)ret).entrySet();
		
	}
	@Override
	public T get(Object arg0) {
		return (T)rawEntity.getProperty((String)arg0);
	}
	@Override
	public boolean isEmpty() {
		return rawEntity.getProperties().isEmpty();
	}
	@Override
	public Set<String> keySet() {
		return rawEntity.getProperties().keySet();
	}
	@Override
	public T put(String arg0, T arg1) {
		rawEntity.setUnindexedProperty(arg0, arg1);
		return arg1;
	}
	@Override
	public void putAll(Map<? extends String, ? extends T> arg0) {
		arg0.forEach((k,v)->{
			rawEntity.setUnindexedProperty(k, v);
		});
	}
	@Override
	public T remove(Object arg0) {
		rawEntity.removeProperty((String)arg0);
		return null;
	}
	@Override
	public int size() {
		return rawEntity.getProperties().size();
	}
	@Override
	public Collection<T> values() {
		Collection ret = rawEntity.getProperties().values();
		return (Collection<T>)ret;
	}
}
