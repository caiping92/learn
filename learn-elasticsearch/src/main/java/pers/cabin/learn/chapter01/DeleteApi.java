package pers.cabin.learn.chapter01;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

/**
 * Created by caiping on 2017/9/1.
 */
public class DeleteApi {

    private static Logger logger = LoggerFactory.getLogger(DeleteApi.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void test() {

        DeleteResponse response = transportClient.prepareDelete("twitter", "tweet", "1")
                .get();

        String _id = response.getId();
        DocWriteResponse.Result result = response.getResult();
        logger.info(result.name());

    }

    @Test
    public void test2() {
        BulkByScrollResponse response =
                DeleteByQueryAction.INSTANCE.newRequestBuilder(transportClient)
                        .filter(QueryBuilders.matchQuery("gender", "male")) //查询
                        .source("persons")  //索引
                        .get();     //执行
        //删除的个数
        long deleted = response.getDeleted();

        logger.info("已经删除 {} 个",deleted);
    }

    @Test
    public void test3() {
        DeleteByQueryAction.INSTANCE.newRequestBuilder(transportClient)
                .filter(QueryBuilders.matchQuery("gender", "male")) //query
                .source("persons")  //index
                .execute(new ActionListener<BulkByScrollResponse>() {   //listener
                    @Override
                    public void onResponse(BulkByScrollResponse response) {
                        long deleted = response.getDeleted();   //number of deleted
                    }
                    @Override
                    public void onFailure(Exception e) {
                        // Handle the exception
                        logger.info(">>>>>>----------");
                    }
                });
    }

}
