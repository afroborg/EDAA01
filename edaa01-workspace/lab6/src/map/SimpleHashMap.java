package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private static final double LOAD_FACTOR = 0.75;

	private Entry<K, V>[] table;

	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and the
	 * default load factor (0.75).
	 */
	public SimpleHashMap() {
		this(16);
	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		this.table = (Entry<K, V>[]) new Entry[capacity];
	}

	@Override
	public V get(Object key) {
		@SuppressWarnings("unchecked")
		Entry<K, V> e = find(index((K) key), (K) key);

		return e != null ? e.getValue() : null;

	}

	@Override
	public boolean isEmpty() {
		// Check if size is 0
		return this.size() == 0;
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> temp = this.find(this.index(key), key);

		V r = null;

		// Check if value exists
		if (temp != null) {
			r = temp.getValue();
			temp.setValue(value);
		}

		else {
			int i = this.index(key);
			Entry<K, V> e = new Entry<>(key, value);
			
			// If indx is empty
			if (this.table[i] == null)
				this.table[i] = e;

			else {
				// Get Entry for key
				temp = this.table[index(key)];

				// Go to end of entries
				while (temp.next != null) {
					temp = temp.next;
				}
				
				//Add it to the end
				temp.setNext(e);
			}
		}

		// If higher than load factor, rehash
		if (this.size() >= LOAD_FACTOR * this.table.length) {
			this.rehash();
		}

		return r;
	}

	@Override
	public V remove(Object key) {
		@SuppressWarnings("unchecked")
		K k = (K) key;
		int idx = this.index(k);
		
		// Return null if table is empty
		if(this.isEmpty()) {
			return null;
		}
		
		// First value in table map
		Entry<K, V> entry = table[idx];
		
		// Return null if no entry matches key
		if(entry == null)
			return null;
		
		// Check if its first value
		if(entry.key.equals(k)) {
			table[idx] = entry.next;
			return entry.value;
		}
		
		// If not - loop through values to find it
		Entry<K, V> prev = entry;
		entry = entry.next;
		
		while(entry != null) {
			if(entry.key.equals(k)) {
				prev.next = entry.next;
				return entry.value;
			}
			
			prev = entry;
			entry = entry.next;
		}
		
		return null;
		
	}

	@Override
	public int size() {
		int c = 0;

		for (int i = 0; i < this.table.length; i++) {
			Entry<K, V> temp = this.table[i];

			// Loop through all keys in map
			while (temp != null) {
				temp = temp.next;
				c++;

			}
		}
		return c;
	}

	public String show() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				str.append(i + "\t" + table[i].toString());

				Entry<K, V> temp = table[i];

				// Loop through all keys in map
				while (temp.next != null) {
					str.append(i + "\t" + table[i].next.toString());
					temp = temp.next;
				}

				str.append("\n");
			}
		}

		return str.toString();
	}

	private int index(K key) {
		return Math.abs(key.hashCode() % this.table.length);
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> temp = this.table[index];

		// Loop through to find it
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}

			temp = temp.next;
		}

		return null;

	}

	//TODO: Fix
	@SuppressWarnings("unchecked")
	private void rehash() {
		// Save ref to current table
		Entry<K, V>[] oldTable = this.table;
		
		// Double the length of current table
		this.table = (Entry<K, V>[]) new Entry[this.table.length * 2];
		
		
		// Loop through all old values
		for(Entry<K, V> e : oldTable) {
            Entry<K, V> entry = e;
            
            while(entry != null) {
            	// Place them back using put logic
            	this.put(entry.getKey(), entry.getValue());
            	entry = entry.next;
            }
            
		}

	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}

		public Entry<K, V> setNext(Entry<K, V> next) {
			this.next = next;
			return this.next;
		}

	}

}
