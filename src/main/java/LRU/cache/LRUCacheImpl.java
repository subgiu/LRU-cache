package LRU.cache;

import java.util.HashMap;
import java.util.Map;

import LRU.cache.DoubleLinkedListLRUCache.Node;

/**
 * Provide the implementation for LRU(Least Recent Used) cache functionality.
 *
 */
public class LRUCacheImpl<T> implements LRUCache<T>{

	private final int capacity; //The capacity of the cache.
	private int elementsCount;  //The elements count in cache.
	private final Map<T, Node> elementsMap; //A map with elements (T) and their respective linked list's Node.
	private final DoubleLinkedListLRUCache elementsLinkedList; //The linked list for keeping the sequence of access.

	public LRUCacheImpl(int capacity) {
		if(capacity <= 0)
			throw new RuntimeException("Its not possible to have a cache without a capacity!");
		
		this.capacity = capacity;
		this.elementsCount = 0;
		this.elementsMap = new HashMap<>(capacity);
		this.elementsLinkedList = new DoubleLinkedListLRUCache();
	}
	
	/**
	 * Add a element to the cache, according the capacity.
	 * 
	 * @param element
	 */
	public void add(T element) {
		Node mostRecentNode;
			
		if(elementsCount == capacity) {
			Node lastRecentNode = elementsLinkedList.removeLastRecent();
			elementsMap.remove(lastRecentNode.getElement());
		}else elementsCount++;
		
		if(elementsMap.containsKey(element)) 			
			mostRecentNode = elementsLinkedList.setRecent(elementsMap.get(element));
		else mostRecentNode = elementsLinkedList.setRecent(element);	
		
		elementsMap.put(element, mostRecentNode);
	}
	
	/**
	 * Return the element from the cache. If it wouldn't be in the cache, return null; 
	 * 
	 * @param element
	 * 
	 * @return The element or null;
	 */
	@SuppressWarnings("unchecked")
	public T get(T element) {
		if(elementsMap.containsKey(element))
			return (T) elementsLinkedList.setRecent(elementsMap.get(element)).getElement();
		
		return null;
	}
	
	/**
	 * Return the most recent element used from the cache. Return null if the cache would be empty.
	 * 
	 * @return The element or null;
	 */
	@SuppressWarnings("unchecked")
	public T getRecent() {
		Node recent = elementsLinkedList.getRecent();
		return recent == null ? null : (T) recent.getElement();
	}	
	
}
