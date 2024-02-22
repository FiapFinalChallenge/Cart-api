package cart.domain.exception;

public class CartApiException extends RuntimeException {

    public CartApiException(String message) {
        super(message);
    }
}
