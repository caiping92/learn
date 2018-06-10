package pers.cabin.jichu.a2_io.other;

import pers.cabin.jichu.a2_io.collection.entity.Person;
import org.junit.Test;

import java.io.*;

/**
 * Created by cc on 2016/11/14.
 */
public class Test4 {

    @Test
    public void test() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\temp\\person.object")));
            oos.writeObject(new Person("caiping", 24));
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\temp\\person.object")));
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
