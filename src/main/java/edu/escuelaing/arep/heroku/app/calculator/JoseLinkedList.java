package edu.escuelaing.arep.heroku.app.calculator;

import java.util.*;
import java.io.*;
/***
 * 
 * @author Jose Gutierrez Marin
 * 
 */
public class JoseLinkedList extends AbstractSequentialList<Node> implements List<Node>, Deque<Node>, Cloneable, Serializable{


	private static final long serialVersionUID = 1L;
	private Node head;
	private Node tail;
	private int size;
	
	/***
	 * JoseLinkedList's builder
	 */
	public JoseLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addFirst(Node e) {
		if(head == null && tail == null) {
			head = tail = e;
			
		}else {
			tail.setNext(e);
			tail = e;
		}
		size++;
	}
	
	public Node getFirst() {
		
		return head;
	}
	
	public Node getLast() {
		
		return tail;
	}
	
	@Override
	public int size() {

		return size;
	}
	public void addLast(Node e) {
		
	}

	public boolean offerFirst(Node e) {

		return false;
	}

	public boolean offerLast(Node e) {

		return false;
	}

	public Node removeFirst() {

		return null;
	}

	public Node removeLast() {

		return null;
	}

	public Node pollFirst() {

		return null;
	}

	public Node pollLast() {

		return null;
	}

	

	

	public Node peekFirst() {

		return null;
	}

	public Node peekLast() {

		return null;
	}

	public boolean removeFirstOccurrence(Object o) {

		return false;
	}

	public boolean removeLastOccurrence(Object o) {

		return false;
	}

	public boolean offer(Node e) {

		return false;
	}

	public Node remove() {

		return null;
	}

	public Node poll() {

		return null;
	}

	public Node element() {

		return null;
	}

	public Node peek() {

		return null;
	}

	public void push(Node e) {
		
		
	}

	public Node pop() {

		return null;
	}

	public Iterator<Node> descendingIterator() {

		return null;
	}

	@Override
	public ListIterator<Node> listIterator(int index) {

		return null;
	}

	
}








