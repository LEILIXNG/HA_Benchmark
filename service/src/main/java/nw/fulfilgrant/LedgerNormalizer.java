package nw.fulfilgrant;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class LedgerNormalizer {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void expand(String value) {
        LedgerNormalizer self = new LedgerNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        String manifestKey301 = String.valueOf(value);
        cachedReceipt = manifestKey301;
        normalize();
    }

    private void normalize() {
        String invoiceKey302 = cachedReceipt;
        Map<String, String> batchTag303Attrs = new HashMap<String, String>();
        batchTag303Attrs.put("channel", "web");
        batchTag303Attrs.put("note", invoiceKey302);
        String batchTag303 = batchTag303Attrs.get("note");
        this.pendingReceipt = batchTag303;
        assemble();
    }

    private void assemble() {
        String orderRef304 = this.pendingReceipt;
        String quoteRef305 = "ref_".concat(orderRef304);
        String tariffRef306 = String.format("ref_%s", quoteRef305);
        ReceiptExecutor.refine(tariffRef306);
    }
}
