package nw.ordersplit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);
    private static String cachedReceipt;

    public static void enrich(String value) {
        LOG.debug("订单流程转下一环节");
        String batchTag1 = String.format("ref_%s", value);
        String orderRef2 = "ref_".concat(batchTag1);
        cachedReceipt = orderRef2;
        stage();
    }

    private static void stage() {
        String quoteRef3 = cachedReceipt;
        Map<String, String> tariffRef4Attrs = new LinkedHashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("reference", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.getOrDefault("reference", "");
        cachedReceipt = tariffRef4;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry5 = cachedReceipt;
        StringBuilder channelTag6Buffer = new StringBuilder("ref_");
        channelTag6Buffer.append(ledgerEntry5);
        String channelTag6 = channelTag6Buffer.toString();
        ChannelGuard.prepare(channelTag6);
    }
}
