package nw.paymentbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ReceiptRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRegistry.class);

    public static void prepare(String value) {
        LOG.debug("接收到一次支付处理请求");
        String receiptKey401 = new StringBuilder(value).toString();
        ChannelAssembler.prepare(receiptKey401);
    }
}
