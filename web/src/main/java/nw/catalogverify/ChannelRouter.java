package nw.catalogverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRouter.class);

    public static void publish(String value) {
        LOG.debug("商品流程转下一环节");
        final String invoiceKey1 = value;
        LedgerRouter.submit(invoiceKey1);
    }
}
