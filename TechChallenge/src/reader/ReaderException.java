package reader;

/**
 * Exception thrown whenever there is an error in the reading of a ticket.
 * @author Andrea Olcina
 *
 */
public class ReaderException extends Exception {
	/**
	 * Constructor.
	 * @param msg
	 */
    public ReaderException(String msg) {
        super("Ha habido un error en el procesamiento del ticket.");
    }
}
