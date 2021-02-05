package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;
	
	@BeforeEach
	void setUp() throws Exception {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		q1 = null;
		q2 = null;
	}

	@Test 
	void twoEmpty() {
		q1.append(q2);
		assertEquals(0, q1.size(), "Size for two combined queues is not zero");
	}
	
	@Test
	void emptyWithNonEmpty() {
		q1.offer(1);
		q1.offer(2);
		
		q2.append(q1);
		
		assertEquals(2, q2.size(), "Size is incorrect for q2");
	}
	
	@Test
	void nonEmptyWithEmpty() {
		q1.offer(1);
		q1.offer(2);
		
		q1.append(q2);
		
		assertEquals(2, q1.size(), "Size is incorrect for q2");
		assertEquals(1, q1.poll(), "Wrong element polled");
		assertEquals(2, q1.peek(), "Wrong element peeked");
	}
	
	@Test
	void twoNonEmpty() {
		q1.offer(1);
		q2.offer(2);
		q1.append(q2);
		
		assertFalse(q1.isEmpty(), "Queue should be empty");
		assertEquals(2, q1.size());
		assertTrue(q2.isEmpty(), "Queue should be empty");
	}
	
	@Test
	void appendItself() {
		assertThrows(IllegalArgumentException.class, () -> q1.append(q1), "Should throw error");
	}

}
