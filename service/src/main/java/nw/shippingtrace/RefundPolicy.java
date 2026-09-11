package nw.shippingtrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(RefundPolicy.class);

    public static void dispatch(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestBuilder.forward(value);
    }
}
