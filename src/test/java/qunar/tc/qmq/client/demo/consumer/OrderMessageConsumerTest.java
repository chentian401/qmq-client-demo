package qunar.tc.qmq.client.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.MessageProducer;
import qunar.tc.qmq.client.demo.Startup;
import qunar.tc.qmq.client.demo.model.Order;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
@Slf4j
public class OrderMessageConsumerTest {
    @Resource
    private MessageProducer producer;

    @Test
    public void placeOrder() throws InterruptedException {
        Order order = Order.builder()
                .uid(61L)
                .orderTime(System.currentTimeMillis()).build();
        Message message = producer.generateMessage("order.created");
        message.setProperty("orderTime", order.getOrderTime());
        message.setProperty("uid", order.getUid());
        //message.setDelayTime(60, TimeUnit.SECONDS);
        producer.sendMessage(message);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await(1000L, TimeUnit.SECONDS);
    }
}