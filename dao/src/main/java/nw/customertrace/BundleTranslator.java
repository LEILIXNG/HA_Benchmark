package nw.customertrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleTranslator.class);

    public static void stage(String value) {
        LOG.debug("开始整理客户字段");
        String paymentTag201 = value;
        BundleGuard.submit(paymentTag201);
    }
}
