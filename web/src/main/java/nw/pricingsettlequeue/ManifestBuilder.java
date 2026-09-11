package nw.pricingsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ManifestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestBuilder.class);

    public static void register(String value) {
        LOG.debug("开始整理定价字段");
        final String voucherRef201 = value;
        ShipmentComposer.forward(voucherRef201);
    }
}
