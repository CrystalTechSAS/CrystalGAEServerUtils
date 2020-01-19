package jcrystal.db.datastore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.google.appengine.api.datastore.Entity;

@SuppressWarnings({"rawtypes","unchecked"})
public class EntityMap<T> implements Map<String, T>{
	private Entity rawEntity;
	public EntityMap(Entity rawEntity) {
		if(rawEntity != null)
			this.rawEntity = rawEntity;
		else
			this.rawEntity = new Entity("Map");
	}
	public EntityMap(Map<String, T> map) {
		this.rawEntity = new Entity("Map");
		putAll(map);
	}
	@Override
	public void clear() {
		rawEntity = new Entity("Map");
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
