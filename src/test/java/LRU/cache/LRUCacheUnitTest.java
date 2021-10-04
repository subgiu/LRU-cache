package LRU.cache;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class LRUCacheUnitTest {
  
	private static LRUCache<String> lruCache; 
	private static String element1 = "1", element2 = "2", element3 = "3", element4 = "4", element5 = "5", element6 = "6";
	
	@Test
	public void createCacheWithoutCapacityTest() {
		assertThrows(RuntimeException.class, 
				()->{ lruCache = new LRUCacheImpl<>(0);	}, 
				"No capacity must thows a exception!");
	}
	
	@Test
	@Order(1)
	public void createCacheTest() {
		lruCache = new LRUCacheImpl<>(5);
	}
	
	@Test
	@Order(2)
	public void cacheEmptyTest() {
		assertNull(lruCache.get("10"), "The result must be null getting an element from the empty cache!");
		assertNull(lruCache.getRecent(), "The result must be null getting the recent from the empty cache!");
	}
	
	@Test
	@Order(3)
	public void addElement1Test() {
		lruCache.add(element1);		
		assertEquals(lruCache.get(element1), element1, "The element " + element1 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element1, "The element " + element1 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(4)
	public void addElement2Test() {
		lruCache.add(element2);		
		assertEquals(lruCache.get(element2), element2, "The element " + element2 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element2, "The element " + element2 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(5)
	public void addElement3Test() {
		lruCache.add(element3);		
		assertEquals(lruCache.get(element3), element3, "The element " + element3 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element3, "The element " + element3 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(6)
	public void addElement4() {
		lruCache.add(element4);		
		assertEquals(lruCache.get(element4), element4, "The element " + element4 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element4, "The element " + element4 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(7)
	public void addElement5Test() {
		lruCache.add(element5);		
		assertEquals(lruCache.get(element5), element5, "The element " + element5 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element5, "The element " + element5 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(8)
	public void addElement6Test() {
		lruCache.add(element6);		
		assertEquals(lruCache.get(element6), element6, "The element " + element6 + " must to be in the cache!");
		assertEquals(lruCache.getRecent(), element6, "The element " + element6 + " must to be the most recent in the cache!");
	}
	
	@Test
	@Order(9)
	public void removeElementReachCapacityTest() {
		assertNull(lruCache.get(element1), "The " + element1 + " must not to be in the cache due the capacity!");		
	}
}
