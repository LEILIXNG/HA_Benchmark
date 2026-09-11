package nw.orderhold;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderholdInvoiceCollector")
public class InvoiceCollector {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceCollector.class);
    private String pendingBundle;
    private final ShipmentService shipmentService;

    public InvoiceCollector(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public void collect(String value) {
        LOG.debug("接收到一次订单处理请求");
        this.route(value);
    }

    private void route(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.get("detail");
        String catalogKey102 = new StringBuilder(channelTag101).toString();
        this.pendingBundle = catalogKey102;
        compose();
    }

    private void compose() {
        String receiptKey103 = this.pendingBundle;
        String accountRef104 = "ref_" + receiptKey103;
        this.shipmentService.route(accountRef104);
    }
}
