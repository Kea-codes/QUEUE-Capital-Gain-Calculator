
public class SList<T> implements Cloneable{
	
	private class Node<T> {
		private Node<T> next;
		private T element;
		
		public Node(Node<T> next, T element) {
			this.next = next;
			this.element = element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public T getElement() {
			return element;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public String toString() {
			if (element == null) {
				return "";
			}
			return element.toString();
		}
	}
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private Integer size = 0;
	
	/**
	 * Default constructor
	 */
	public SList() { }
	
	/**
	 * Returns clone of singly linked list
	 */
	@Override
	public SList<T> clone() {
		SList<T> newList = new SList<>();
		Node<T> currentNode = head;
		while(currentNode != null)
		{
			newList.addLast(currentNode.getElement());
			currentNode = currentNode.getNext();
		}
		return newList;
	}
	
	/**
	 * Add an element after a given node in the list
	 */
	public void addAfter(Node<T> node, T item) {
		if(isEmpty())
		{
			head.setElement(item);
			size++;
		}
		else
		{
			Node<T> newNode = new Node<T>(node.getNext(),item);
			node.setNext(newNode);
			size++;		
		}
	}

	/**
	 * Add an element to the start of the list
	 */
	public void addFirst(T item) {
		Node<T> newNode = new Node<T>(head, item);
		head = newNode;
		if (size==0)
			tail = head;
		size++;
	} 

	/**
	 * Add an element to the end of the list
	 */
	public void addLast(T item){
		Node<T> newest = new Node<T>(null, item);
		if (isEmpty())
		  head = newest;
		else
		  tail.setNext(newest);
		tail = newest;
		size++;
	}	
	
	/**
	 * Remove the first element from the list. The removed element is returned
	 */
	public T removeFirst() {
		if (isEmpty())
			return null;
		T elementToRem = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return elementToRem;
	}

	/**
	 * Returns the node that contains the element that is specified as a parameter
	 */
	public Node<T> search(T elem) {
		Node<T> currentNode = head;
		while(currentNode!=null)
		{
			if(currentNode.getElement().equals(elem))
			{
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	/**
	 * returns the first element in the list.
	 */
	public T first() {
		return head.getElement();
	}
	
	/**
	 * Returns true if the list is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Return the size of the list
	 */
	public Integer size() {
		return size;
	}
	
	/**
	 * Method for displaying and serialising items in the Singly-Linked List
	 */
	public String toString() {
		String result = "";
		Node<T> currentNode = head;
		
		while(currentNode!=null)
		{
			result += currentNode.toString() + "<->";
			currentNode = currentNode.getNext();
		}	
		return result;
	}
}
