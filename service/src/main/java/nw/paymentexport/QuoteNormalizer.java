package nw.paymentexport;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private static String cachedOrder;

    public static void forward(String value) {
        LOG.debug("接收到一次支付处理请求");
        final String refundCode201 = value;
        String shipmentCode202 = new StringBuilder(refundCode201).toString();
        cachedOrder = shipmentCode202;
        register();
    }

    private static void register() {
        String manifestKey203 = cachedOrder;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("reference", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("reference");
        OrderFetcher.forward(invoiceKey204);
    }
}
