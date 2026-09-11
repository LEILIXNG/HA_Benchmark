package nw.shippingexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestComposer.class);

    public static void enrich(String value) {
        LOG.debug("开始整理发运字段");
        String invoiceKey101 = new StringBuilder(value).toString();
        QuoteStrategySelector.compose(invoiceKey101);
    }
}
