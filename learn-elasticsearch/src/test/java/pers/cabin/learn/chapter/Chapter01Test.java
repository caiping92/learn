package pers.cabin.learn.chapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import pers.cabin.learn.ESClient;
import pers.cabin.learn.chapter01.JsonConstruct;

import java.io.IOException;

/**
 * Created by caiping on 2017/9/1.
 */
public class Chapter01Test {

    private ESClient client;
    private JsonConstruct jsonConstruct;

    @Before
    public void setUp() {
        client = new ESClient();
        jsonConstruct = new JsonConstruct();
    }

    @Test
    public void Test1() {
     client.clusterStatus();
    }

    @Test
    public void test2_json() throws JsonProcessingException {
        jsonConstruct.jsonConstruct2();
    }
    @Test
    public void test3_json_XFactory() throws IOException {
        jsonConstruct.jsonConstruct3();
    }
}

