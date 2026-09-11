package nw.shippingcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleComposer.class);

    public static void stage(String value) {
        LOG.debug("发运流程转下一环节");
        String tariffRef501 = value;
        String ledgerEntry502 = String.valueOf(tariffRef501);
        PaymentScreen.collect(ledgerEntry502);
    }
}
