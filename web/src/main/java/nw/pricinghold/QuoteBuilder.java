package nw.pricinghold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class QuoteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteBuilder.class);

    public static void expand(String value) {
        LOG.debug("开始整理定价字段");
        final String receiptKey101 = value;
        String accountRef102 = String.format("ref_%s", receiptKey101);
        CatalogEnricher.dispatch(accountRef102);
    }
}
