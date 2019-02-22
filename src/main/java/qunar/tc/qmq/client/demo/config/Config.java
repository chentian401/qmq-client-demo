package qunar.tc.qmq.client.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import qunar.tc.qmq.MessageProducer;
import qunar.tc.qmq.consumer.annotation.EnableQmq;
import qunar.tc.qmq.producer.MessageProducerProvider;

import java.util.concurrent.Executor;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author niejinping
 */
@Configuration
@EnableQmq(appCode="${appCode}", metaServer="${metaServer}")
public class Config {
    @Bean
    public MessageProducer producer(@Value("${appCode}") String appCode, @Value("${metaServer}") String metaServer){
        final MessageProducerProvider producer = new MessageProducerProvider();
        producer.setAppCode(appCode);
        producer.setMetaServer(metaServer);
        return producer;
    }

    @Bean
    public Executor executor(){
        return newFixedThreadPool(1);
    }
}
