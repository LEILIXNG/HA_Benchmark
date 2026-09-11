package nw.fulfilassign;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleBroker {
    private String pendingSession;
    private static String cachedSession;

    public static void register(String value) {
        BundleBroker self = new BundleBroker();
        self.attach(value);
    }

    private void attach(String value) {
        final String receiptKey101 = value;
        cachedSession = receiptKey101;
        stage();
    }

    private void stage() {
        String accountRef102 = cachedSession;
        final String voucherRef103 = accountRef102;
        this.pendingSession = voucherRef103;
        route();
    }

    private void route() {
        String paymentTag104 = this.pendingSession;
        String refundCode105 = paymentTag104;
        this.pendingSession = refundCode105;
        expand();
    }

    private void expand() {
        String shipmentCode106 = this.pendingSession;
        String manifestKey107 = shipmentCode106;
        cachedSession = manifestKey107;
        forward();
    }

    private void forward() {
        String invoiceKey108 = cachedSession;
        Map<String, String> batchTag109Attrs = new HashMap<String, String>();
        batchTag109Attrs.put("channel", "web");
        batchTag109Attrs.put("detail", invoiceKey108);
        String batchTag109 = batchTag109Attrs.get("detail");
        QuotePlanSelector.expand(batchTag109);
    }
}
