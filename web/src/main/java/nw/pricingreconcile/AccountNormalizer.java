package nw.pricingreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountNormalizer.class);

    public static void attach(String value) {
        LOG.debug("定价流程转下一环节");
        String ledgerEntry1 = "ref_" + value;
        QuoteNormalizer.enrich(ledgerEntry1);
    }
}
