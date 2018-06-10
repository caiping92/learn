package pers.caiping.learn.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

/**
 * @author caiping
 * @create 2018/2/6 10:23
 * @Description
 *
 *      Read, write JSON, from File, into File, as text, byte[], convert to Map
        Read JSON as JsonNode, use JsonPointer
        Write XML
        Read Avro, convert to Map

 参考：
    https://github.com/FasterXML/jackson-databind/
    http://blog.csdn.net/tobetheender/article/details/52767812


 */
@Log4j2
public class JacksonDemo {


    public static void main(String[] args){

        test1();



    }

    private static void test1() {
        ObjectMapper objectMapper = new ObjectMapper();

        Student student = new Student();
        student.setAge(11);
        student.setName("haha");
        student.setNickName("mim");
        student.setSex("male");
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {

        }
        log.info(jsonStr);
    }


    public static void test2() {

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode objectNode = objectMapper.createObjectNode();

        try {
            JsonNode root = objectMapper.readTree("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        JsonGenerator generator = null;
        try {
            generator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
        }

//        generator.flush();


    }

    public static void test3() {
        JsonFactory jsonFactory = new JsonFactory();
    }
}
