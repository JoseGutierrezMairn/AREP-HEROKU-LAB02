package edu.escuelaing.arep.heroku.app.calculator;

/***
 * 
 * @author Jose Gutierrez Marin
 *
 */
public class Node {
	private double value;
	private Node next;
	
	/***
	 * Node's builder
	 * @param value Value the node will have
	 */
	public Node(double value) {
		this.value = value;
	}
	
	/***
	 * Use this method to obtain the node value
	 * @return Returns the node's value
	 */
	public double getValue() {
		return value;
	}
	
	/***
	 * Changes the node this node is pointing to
	 * @param next Indicates the node this node will be pointing to 
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/***
	 * Use to get the node this node is pointing to
	 * @return Returns the node this node is pointing to
	 */
	public Node getNext() {
		return next;
	}
	
}
