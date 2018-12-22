package pers.cabin.java.func;

/**
 * 函数式接口
 *
 * @param <T>
 */
@FunctionalInterface
public interface Content<T> {
    String think(T content);
}
