package nw.inventoryreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ManifestResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestResolver.class);

    public static void refine(String value) {
        LOG.debug("接收到一次库存处理请求");
        String voucherRef201 = "ref_".concat(value);
        RefundAdapter.register(voucherRef201);
    }
}
