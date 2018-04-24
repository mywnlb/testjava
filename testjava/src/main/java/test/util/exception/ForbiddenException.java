package test.util.exception;

/**
 * Created by lb on 2018/3/21.
 */
public class ForbiddenException extends RuntimeException {
    /**
     *  自定义异常
     */
    private String message;

    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ForbiddenException{" +
                "message='" + message + '\'' +
                '}';
    }
}
