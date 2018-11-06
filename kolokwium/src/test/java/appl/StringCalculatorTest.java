package appl;

import excp.BadInputException;
import excp.NothingToSubstractFromException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 2018-11-06.
 */
public class StringCalculatorTest {
    StringCalculator calculator;

    @Before
    public void createCalc(){
        calculator = new StringCalculator();
    }

    @Test
    public void testAdd() {
        assertEquals("Result should be afff",calculator.Add("afff"),"afff");
    }

    @Test
    public void testMultiply() throws Exception {
        StringCalculator calc = new StringCalculator("a");
        assertEquals("Result should be aaa",calc.Multiply(3),"aaa");
    }

    @Test(expected = excp.NothingToSubstractFromException.class)
    public void TestNothingToSubstractFromException() throws BadInputException, NothingToSubstractFromException {
        calculator.Substract("asf");
    }
}