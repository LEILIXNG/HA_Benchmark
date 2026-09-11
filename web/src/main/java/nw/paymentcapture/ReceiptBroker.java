package nw.paymentcapture;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentcaptureReceiptBroker")
public class ReceiptBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBroker.class);
    private static String cachedBundle;
    private final OrderRouter orderRouter;

    public ReceiptBroker(OrderRouter orderRouter) {
        this.orderRouter = orderRouter;
    }

    public void translate(String value) {
        LOG.debug("支付流程转下一环节");
        String refundCode1 = value;
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("remark", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("remark");
        cachedBundle = shipmentCode2;
        merge();
    }

    private void merge() {
        String manifestKey3 = cachedBundle;
        String invoiceKey4 = new StringBuilder(manifestKey3).toString();
        cachedBundle = invoiceKey4;
        prepare();
    }

    private void prepare() {
        String batchTag5 = cachedBundle;
        String orderRef6 = "ref_" + batchTag5;
        final String quoteRef7 = orderRef6;
        cachedBundle = quoteRef7;
        submit();
    }

    private void submit() {
        String tariffRef8 = cachedBundle;
        Map<String, String> ledgerEntry9Attrs = new HashMap<String, String>();
        ledgerEntry9Attrs.put("channel", "web");
        ledgerEntry9Attrs.put("detail", tariffRef8);
        String ledgerEntry9 = ledgerEntry9Attrs.get("detail");
        this.orderRouter.assemble(ledgerEntry9);
    }
}
