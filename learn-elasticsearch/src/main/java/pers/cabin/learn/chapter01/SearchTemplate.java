package pers.cabin.learn.chapter01;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequestBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.learn.ESClient;

import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by caiping on 2017/9/1.
 */
public class SearchTemplate {
    private static Logger logger = LoggerFactory.getLogger(SearchApi.class);
    private TransportClient transportClient = ESClient.getTransportClient();

    @Test
    public void test1() {
        Map<String, Object> template_params = new HashMap<>();
        template_params.put("param_gender", "male");

        SearchResponse sr = new SearchTemplateRequestBuilder(transportClient)
                .setScript("template_gender")
//                .setScriptType(ScriptService.ScriptType.FILE)
                .setScriptType(ScriptType.FILE)
                .setScriptParams(template_params)
                .setRequest(new SearchRequest())
                .get()
                .getResponse();

    }

    @Test
    public void test2() {
//        SearchResponse sr = node.client().prepareSearch()
//                .setQuery( /* your query */ )
//                .addAggregation( /* add an aggregation */ )
//                .execute().actionGet();

        MatchQueryBuilder matchQueryBuilder = matchQuery("name", "asdf");

        QueryBuilder qb = nestedQuery(
                "obj1",
                boolQuery()
                        .must(matchQuery("obj1.name", "blue"))
                        .must(rangeQuery("obj1.count").gt(5)),
                ScoreMode.Avg
        );
    }
}
