package nw.shippinggrant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面向发运场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteResolver {
    private static String cachedAccount;

    public static void enrich(String value) {
        String voucherRef101 = String.valueOf(value);
        String paymentTag102 = voucherRef101;
        cachedAccount = paymentTag102;
        resolve();
    }

    private static void resolve() {
        String refundCode103 = cachedAccount;
        List<String> shipmentCode104Attrs = new ArrayList<String>();
        shipmentCode104Attrs.add("web");
        shipmentCode104Attrs.add(refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get(1);
        Map<String, String> manifestKey105Attrs = new HashMap<String, String>();
        manifestKey105Attrs.put("channel", "web");
        manifestKey105Attrs.put("detail", shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get("detail");
        InvoiceComposer.resolve(manifestKey105);
    }
}
