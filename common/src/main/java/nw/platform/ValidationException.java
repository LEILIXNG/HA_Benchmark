package nw.platform;

/** 入参不满足约束。调用方应当把它转成 4xx 而不是重试。 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(message);
    }
}
