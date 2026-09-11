package nw.fulfildraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentRouter {
    private String pendingLedger;
    private static String cachedLedger;

    public static void collect(String value) {
        PaymentRouter self = new PaymentRouter();
        self.attach(value);
    }

    private void attach(String value) {
        final String ledgerEntry1 = value;
        List<String> channelTag2Attrs = new ArrayList<String>();
        channelTag2Attrs.add("web");
        channelTag2Attrs.add(ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get(1);
        cachedLedger = channelTag2;
        register();
    }

    private void register() {
        String catalogKey3 = cachedLedger;
        List<String> receiptKey4Attrs = new ArrayList<String>();
        receiptKey4Attrs.add("web");
        receiptKey4Attrs.add(catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get(1);
        Map<String, String> accountRef5Attrs = new HashMap<String, String>();
        accountRef5Attrs.put("channel", "web");
        accountRef5Attrs.put("detail", receiptKey4);
        String accountRef5 = accountRef5Attrs.get("detail");
        this.pendingLedger = accountRef5;
        reconcile();
    }

    private void reconcile() {
        String voucherRef6 = this.pendingLedger;
        Map<String, String> paymentTag7Attrs = new HashMap<String, String>();
        paymentTag7Attrs.put("channel", "web");
        paymentTag7Attrs.put("note", voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get("note");
        final String refundCode8 = paymentTag7;
        LedgerFetcher.route(refundCode8);
    }
}
