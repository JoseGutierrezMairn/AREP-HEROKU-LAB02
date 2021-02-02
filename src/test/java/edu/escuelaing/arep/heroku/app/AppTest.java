package edu.escuelaing.arep.heroku.app;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.escuelaing.arep.heroku.app.calculator.Reader;
import edu.escuelaing.arep.heroku.app.calculator.Calculator;
import edu.escuelaing.arep.heroku.app.calculator.JoseLinkedList;
import edu.escuelaing.arep.heroku.app.calculator.Node;

/**
 * @author Jose Gutierrez Marin
 */
public class AppTest 
{
   @Test
    public void shouldReadTheTestFile() {
    	Reader r = new Reader();
    	List<List<String>> answ = new ArrayList<List<String>>();
    	List<String> temp = new ArrayList<String>();
    	temp.add("primera");
    	temp.add("linea");
    	answ.add(temp);
    	temp.remove(0);
    	temp.remove(0);
    	temp.add("segunda");
    	temp.add("linea");
    	answ.add(temp);
    	temp.remove(0);
    	temp.remove(0);
    	temp.add("linea");
    	temp.add("tercera");
    	answ.add(temp);
    	temp.remove(0);
    	temp.remove(0);
    	temp.add("fin");
    	temp.add("lineas");
    	answ.add(temp);
    	List<List<String>> data = r.readFile("testFile.txt");
    	
    	int i = 0;
    	for (List<String> row : data) {
    		answ.get(i).get(0).equals(data.get(0));
    		answ.get(i).get(1).equals(data.get(1));
    		i++;
    	}
    	
    }
    
    @Test
    public void shouldAddNodesInJoseLinkedList() {
    	JoseLinkedList jl = new JoseLinkedList();
    	jl.addFirst(new Node(1));
    	jl.addFirst(new Node(2));
    	jl.addFirst(new Node(3));
    	jl.addFirst(new Node(4));
    	jl.addFirst(new Node(5));
    }
    
    @Test
    public void shouldReturnCorrectNodesFromJoseLinkedList() {
    	JoseLinkedList jl = new JoseLinkedList();
    	jl.addFirst(new Node(1));
    	assertTrue(1==jl.getFirst().getValue());
    	jl.addFirst(new Node(2));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(2==jl.getLast().getValue());
    	jl.addFirst(new Node(3));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(3==jl.getLast().getValue());
    	jl.addFirst(new Node(4));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(4==jl.getLast().getValue());
    	jl.addFirst(new Node(5));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(5==jl.getLast().getValue());
    }
    
    
    @Test
    public void JoseLinkedListShouldBeArranged() {
    	JoseLinkedList jl = new JoseLinkedList();
    	jl.addFirst(new Node(1));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(1==jl.getFirst().getValue());
    	jl.addFirst(new Node(2));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(2==jl.getLast().getValue());
    	assertTrue(null==jl.getLast().getNext());
    	assertTrue(2==jl.getFirst().getNext().getValue());
    	jl.addFirst(new Node(3));
    	assertTrue(1==jl.getFirst().getValue());
    	assertTrue(3==jl.getLast().getValue());
    	assertTrue(null==jl.getLast().getNext());
    	assertTrue(2==jl.getFirst().getNext().getValue());
    
    }
	
	@Test
    public void shouldReturnTheCorrectAnswer() {
		Calculator c = new Calculator();
		Reader r = new Reader();
    	JoseLinkedList jl = new JoseLinkedList();
    	List<List<String>> data = r.readFile("archivo.txt");
		for (int i = 0; i < data.size(); i++){
			jl.addFirst(new Node(Double.parseDouble(data.get(i).get(0))));
		}
		assertTrue(c.calculateMeanOf(jl) == 550.6);
		assertTrue(c.calculateStandardDerivationOf(jl, 550.6) == 572.03 );
		
    }
    

    
}
