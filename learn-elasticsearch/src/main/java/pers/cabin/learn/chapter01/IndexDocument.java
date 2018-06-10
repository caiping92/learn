package pers.cabin.learn.chapter01;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.rest.RestStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

import java.io.IOException;
import java.util.Date;

/**
 * Created by caiping on 2017/9/1.
 */
public class IndexDocument {
    private static Logger logger = LoggerFactory.getLogger(IndexDocument.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void index() throws IOException {
        String index = "twitter";
        String type = "tweet";
        String id = "1";

        IndexResponse indexResponse = transportClient.prepareIndex(index, type, id)
                .setSource(
                        XContentFactory.jsonBuilder()
                                .startObject()
                                .field("user", "cabin")
                                .field("postDate", new Date())
                                .field("messgae", "trying elasticsearch")
                                .endObject(),
                        XContentFactory.jsonBuilder()
                            .startObject()
                                .field("user","text")
                                .field("postDate","timestamp")
                                .field("messgae","text")
                            .endObject()
                )
                .get();

        String _index = indexResponse.getIndex();
        String _type = indexResponse.getType();
        String _id = indexResponse.getId();
        long _version = indexResponse.getVersion();

        RestStatus status = indexResponse.status();

        logger.info("_index is {}", _index);
        logger.info("_type is {}", _type);
        logger.info("_id is {}", _id);
        logger.info("_version is {}", _version);

    }

    @Test
    public void index_2() {

        String json = "{" +
                "\"user\":\"hh\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        IndexResponse response = transportClient.prepareIndex("meta", "log")
                .setSource(json)
                .get();
// Index name
        String _index = response.getIndex();
// Type name
        String _type = response.getType();
// Document ID (generated or not)
        String _id = response.getId();
// Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
// status has stored current instance statement.
        RestStatus status = response.status();

    }

}
