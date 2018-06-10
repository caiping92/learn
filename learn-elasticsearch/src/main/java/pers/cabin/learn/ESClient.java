package pers.cabin.learn;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by caiping on 2017/9/1.
 */
public class ESClient {

    private static Logger logger = LoggerFactory.getLogger(ESClient.class);

//    private static final String host = "127.0.0.1";
    private static final String host = "localhost";
    private static final Integer port = 9300;
    private static TransportClient transportClient;

    public ESClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", true)
                .build();

        try {
            transportClient= new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static TransportClient getTransportClient() {
        if (transportClient == null) {
           new ESClient();
        }
        return transportClient;
    }



    /**
     * 查看集群装台
     */
    public static void clusterStatus() {
        ClusterAdminClient cluster = transportClient.admin().cluster();

        ClusterHealthResponse clusterHealthResponse = cluster.prepareHealth().get();

        String clusterName = clusterHealthResponse.getClusterName();
        int numberOfDataNodes = clusterHealthResponse.getNumberOfDataNodes();
        ClusterHealthStatus status = clusterHealthResponse.getStatus();

        logger.info("集群状态：clusterHealthResponse {}",clusterHealthResponse);
        logger.info(">>>>clusterName is {}",clusterName);
        logger.info(">>>> numberOfDataNodes is {} ",numberOfDataNodes);
        logger.info(">>> status is {}  ",status);

    }



}
