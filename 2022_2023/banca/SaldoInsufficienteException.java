public class SaldoInsufficienteException extends Exception {

    public SaldoInsufficienteException() {
        super();
    }

    public SaldoInsufficienteException(String message) {
        super(message);
    }

    public SaldoInsufficienteException(Throwable cause) {
        super(cause);
    }

    public SaldoInsufficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
