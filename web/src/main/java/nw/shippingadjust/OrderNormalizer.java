package nw.shippingadjust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingadjustOrderNormalizer")
public class OrderNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderNormalizer.class);
    private String pendingContract;
    private static String cachedContract;
    private final BatchService batchService;

    public OrderNormalizer(BatchService batchService) {
        this.batchService = batchService;
    }

    public void normalize(String value) {
        LOG.debug("发运流程转下一环节");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String voucherRef1 = String.valueOf(value);
        cachedContract = voucherRef1;
        publish();
    }

    private void publish() {
        String paymentTag2 = cachedContract;
        String refundCode3 = String.valueOf(paymentTag2);
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("reference", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("reference");
        this.pendingContract = shipmentCode4;
        register();
    }

    private void register() {
        String manifestKey5 = this.pendingContract;
        List<String> invoiceKey6Attrs = new ArrayList<String>();
        invoiceKey6Attrs.add("web");
        invoiceKey6Attrs.add(manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get(1);
        cachedContract = invoiceKey6;
        resolve();
    }

    private void resolve() {
        String batchTag7 = cachedContract;
        Map<String, String> orderRef8Attrs = new LinkedHashMap<String, String>();
        orderRef8Attrs.put("channel", "web");
        orderRef8Attrs.put("reference", batchTag7);
        String orderRef8 = orderRef8Attrs.getOrDefault("reference", "");
        this.batchService.register(orderRef8);
    }
}
