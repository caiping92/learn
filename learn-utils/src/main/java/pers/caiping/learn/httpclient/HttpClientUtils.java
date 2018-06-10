package pers.caiping.learn.httpclient;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import pers.caiping.learn.exception.RequestCodeErrorException;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author caiping
 * @create 2018/1/12 16:26
 * @Description HttpClient 工具类
 *
 * 参考：
 *  http://blog.csdn.net/zhuwukai/article/details/78644484
 *  https://www.cnblogs.com/ITtangtang/p/3968093.html
 */
@Log4j2
public class HttpClientUtils {


    /**
     * HTTP 请求方法
     */
    public enum RequestMethod {
        POST,
        GET,
        DELETE,
        PUT,
        ;

        RequestMethod() {
        }
    }

    /**
     * HttpClient通用请求方法
     * @param requestMethod 请求参数类型
     * @param contentType 请求头类型
     * @param charset 编码
     * @return HttpResponse
     */
    public static HttpResponse requestMapping(RequestMethod requestMethod, String contentType, String charset) {
        //TODO
        return null;
    }




    /**
     *  Post 登录
     *  请求参数
     *  请求返回均为 application/json
     *
     * @param fullUrl 全路径
     * @param jsonParam 请求参数 如果无 则传入null
     * @return JSONObject
     */
    public static JSONObject postRequestForJson(String fullUrl, JSONObject jsonParam) throws RequestCodeErrorException, IOException {
        Integer httpClientTimeout =40000;

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();

        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(fullUrl);
        log.info("application.properties 中server.http-client-timeout值为：{}",httpClientTimeout);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(httpClientTimeout)
                .setSocketTimeout(httpClientTimeout)
                .build();
        method.setConfig(requestConfig);
        StringEntity entity = null;
        if (null != jsonParam) {
            //解决中文乱码问题
            entity = new StringEntity(jsonParam.toString(), "UTF-8");
        } else {
            entity = new StringEntity(new JSONObject().toString(),"UTF-8");
        }
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        method.setEntity(entity);
        HttpResponse result = null;
        try {
            result = httpclient.execute(method);
        } catch (HttpHostConnectException e) {
            log.error("请求时间超过{}",httpClientTimeout);
            close(httpclient);
            throw new IOException(e);
        } catch (IOException e) {
            log.error("请求执行出错：{}", e.getMessage());
            close(httpclient);
            throw new IOException(e);
        }

        fullUrl = URLDecoder.decode(fullUrl, "UTF-8");
        /**请求发送成功，并得到响应**/
        if (result.getStatusLine().getStatusCode() == 200) {
            String str = "";
            try {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                /**把json字符串转换成json对象**/
                try {
                    jsonResult = JSONObject.parseObject(str);
                } catch (JSONException e) {
                    log.error("{}的返回值：{} ，不是json",fullUrl, str);
                }
            } catch (Exception e) {
                log.error("post请求提交失败:" + fullUrl, e);
                close(httpclient);
                return jsonResult;
            }
        } else {
            //发送失败 状态码不为200
            close(httpclient);
            throw new RequestCodeErrorException();
        }
        close(httpclient);
        return jsonResult;
    }

    /**
     *  Post 登录
     *  请求参数
     *  请求返回均为 application/json
     *
     * @param fullUrl 全路径
     * @param jsonParam 请求参数 如果无 则传入null
     * @param  accessCode
     * @return JSONObject
     *
     */
    public static JSONObject postRequestForJson(String fullUrl, JSONObject jsonParam, String accessCode) throws RequestCodeErrorException, IOException {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        Integer httpClientTimeout = 4000;
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(fullUrl);

        log.info("application.properties 中server.http-client-timeout值为：{}",httpClientTimeout);
        if (null == httpClientTimeout) {
        }
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(httpClientTimeout)
                .setSocketTimeout(httpClientTimeout)
                .build();
        method.setConfig(requestConfig);
        method.setHeader("Authorization",accessCode);//设置头部
        StringEntity entity = null;
        if (null != jsonParam) {
            //解决中文乱码问题
            log.info(jsonParam.toString());
            entity = new StringEntity(jsonParam.toString(), "UTF-8");
        } else {
            entity = new StringEntity(new JSONObject().toString(),"UTF-8");
        }
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        method.setEntity(entity);
        HttpResponse result = null;
        try {
            result = httpclient.execute(method);
        } catch (HttpHostConnectException e) {
            log.error("请求时间超过{}",httpClientTimeout);
            close(httpclient);
            throw new IOException(e);
        } catch (IOException e) {
            log.error("请求执行出错：{}", e.getMessage());
            close(httpclient);
            throw new IOException(e);
        }
        fullUrl = URLDecoder.decode(fullUrl, "UTF-8");
        /**请求发送成功，并得到响应**/
        if (result.getStatusLine().getStatusCode() == 200) {
            String str = "";
            try {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.parseObject(str);
            } catch (Exception e) {
                log.error("post请求提交失败:" + fullUrl, e);
            }
        } else {
            close(httpclient);
            //发送失败
            throw new RequestCodeErrorException();
        }
        close(httpclient);
        return jsonResult;
    }

    public static void close(CloseableHttpClient httpClient) {
        if (null != httpClient) {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error("httpClient 关闭异常",e.getMessage());
            }

        }
    }
}
