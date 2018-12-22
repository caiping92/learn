package pers.cabin.java.base.orientedObject;

/**
 * 传入的参数错误。
 * 注意：可已解决的 用 Exception
 * 不处理的异常 RuntimeException
 * <p>
 * Created by cc on 2016/11/3.
 */
public class NoValueException extends RuntimeException {
    public NoValueException() {
        super();
    }

    public NoValueException(String message) {
        super(message);
    }
}
