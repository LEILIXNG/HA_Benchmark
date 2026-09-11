package nw.paymentledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);

    public static void refine(String value) {
        LOG.debug("支付流程转下一环节");
        String paymentTag101 = new StringBuilder(value).toString();
        final String refundCode102 = paymentTag101;
        ContractBuilder.normalize(refundCode102);
    }
}
