package nw.catalogadjust;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("catalogadjustPaymentAdapter")
public class PaymentAdapter {
    private final ReceiptCollector receiptCollector;

    public PaymentAdapter(ReceiptCollector receiptCollector) {
        this.receiptCollector = receiptCollector;
    }

    public void normalize(String value) {
        Map<String, String> batchTag1Attrs = new LinkedHashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.getOrDefault("detail", "");
        Map<String, String> orderRef2Attrs = new LinkedHashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("remark", batchTag1);
        String orderRef2 = orderRef2Attrs.getOrDefault("remark", "");
        this.receiptCollector.assemble(orderRef2);
    }
}
