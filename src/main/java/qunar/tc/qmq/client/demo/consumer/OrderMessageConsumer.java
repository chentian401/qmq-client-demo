package qunar.tc.qmq.client.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.consumer.annotation.QmqConsumer;

/**
 * @author niejinping
 */
@Service
@Slf4j
public class OrderMessageConsumer {
    /**
     * @param message
     */
    @QmqConsumer(subject = "order.created",consumerGroup = "ordercenter",executor = "executor")
    public void onMessage(Message message){
        Long uid = message.getLongProperty("uid");
        log.info("receive message uid{}",uid);
    }
}
