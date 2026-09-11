package nw.pricingarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResolver.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理定价字段");
        String catalogKey301 = String.format("ref_%s", value);
        PaymentFetcher.publish(catalogKey301);
    }
}
