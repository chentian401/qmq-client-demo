package qunar.tc.qmq.client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niejinping
 */
@SpringBootApplication(scanBasePackages = {"qunar.tc.qmq.client.demo"})
public class Startup {
    public static void main(String[] args) {
        SpringApplication.run(Startup.class);
    }

}
