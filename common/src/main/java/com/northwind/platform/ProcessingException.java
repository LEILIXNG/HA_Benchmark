package com.northwind.platform;

/** 处理链路里的不可恢复错误，统一转成 5xx。 */
public class ProcessingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProcessingException(String message) {
        super(message);
    }

    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
