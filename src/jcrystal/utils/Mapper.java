package jcrystal.utils;

/**
* Created by g on 9/19/16.
*/
public interface Mapper<K, V> {
	public V get(K key);
}
