package LRU.cache;

/**
 * Provide a Double Linked List implementation for keeping the priority about element access. 
 * 
 * @author Giuliano
 *
 */
public class DoubleLinkedListLRUCache {

	private final Node head;
	private final Node tail;
	
	public DoubleLinkedListLRUCache() {
		head = new Node("head");
		tail = new Node("tail");
		head.next = tail;
		tail.previous = head;
	}

	/**
	 * Set a new element as the most recent.
	 * 
	 * @param element
	 * @return The new Node created.
	 */
	public Node setRecent(Object element) {
		return addRecent(new Node(element));
	}
	
	/**
	 * Add the node as the most recent.
	 * 
	 * @param node
	 * @return The element.
	 */
	private Node addRecent(Node node) {
		node.previous = head;
		node.next = head.next; 
		node.next.previous = node; 
		head.next = node;
		if(tail.previous == head)
			tail.previous = node;
				
		return node;
	}
	
	/**
	 * Set an existent node as the most recent.
	 * The element provided must be in the list, otherwise it going to be a wrong behavior. 
	 * 
	 * @param element
	 * @return The element
	 */
	public Node setRecent(Node element) {
		if(head.next != element) {
			element.next.previous = element.previous;
			element.previous.next = element.next;
			element.previous.previous = element;
			if(tail.previous == element)
				tail.previous = element.previous;

			element.previous = head;
			element.next = head.next;		
			head.next = element;		
		}

		return element;
	}
		
	/**
	 * Return the most recent element.
	 * 
	 * @return  The most recent element if it exists, otherwise null;
	 */
	public Node getRecent() {
		return head.next == tail ? null : head.next;
	}
	
	/**
	 * Remove the last recent element.
	 * 
	 * @return The element removed or null if the cache would be empty.
	 */
	public Node removeLastRecent() {
		if(tail.previous == head)
			return null;
		
		Node nodeRemove = tail.previous;
		tail.previous = tail.previous.previous;
		tail.previous.next = tail;
		
		return nodeRemove;
	}
	
	/**
	 * The node of the list.
	 * 
	 * @author Giuliano
	 */
	public static class Node {
		private Object element;
		private Node previous;
		private Node next;
				
		public Node(Object element) {
			super();
			this.element = element;
		}
		
		public Object getElement() {
			return element;
		}		
	}
}
