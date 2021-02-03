package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> node = new QueueNode<E>(e);
		
		
		// If list is empty, set next-ref = itself
		if(last == null) {
			node.next = node;
		}
		
		else {
			// copy next-ref from prev last to new last next-ref
			node.next = last.next;
			
			// set prev last next-ref to new last
			last.next = node;
			
		}
		
		// set new node last
		last = node;
		size++;
		
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return this.size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return last == null ? null : last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if(last == null) {
			return null;
		}
		
		QueueNode<E> first = last.next;
		
		// set new next-ref to next-next-ref;
		last.next = last.next.next;
		
		size--;
		
		// if list is supposted to be empty, set last = null
		if(size == 0) {
			last = null;
		}
		
		return first.element;
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if(q == this) {
			throw new IllegalArgumentException();
		}
		
		// if current list is empty
		if(last == null) {
			last = q.last;
		}
		
		else if(q.last != null) {
			// get last node of provided queue
			QueueNode<E> l = q.last;
			
			// get first node of provided queue
			QueueNode<E> f = q.last.next;
			
			
			// set first node of current queue as first node of provided queue
			l.next = last.next;
			// set last node of current to first node of provided
			last.next = f;
			
			// set last node as last node of provided queue
			last = l;
		}
		
		// Increase size
		size += q.size;
		
		// Empty provided queue
		q.last = null;
		q.size = 0;
		
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {	
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			// set position to first node of FIFO or null
			pos = last == null ? null : last.next;
		}
		public boolean hasNext() {
			return pos != null;
		}
		
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			E el = pos.element;
			
			// make sure that we're not going around in circles
			pos = pos.equals(last) ? null : pos.next;
			
			return el;
			
		}
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
