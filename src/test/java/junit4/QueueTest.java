package junit4;
//Im SS 13 in Pr1: Aufgabe 9, in WS 08 in IN3: Aufgabe 6

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/** JUnit4-Testtreiber für Klasse Queue. */
@RunWith(Parameterized.class)
public class QueueTest {
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {                
                { QueueImplOK.class },           
                { QueueImplNOK1.class },           
                { QueueImplNOK2.class },           
                { QueueImplNOK3.class }
        });
    }

    private final Class<Queue> _implClass;
    
    public QueueTest(final  Class<Queue> implClass){
    	_implClass = implClass;
    }

    private static final int _SIZE = 10;
    private Queue _queue = null;
    
    @Before
    public void setUp() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
    	_queue = _createQueueImpl();
    }

	private Queue _createQueueImpl() throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		return _implClass.getConstructor(int.class).newInstance(_SIZE);
	}
    
    @After
    public void tearDown(){
    	System.out.println("After: " + _queue);
    }
    
    //Ab hier schreiben Sie bitte Ihre Testmethoden

    private static final String[] _alphabet = {"anton","berta","caesar","dora","emil","friedrich","gustav","heinrich","ida","julius"};
    
    @Test
    public void geradeausBenutzung() throws Queue.Overflow, Queue.Underflow {
        for(final String string: _alphabet){
        	_queue.insert(string);
        }
        try{
        	_queue.insert("kaufmann");
        	fail("Queue.Overflow expected. Queue must have exactly " + _SIZE + " cells.");
        }catch(final Queue.Overflow expected){}
        for(final String expected: _alphabet){
        	final String actual = _queue.read();
        	assertEquals(expected, actual);
        	_queue.delete();
        }
        try{
        	_queue.read();
        	fail("Queue.Underflow expected");
        }catch(final Queue.Underflow expected){}
        try{
        	_queue.delete();
        	fail("Queue.Underflow expected");
        }catch(final Queue.Underflow expected){}
    }

    @Test
    public void readIsInformator() throws Queue.Overflow, Queue.Underflow {
    	for(final String string: _alphabet){
        	_queue.insert(string);
        }
        for(int i=0; i< _alphabet.length; i++){
	    	final String actual = _queue.read();
	    	assertEquals(_alphabet[0], actual);
	    }
    }

    @Test(expected=Queue.Underflow.class)
    public void readUnderflow() throws Queue.Underflow {
        _queue.read();
    }
    @Test(expected=Queue.Underflow.class)
    public void deleteUnderflow() throws Queue.Underflow {
        _queue.delete();
    }

    @Test
    public void gemischtesInsertUndDelete() throws Queue.Overflow, Queue.Underflow {
        for(int i=0; i<_alphabet.length; i+=2){
        	_queue.insert(_alphabet[i]);
        	_queue.insert(_alphabet[i+1]);
        	assertEquals("i="+i, _alphabet[i/2], _queue.read());
        	_queue.delete();
        }
        for(int i=_alphabet.length/2; i<_alphabet.length; i++){
        	assertEquals("i="+i, _alphabet[i], _queue.read());
        	_queue.delete();
        }
    }

    /**Testet das zeitlich verzahnte Benutzen mehrerer Objekte der Klasse Queue.
     * Hierdurch werden insbesondere Fehler aufgedeckt, die durch statische Attribute der Klasse Queue bewirkt werden.
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws InstantiationException */
    @Test
    public void mehrereQueues() throws Queue.Overflow, Queue.Underflow, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    	final Queue[] queues = {
    			_createQueueImpl(),
    			_createQueueImpl(),
    			_createQueueImpl(),
    			_createQueueImpl(),
    			_createQueueImpl()
    	};
    	//Alle Queues parallel befüllen:
    	for(final String string: _alphabet){
        	for(final Queue queue: queues){
        		queue.insert(string);
        	}
    	}
    	//Jede Queue auf Overflow prüfen:
    	for(final Queue queue: queues){
            try{
            	queue.insert("kaufmann");
            	fail("Queue.Overflow expected");
            }catch(final Queue.Overflow expected){}
    	}//for
    	//Jede Queue einzeln leeren und prüfen:
    	for(final Queue queue: queues){
        	for(final String expected: _alphabet){
            	assertEquals(expected, queue.read());
            	queue.delete();
        	}//for
    	}//for
    	//Jede Queue auf Underflow prüfen:
    	for(final Queue queue: queues){
            try{
            	queue.delete();
            	fail("Queue.Underflow expected");
            }catch(final Queue.Underflow expected){}
    	}//for
    }//mehrereQueues


}
