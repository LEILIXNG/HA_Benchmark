package nw.orderarchive;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderarchiveOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private String pendingOrder;
    private final OrderEvaluator orderEvaluator;

    public OrderService(OrderEvaluator orderEvaluator) {
        this.orderEvaluator = orderEvaluator;
    }

    public void normalize(String value) {
        LOG.trace("进入订单处理环节");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        final String voucherRef501 = value;
        List<String> paymentTag502Attrs = new ArrayList<String>();
        paymentTag502Attrs.add("web");
        paymentTag502Attrs.add(voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get(1);
        this.pendingOrder = paymentTag502;
        compose();
    }

    private void compose() {
        String refundCode503 = this.pendingOrder;
        Map<String, String> shipmentCode504Attrs = new LinkedHashMap<String, String>();
        shipmentCode504Attrs.put("channel", "web");
        shipmentCode504Attrs.put("reference", refundCode503);
        String shipmentCode504 = shipmentCode504Attrs.getOrDefault("reference", "");
        this.orderEvaluator.refine(shipmentCode504);
    }
}
