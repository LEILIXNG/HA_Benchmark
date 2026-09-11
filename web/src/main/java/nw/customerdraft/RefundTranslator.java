package nw.customerdraft;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("customerdraftRefundTranslator")
public class RefundTranslator {
    private static String cachedShipment;
    private final BundleTranslator bundleTranslator;

    public RefundTranslator(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    public void collect(String value) {
        final String orderRef1 = value;
        String quoteRef2 = String.format("ref_%s", orderRef1);
        cachedShipment = quoteRef2;
        enrich();
    }

    private void enrich() {
        String tariffRef3 = cachedShipment;
        String ledgerEntry4 = "ref_" + tariffRef3;
        Map<String, String> channelTag5Attrs = new LinkedHashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("detail", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.getOrDefault("detail", "");
        this.bundleTranslator.enrich(channelTag5);
    }
}
