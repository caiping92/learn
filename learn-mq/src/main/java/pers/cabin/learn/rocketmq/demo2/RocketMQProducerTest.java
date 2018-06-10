package pers.cabin.learn.rocketmq.demo2;

import com.alibaba.rocketmq.common.message.Message;

/**
 * Created by caiping on 2018/1/7.
 */
public class RocketMQProducerTest {
    public static void main(String[] args) {

        String mqNameServer = "172.10.254.2:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();


        for (int i = 0; i < 5; i++) {

            Message message = new Message();
            message.setBody(("I send message to RocketMQ " + i).getBytes());
            mqProducer.send(message);
        }



    }

}
