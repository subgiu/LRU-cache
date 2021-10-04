# LRU (Least Recently Used) Cache

**A cache that returns the most recent element used and evicts the least recently according to a capacity.**  
**All operations must be very fast, because it will be used every time, running in a time complexity: O(1).**

It would be used in a web browser history scenario for example.

The cache has the add, get and getRecent operation. When you use the add or get, the respective element going to turn the most recent and it must be returned by the getRecent operation. 

The cache has a capacity, so when it would be reached, it is necessary to remove the last recent element. 

### For example: ### 
  
**Capacity:** 2.  
     
+ Cache: **The cache starts empty.**           
+ add(1); **Add the element 1 to the cache.**   
+ Cache: 1 **The cache has the element 1. **
+ The getRecent() returns 1.   
+ add(2);    
+ Cache: 2-1 **The cache has the element 2 and 1. **
+ The getRecent() returns 2.  
+ add(3);   
+ Cache: 3-2 **The cache has the element 2 and 3. (The last recent = 1 was removed, because it reached the capacity.)**
+ The getRecent() returns 3.  




+ For reaching this strict requirement about time complexity, it has been using a hash table to keep and get objects with O(1), 
and a Double Linked List for keeping the sequence of access because it provides a very fast way to add and remove elements O(1). 

 ***The implementation is generic, so the value would be everything, like a number or a string.***