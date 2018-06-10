package pers.cabin.learn.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * Created by caiping on 2017/8/31.
 */
public class HelloWorldTest {
    private HelloWorld hello;
    @Before
    public void setUp() throws UnknownHostException {
        hello = new HelloWorld();
    }

    @Test
    public void test1() {

    }

    @Test
    public void test2() throws JsonProcessingException {

        hello.test2();
    }

}
