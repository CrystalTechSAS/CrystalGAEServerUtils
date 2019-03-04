package jcrystal.utils;

import java.util.TreeMap;

public class CounterTreeMap<K> extends TreeMap<K, Integer>{
	private static final long serialVersionUID = -6758164354989194861L;
	public void count(K key){
		put(key, 1 + get(key));
	}
	public void count(K key, int m){
		put(key, m + get(key));
	}
	@Override
	public Integer get(Object key) {
		Integer ret = super.get(key);
		return ret==null ? 0 : ret;
	}
}
