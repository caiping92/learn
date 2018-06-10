package pers.cabin.learn.chapter01;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

import java.util.Map;

/**
 * Created by caiping on 2017/9/1.
 */
public class GetApi {

    private static Logger logger = LoggerFactory.getLogger(GetApi.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void test1() {

        GetResponse response = transportClient.prepareGet("twitter", "tweet", "1")
                .setOperationThreaded(false)
                .get();

        Map<String, Object> source = response.getSource();

        logger.info("_source is {}", response);
    }

    @Test
    public void test2() {

        MultiGetResponse multiGetItemResponses = transportClient.prepareMultiGet()
                .add("twitter", "tweet", "1")   //根据 单个id 查询
                .add("twitter", "tweet", "2", "3", "4") //根据 多个id查询
                .add("hh", "type_aaa", "1")     //根据其他index 查询
                .get();

        for (MultiGetItemResponse multiGetItemResponse :multiGetItemResponses){
            GetResponse response = multiGetItemResponse.getResponse();
            if (response!=null && response.isExists()) {
                String sourceAsString = response.getSourceAsString();
                logger.info("multiGetItemResponse: this sources is {}",sourceAsString);
            }
        }

    }

}
