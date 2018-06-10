package pers.caiping.learn.java.functInterface;

/**
 * 函数式接口
 * @param <T>
 */
@FunctionalInterface
public interface Content<T> {
    String think(T content);
}
