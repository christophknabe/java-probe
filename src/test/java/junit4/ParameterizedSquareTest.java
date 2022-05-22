package junit4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParameterizedSquareTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {                
                 { 0, 0 }, { 1, 1 }, { 2, 4 }, { 3, 9 }, { 4, 16 }, { 5, 25 },{ 6, 36 }  
        });
    }

    private final int _input;
    private final int _expected;
    
    public ParameterizedSquareTest(final  int input, final int expected){
    	_input = input;   _expected = expected;
    }

    @Test
    public void testSquare() {
        assertEquals(_expected, _input*_input);
    }
}
