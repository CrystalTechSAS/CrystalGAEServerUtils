package jcrystal.utils;

import java.util.TreeMap;

public abstract class DefaultTreeMap<K, V> extends TreeMap<K, V>{
	private static final long serialVersionUID = -5333416110389237478L;
	@Override
	public V get(Object key) {
		V ret = super.get(key);
		if(ret==null)
			put((K)key, ret = def((K)key));
		return ret;
	}
	public abstract V def(K key);
}
