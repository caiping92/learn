package pers.cabin.java.func;

public class Metting<T> {
    private Content<T> content;
    private SayHi sayHi;

    public Metting(Content<T> content, SayHi sayHi) {
        this.content = content;
        this.sayHi = sayHi;
    }

    public void doSomthing(T t) {
        sayHi.say(content.think(t));
    }
}
