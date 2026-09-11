package nw.pricingsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherTranslator.class);

    public static void submit(String value) {
        LOG.debug("开始整理定价字段");
        String invoiceKey401 = new StringBuilder(value).toString();
        String batchTag402 = "ref_".concat(invoiceKey401);
        CatalogLoader.refine(batchTag402);
    }
}
