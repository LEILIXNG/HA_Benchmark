package nw.orderintake;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("orderintakePaymentBuilder")
public class PaymentBuilder {
    private String pendingOrder;
    private final OrderRepository orderRepository;

    public PaymentBuilder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void enrich(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String accountRef401 = value;
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("remark", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("remark");
        this.pendingOrder = voucherRef402;
        collect();
    }

    private void collect() {
        String paymentTag403 = this.pendingOrder;
        Map<String, String> refundCode404Attrs = new LinkedHashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("reference", paymentTag403);
        String refundCode404 = refundCode404Attrs.getOrDefault("reference", "");
        final String shipmentCode405 = refundCode404;
        this.orderRepository.collect(shipmentCode405);
    }
}
