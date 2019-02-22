package qunar.tc.qmq.client.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author niejinping
 */
@Data
@ToString
@Builder
public class Order implements Serializable{
    private static final long serialVersionUID = 7184269832342221953L;
    private Long orderId;
    private String orderNo;
    private Long orderTime;
    private Long uid;
    private Long money;
}
