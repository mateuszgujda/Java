package appl;

import excp.BadInputException;
import excp.NothingToSubstractFromException;
import excp.TooBigNumberException;

import java.io.IOException;

/**
 * Created by student on 2018-11-06.
 */
public abstract class Calculator {
    public abstract void SaveToFile(String x, String filename) throws IOException;

    public abstract String Add(String x);

    public abstract String Substract(String x) throws NothingToSubstractFromException , BadInputException;

    public abstract String Multiply(int x) throws TooBigNumberException;
}
