package LRU.cache;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import LRU.cache.DoubleLinkedListLRUCache.Node;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class DoubleLinkedListLRUCacheUnitTest {
  
	private static DoubleLinkedListLRUCache lruCache; 
	private static String element1 = "1", element2 = "2", element3 = "3", element4 = "4";
	private static Node nodeElement1, nodeElement2, nodeElement3, nodeElement4;
	
	@BeforeAll
	public void beforeStartTest() {
		lruCache = new DoubleLinkedListLRUCache();
	}
	
	@Test
	@Order(1)
	public void getRecentCacheEmptyTest() {
		assertNull(lruCache.getRecent(), "The result must be null getting the recent from the empty cache!");
	}
	
	@Test
	@Order(2)
	public void removeLastRecentCacheEmptyTest() {
		assertNull(lruCache.removeLastRecent(), "The result must be null removing the last recent from the empty cache!");
	}
	
	@Test
	@Order(3)
	public void removeLastRecentJust1ElementTest() {
		nodeElement1 = lruCache.setRecent(element1);		
		assertEquals(lruCache.removeLastRecent(), nodeElement1, "The result must be the element " + nodeElement1 + " !");
		assertNull(lruCache.getRecent(), "The result must be null getting the last recent from the empty cache!");
		assertNull(lruCache.removeLastRecent(), "The result must be null removing the last recent from the empty cache!");
	}
	
	@Test
	@Order(4)
	public void addElement1Test() {
		nodeElement1 = lruCache.setRecent(element1);		
		assertEquals(lruCache.getRecent(), nodeElement1, "The element " + nodeElement1 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(4)
	public void addElement2Test() {
		nodeElement2 = lruCache.setRecent(element2);		
		assertEquals(lruCache.getRecent(), nodeElement2, "The element " + nodeElement2 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(5)
	public void removeLastRecentElementTest() {
		assertEquals(lruCache.removeLastRecent(), nodeElement1, "The result must be the element " + nodeElement1 + " !");
		assertEquals(lruCache.getRecent(), nodeElement2, "The element " + nodeElement2 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(6)
	public void addElement3Test() {
		nodeElement3 = lruCache.setRecent(element3);		
		assertEquals(lruCache.getRecent(), nodeElement3, "The element " + nodeElement3 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(7)
	public void addElement4Test() {
		nodeElement4 = lruCache.setRecent(element4);		
		assertEquals(lruCache.getRecent(), nodeElement4, "The element " + nodeElement4 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(8)
	public void setRecentExistentNodeTest() {
		nodeElement3 = lruCache.setRecent(nodeElement3);		
		assertEquals(lruCache.getRecent(), nodeElement3, "The element " + nodeElement3 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(9)
	public void removeLastRecentsAfterAddingTest() {
		assertEquals(lruCache.removeLastRecent(), nodeElement2, "The element " + nodeElement2 + " must to be the most recent in the cache!");
		assertEquals(lruCache.getRecent(), nodeElement3, "The element " + nodeElement3 + " must to be the most recent in the cache!");
		assertEquals(lruCache.removeLastRecent(), nodeElement4, "The element " + nodeElement4 + " must to be the most recent in the cache!");
		assertEquals(lruCache.removeLastRecent(), nodeElement3, "The element " + nodeElement3 + " must to be the most recent in the cache!");
		assertNull(lruCache.removeLastRecent(), "The result must be null removing the last recent from the empty cache!");
	}
}
