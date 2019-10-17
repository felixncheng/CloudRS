package io.github.chengmboy.cloudrs.common.exception;

/**
 * 403 授权拒绝
 */
public class CloudrsDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CloudrsDeniedException() {
    }

    public CloudrsDeniedException(String message) {
        super(message);
    }

    public CloudrsDeniedException(Throwable cause) {
        super(cause);
    }

    public CloudrsDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloudrsDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
