/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 * Total Marks LinkedStack Class: 15 Marks
 */
public class LinkedQueue<T> implements IQueue<T>, Cloneable {

	/** The underlying singly linked list */
	private SList<T> list;

	/**
	* Default constructor
	*/
	public LinkedQueue() {
		list = new SList<>();
	}
	/**
	* Returns the number of elements in the queue.
	* @return number of elements in the queue
	* 2 Marks
	*/
	@Override
	public int size() {
		//TODO: Complete
		return list.size();
	}

	/**
	* Tests whether the queue is empty.
	* @return true if the queue is empty, false otherwise
	* 2 Marks
	*/
	@Override
	public boolean isEmpty() {
		//TODO: Complete
		return list.isEmpty();
	}

	/**
	* Inserts an element at the rear of the queue.
	* @param element  the element to be inserted
	* 2 Marks
	*/
	@Override
	public void enqueue(T elem) {
		//TODO: Complete
		list.addLast(elem);
	}
	
	/**
	* Returns, but does not remove, the first element of the queue.
	* @return the first element of the queue (or null if empty)
	* 2 Marks
	*/
	@Override
	public T first() {
		//TODO: Complete
		
		if (isEmpty()) return null;
		return list.first();
	}

	/**
	* Removes and returns the first element of the queue.
	* @return element removed (or null if empty)
	* 2 Marks
	*/
	@Override
	public T dequeue() {
		//TODO: Complete
		
		if (isEmpty()) return null;
		return list.removeFirst();
	}

	/**
	* Returns clone of LinkedQueue
	* @return clone of LinkedQueue
	* 5 Marks
	*/
	@Override
	public LinkedQueue<T> clone() {
		//TODO: Complete
		
		LinkedQueue<T> CloneQueue = new LinkedQueue<>();
		CloneQueue.list= list.clone();
		return CloneQueue;
	}	
	
	/**
	* Method for displaying (front to back) and serialising items in the queue
	* @return string representation of the queue
	*/
	public String toString() {
		return list.toString();
	}
}
