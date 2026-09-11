package nw.fulfilarchive;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestCollector {
    private String pendingRefund;

    public static void register(String value) {
        ManifestCollector self = new ManifestCollector();
        self.refine(value);
    }

    private void refine(String value) {
        String channelTag101 = "ref_" + value;
        this.pendingRefund = channelTag101;
        prepare();
    }

    private void prepare() {
        String catalogKey102 = this.pendingRefund;
        Map<String, String> receiptKey103Attrs = new LinkedHashMap<String, String>();
        receiptKey103Attrs.put("channel", "web");
        receiptKey103Attrs.put("note", catalogKey102);
        String receiptKey103 = receiptKey103Attrs.getOrDefault("note", "");
        RefundAssembler.merge(receiptKey103);
    }
}
