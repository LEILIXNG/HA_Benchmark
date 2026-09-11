package nw.fulfillookup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class PaymentTranslator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void refine(String value) {
        PaymentTranslator self = new PaymentTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("detail", value);
        String voucherRef101 = voucherRef101Attrs.get("detail");
        final String paymentTag102 = voucherRef101;
        cachedPayment = paymentTag102;
        forward();
    }

    private void forward() {
        String refundCode103 = cachedPayment;
        Map<String, String> shipmentCode104Attrs = new LinkedHashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("reference", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.getOrDefault("reference", "");
        this.pendingPayment = shipmentCode104;
        enrich();
    }

    private void enrich() {
        String manifestKey105 = this.pendingPayment;
        String invoiceKey106 = manifestKey105;
        Map<String, String> batchTag107Attrs = new LinkedHashMap<String, String>();
        batchTag107Attrs.put("channel", "web");
        batchTag107Attrs.put("note", invoiceKey106);
        String batchTag107 = batchTag107Attrs.getOrDefault("note", "");
        OrderStrategySelector.collect(batchTag107);
    }
}
