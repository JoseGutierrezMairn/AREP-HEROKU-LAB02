package edu.escuelaing.arep.heroku.app.calculator;
/***
 * 
 * @author Jose Gutierrez Marin
 *
 */
public class Calculator {
	
	/***
	 * Calculator's Builder
	 */
	public Calculator(){
	}
	
	/***
	 * Method in charge of calculate the mean in a JoseLinkedList
	 * @param jl The JoseLinkedList
	 * @return Returns the mean of the linked list
	 */
	public double calculateMeanOf(JoseLinkedList jl) {
		double answ = 0;
		Node current = jl.getFirst();
		for (int i = 0; i < jl.size(); i++) {
			answ+= current.getValue();
			current =  current.getNext();
		}
		
		return answ/jl.size();
	}
	
	/***
	 * This method calculates the standard derivation in a JoseLinkedList
	 * @param jl This is the JoseLinkedList
	 * @param mean The jl's mean
	 * @return Returns the standard derivation
	 */
	public double calculateStandardDerivationOf(JoseLinkedList jl, double mean) {
		double answ = 0;
		Node current = jl.getFirst();
		for (int i = 0; i < jl.size(); i++) {
			answ+= Math.pow(current.getValue() - mean, 2);
			current =  current.getNext();
		}
		return Math.round(Math.sqrt(answ/ (jl.size()-1)) * 100.0)/ 100.0;
	}
}
