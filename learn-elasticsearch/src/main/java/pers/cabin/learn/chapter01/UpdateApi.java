package pers.cabin.learn.chapter01;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by caiping on 2017/9/1.
 */
public class UpdateApi {

    private static Logger logger = LoggerFactory.getLogger(UpdateApi.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void test1() throws IOException, ExecutionException, InterruptedException {

        UpdateRequest updateRequest = new UpdateRequest();

        updateRequest.index("es_test");
        updateRequest.type("person");
        updateRequest.id("1");

        updateRequest.doc(jsonBuilder()
                .startObject()
                .field("gender", "male")
                .endObject()
        );

        UpdateResponse updateResponse = transportClient.update(updateRequest).get();

        logger.info("updateResponse is {}", updateRequest);
        logger.info(" result is {} ", updateResponse.getGetResult());
    }

    @Test
    public void test2() {
        UpdateResponse updateResponse = transportClient.prepareUpdate()
                .setIndex("tt")
                .setType("hah")
                .setId("1")
//                .setScript(new Script("ctx._source.gender = \\\"male\\"), ScriptService.ScriptType.INLINE, null, null)
                .get();

    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        UpdateRequest updateRequest = new UpdateRequest("tt", "hh", "1");
        UpdateResponse updateResponse = transportClient.update(updateRequest).get();

        logger.info("the response is {}", updateRequest);
    }

    @Test
    public void test4() throws IOException, ExecutionException, InterruptedException {

        UpdateRequest updateRequest = new UpdateRequest("hh", "mm", "1")
                .doc(jsonBuilder()
                        .startObject()
                        .field("gender", "male")
                        .field("hh", "eee")
                        .endObject()
                );

        UpdateResponse updateResponse = transportClient.update(updateRequest).get();

        logger.info("update response is {}", updateRequest);
    }

    //upsert ，if the document does not exist ,the content of the upsert element will be used to index the fresh doc
    @Test
    public void test5() throws IOException, ExecutionException, InterruptedException {
        IndexRequest indexRequest = new IndexRequest("_idnex_hh", "pp", "1")
                .source(jsonBuilder()
                        .startObject()
                        .field("name", "haha")
                        .field("age", "25")
                        .endObject()
                );

        UpdateResponse updateResponse = transportClient.prepareUpdate("tt", "pp", "1")
                .setDoc(jsonBuilder()
                        .startObject()
                        .field("gender", "mail")
                        .endObject())
                .setUpsert(indexRequest)
                .get();
        logger.info("updateResponse is {}", updateResponse.toString());

    }

}
