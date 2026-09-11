package nw.fulfilarchive;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogCollector {

    public static void collect(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("detail", value);
        String paymentTag301 = paymentTag301Attrs.get("detail");
        final String refundCode302 = paymentTag301;
        ManifestNormalizer.publish(refundCode302);
    }
}
