/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class CPFException extends Exception {
    public CPFException(String message) {
        super(message);
    }

    public CPFException() {
        super("CPF inválido.");
    }
}