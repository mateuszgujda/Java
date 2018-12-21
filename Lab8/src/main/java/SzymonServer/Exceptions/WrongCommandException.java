
package SzymonServer.Exceptions;

public class WrongCommandException extends Throwable {
    public WrongCommandException(String message) {
        super(message);
    }
}