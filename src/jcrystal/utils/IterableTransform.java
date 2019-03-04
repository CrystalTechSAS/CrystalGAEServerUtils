package jcrystal.utils;

import java.util.Iterator;

public abstract class IterableTransform<V, K> implements Iterable<K>{
	
	Iterable<V> it;
	public IterableTransform(Iterable<V> it) {
		this.it = it;
	}
	@Override
	public Iterator<K> iterator() {
		return new IteratorTransform(it.iterator());
	}
	public abstract K transform(V v);
	private class IteratorTransform implements Iterator<K>{
		Iterator<V> it;
		public IteratorTransform(Iterator<V> it) {
			this.it = it;
		}
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}
		
		@Override
		public K next() {
			return transform(it.next());
		}
	}
}
