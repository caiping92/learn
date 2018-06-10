package pers.cabin.learn.chapter01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiping on 2017/9/1.
 */
public class JsonConstruct {
    private static Logger logger = LoggerFactory.getLogger(JsonConstruct.class);

    public  void jsonConstruct() {
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
    }

    public void jsonConstruct2() throws JsonProcessingException {
        Map<String, Object> jsonBean = new HashMap<String, Object>();
        jsonBean.put("user","kimchy");
        jsonBean.put("postDate",new Date());
        jsonBean.put("message","trying out Elasticsearch");

        // instance a json mapper
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        // generate json
        byte[] asBytes = mapper.writeValueAsBytes(jsonBean);
        String asString = mapper.writeValueAsString(jsonBean);
        logger.info("使用 jackson 转换json byte： {}",asBytes);
        logger.info("使用 jackson 转换json String： {}",asString);
    }

    public void jsonConstruct3() throws IOException {

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();
        String xmlJosn = builder.string();

        logger.info("使用XContentFactory builder 构造 json is {}", xmlJosn);
    }
}
