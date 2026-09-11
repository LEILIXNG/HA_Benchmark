package nw.paymentposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffBroker {
    private static final Logger LOG = LoggerFactory.getLogger(TariffBroker.class);

    public static void forward(String value) {
        LOG.debug("支付流程转下一环节");
        String accountRef101 = new StringBuilder(value).toString();
        TariffRouter.publish(accountRef101);
    }
}
