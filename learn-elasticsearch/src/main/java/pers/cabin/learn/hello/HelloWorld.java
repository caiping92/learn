package pers.cabin.learn.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * elsticsearch 默认cluster.name 为： elasticsearch
 * Created by caiping on 2017/8/31.
 */
public class HelloWorld {

    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    private final String host = "localhost";
    private final Integer port = 9300;

    private static TransportClient transportClient;

    public HelloWorld() throws UnknownHostException {



//        方式1
//        transportClient = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//方式二

        Settings settings = Settings.builder()
                .put("cluster.name", "client.transport.sniff")
                .put("client.transport.sniff", true)
                .build();
        transportClient = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
    }

    public void test1() {

        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

    }

    public void test2() throws JsonProcessingException {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");

        //        Serialize your beans
        ObjectMapper mapper = new ObjectMapper();

//        生成 json
        byte[] bytes = mapper.writeValueAsBytes(json);
        logger.info("bean 转换成 byte 数据为： {}" ,bytes);

        String string = mapper.writeValueAsString(json);
        logger.info("bean 转换成 string , {}" ,string);
    }
}
