package nw.fulfilnotice;

import java.util.HashMap;
import java.util.Map;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class InvoiceRegistry {

    public static void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("detail", value);
        String invoiceKey201 = invoiceKey201Attrs.get("detail");
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("remark", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("remark");
        RefundExecutor.compose(batchTag202);
    }
}
