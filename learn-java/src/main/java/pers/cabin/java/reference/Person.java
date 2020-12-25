package pers.cabin.java.reference;

public class Person {

    private String name;
    private String desc;
    private Integer age;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                '}';
    }
}
