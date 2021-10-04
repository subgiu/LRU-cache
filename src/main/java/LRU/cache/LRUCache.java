package LRU.cache;

public interface LRUCache<T> {

	/**
	 * Add a element to the cache, according the capacity.
	 * 
	 * @param element
	 */
	public void add(T element);
	
	/**
	 * Return the element from the cache. If it is not in the cache, return null; 
	 * 
	 * @param element
	 * 
	 * @return The element or null;
	 */
	public T get(T element); 
	
	/**
	 * Return the most recent element used from the cache. Return null if the cache would be empty.
	 * 
	 * @return The element or null;
	 */
	public T getRecent(); 
}
