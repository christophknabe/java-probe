package junit4;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class SquareRootTest extends Assert {

    /**Testee: Square Root in type integer (truncates). But typically the testee sits in the src/main/java folder. */
    private int sqrt(int n){
        if(n < 0){
            throw new IllegalArgumentException("Illegal negative argument to sqrt: " + n);
        }
        final Double result = Math.sqrt(n);
        return result.intValue();
    }

    // ======================= Example-based tests ============================

    @Test
    public void sqrtSuccessExample(){
        //GIVEN
        final int n = 100;
        //WHEN
        final int result = sqrt(n);
        //THEN
        assertEquals(10, result);
    }

    @Test
    public void sqrtOfNegativeExample(){
        //GIVEN
        final int n = -1;
        //WHEN-THEN
        assertThrows(IllegalArgumentException.class, () -> sqrt(n));
    }

    // ======================= Property-based test ============================

    @Test
    public void sqrtSuccessProperty(){
        forAllPositiveInt((n) -> {
            //GIVEN
            final long arg = n;
            //WHEN
           final long result = sqrt(n); //integer root is truncated
           //THEN
            if(result*result > arg){
                fail("sqrt(" + arg + ") too big: " + result);
            }
            if((result+1)*(result+1) < arg){
                fail("sqrt(" + arg + ") too small: " + result);
            }
            //assertEquals(arg, result*result);
            return null;
        });
    }

    // Time-consuming: Better use a framework for property-based tests.
    private void forAllPositiveInt(Function<Integer, Void> test){
        for(int i = 0; i<=Integer.MAX_VALUE && i>=0; i++){
            test.apply(i);
        }
    }

}
