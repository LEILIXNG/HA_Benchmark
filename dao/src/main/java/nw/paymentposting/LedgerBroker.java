package nw.paymentposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerBroker {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBroker.class);

    public static void compose(String value) {
        LOG.debug("支付流程转下一环节");
        StringBuilder manifestKey601Buffer = new StringBuilder("ref_");
        manifestKey601Buffer.append(value);
        String manifestKey601 = manifestKey601Buffer.toString();
        String invoiceKey602 = manifestKey601;
        ChannelGuard.collect(invoiceKey602);
    }
}
