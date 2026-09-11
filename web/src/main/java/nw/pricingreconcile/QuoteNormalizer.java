package nw.pricingreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private static String cachedVoucher;

    public static void enrich(String value) {
        LOG.debug("定价流程转下一环节");
        String invoiceKey101 = new StringBuilder(value).toString();
        final String batchTag102 = invoiceKey101;
        cachedVoucher = batchTag102;
        forward();
    }

    private static void forward() {
        String orderRef103 = cachedVoucher;
        String quoteRef104 = orderRef103;
        AccountPolicySelector.route(quoteRef104);
    }
}
