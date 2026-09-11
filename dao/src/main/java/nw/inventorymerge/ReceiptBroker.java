package nw.inventorymerge;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 库存明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventorymergeReceiptBroker")
public class ReceiptBroker {
    private final OrderRepository orderRepository;

    public ReceiptBroker(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void forward(String value) {
        List<String> orderRef501Attrs = new ArrayList<String>();
        orderRef501Attrs.add("web");
        orderRef501Attrs.add(value);
        String orderRef501 = orderRef501Attrs.get(1);
        String quoteRef502 = "ref_".concat(orderRef501);
        this.orderRepository.normalize(quoteRef502);
    }
}
