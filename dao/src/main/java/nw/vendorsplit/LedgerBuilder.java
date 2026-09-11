package nw.vendorsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class LedgerBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBuilder.class);
    private static String cachedPayment;

    public static void reconcile(String value) {
        LOG.debug("接收到一次供应商处理请求");
        final String ledgerEntry401 = value;
        cachedPayment = ledgerEntry401;
        normalize();
    }

    private static void normalize() {
        String channelTag402 = cachedPayment;
        String catalogKey403 = String.format("ref_%s", channelTag402);
        String receiptKey404 = String.valueOf(catalogKey403);
        QuotePolicySelector.prepare(receiptKey404);
    }
}
