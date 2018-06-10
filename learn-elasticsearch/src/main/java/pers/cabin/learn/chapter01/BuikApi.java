package pers.cabin.learn.chapter01;

import org.elasticsearch.action.bulk.*;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by caiping on 2017/9/1.
 */
public class BuikApi {

    private static Logger logger = LoggerFactory.getLogger(BuikApi.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void test1() throws IOException {

        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

        bulkRequestBuilder.add(transportClient.prepareIndex("hh", "aa", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("hh", "11")
                        .field("hh2", "11")
                        .field("hh3", "11")
                        .endObject()
                )
        );
        bulkRequestBuilder.add(transportClient.prepareIndex("ii", "ii2", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("ii1","1")
                        .field("ii2","1")
                        .field("ii3","1")
                        .endObject()));

        BulkResponse bulkItemResponses = bulkRequestBuilder.get();
    }

    @Test
    public void test2() {
        BulkProcessor bulkProcessor = BulkProcessor.builder(
                transportClient,
                new BulkProcessor.Listener() {
                    @Override
                    public void beforeBulk(long executionId,
                                           BulkRequest request) {
//                        ...
                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          BulkResponse response) {
//                            ...

                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          Throwable failure) {
//                        ...
                    }
                })
                .setBulkActions(10000)
                .setBulkSize(new ByteSizeValue(5, ByteSizeUnit.MB))
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                .setConcurrentRequests(1)
                .setBackoffPolicy(
                        BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
                .build();

    }
}
