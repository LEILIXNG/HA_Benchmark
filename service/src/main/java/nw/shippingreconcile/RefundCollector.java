package nw.shippingreconcile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingreconcileRefundCollector")
public class RefundCollector {
    private static String cachedPayment;
    private final PaymentAssembler paymentAssembler;

    public RefundCollector(PaymentAssembler paymentAssembler) {
        this.paymentAssembler = paymentAssembler;
    }

    public void reconcile(String value) {
        String tariffRef101 = String.valueOf(value);
        cachedPayment = tariffRef101;
        prepare();
    }

    private void prepare() {
        String ledgerEntry102 = cachedPayment;
        Map<String, String> channelTag103Attrs = new HashMap<String, String>();
        channelTag103Attrs.put("channel", "web");
        channelTag103Attrs.put("note", ledgerEntry102);
        String channelTag103 = channelTag103Attrs.get("note");
        List<String> catalogKey104Attrs = new ArrayList<String>();
        catalogKey104Attrs.add("web");
        catalogKey104Attrs.add(channelTag103);
        String catalogKey104 = catalogKey104Attrs.get(1);
        this.paymentAssembler.submit(catalogKey104);
    }
}
