import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class BoundedQueueTest {
	
	private BoundedQueue queue;

	@Before      // Set up - Called before every test method.
	public void setUp()
	{
		queue = new BoundedQueue(4);
	}

	@After      // Tear down - Called after every test method.
	public void tearDown()
	{
	  	queue = null;  // redundant in this example!
	}

	
	//Test C1: inicialización cuando la capacidad no es positiva
	@Test (expected = IllegalArgumentException.class)
	public void testForSoloNullElement()
	{
		queue = new BoundedQueue(-4);
	}
	
	// Test cola llena
	@Test(expected=IllegalStateException.class)
	public void test1 (){
		queue.deQueue();
		assertFalse(queue.isFull());
	}

	// Test cola vacia
	@Test(expected=IllegalStateException.class)
	public void test2 () {
		queue.deQueue();
		assertTrue (queue.isEmpty());
	}
	
	// Test happy path
	@Test
	public void test3 () {
		queue.enQueue((Object) 10);
	}
}

