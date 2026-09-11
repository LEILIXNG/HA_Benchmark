package nw.pricingreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundCollector {
    private static final Logger LOG = LoggerFactory.getLogger(RefundCollector.class);

    public static void merge(String value) {
        LOG.debug("定价流程转下一环节");
        final String ledgerEntry301 = value;
        VoucherExecutor.dispatch(ledgerEntry301);
    }
}
