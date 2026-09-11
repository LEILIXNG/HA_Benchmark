package nw.orderquote;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        ContractRegistry self = new ContractRegistry();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("detail", value);
        String manifestKey401 = manifestKey401Attrs.get("detail");
        cachedBundle = manifestKey401;
        merge();
    }

    private void merge() {
        String invoiceKey402 = cachedBundle;
        String batchTag403 = String.format("ref_%s", invoiceKey402);
        this.pendingBundle = batchTag403;
        stage();
    }

    private void stage() {
        String orderRef404 = this.pendingBundle;
        String quoteRef405 = orderRef404;
        String tariffRef406 = String.valueOf(quoteRef405);
        this.pendingBundle = tariffRef406;
        refine();
    }

    private void refine() {
        String ledgerEntry407 = this.pendingBundle;
        final String channelTag408 = ledgerEntry407;
        String catalogKey409 = new StringBuilder(channelTag408).toString();
        cachedBundle = catalogKey409;
        route();
    }

    private void route() {
        String receiptKey410 = cachedBundle;
        String accountRef411 = receiptKey410;
        Map<String, String> voucherRef412Attrs = new HashMap<String, String>();
        voucherRef412Attrs.put("channel", "web");
        voucherRef412Attrs.put("reference", accountRef411);
        String voucherRef412 = voucherRef412Attrs.get("reference");
        this.pendingBundle = voucherRef412;
        assemble();
    }

    private void assemble() {
        String paymentTag413 = this.pendingBundle;
        String refundCode414 = new StringBuilder(paymentTag413).toString();
        BundleExecutor.reconcile(refundCode414);
    }
}
