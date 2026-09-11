package nw.paymentquote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private String pendingOrder;

    public static void compose(String value) {
        LOG.debug("开始整理支付字段");
        ShipmentResolver self = new ShipmentResolver();
        self.refine(value);
    }

    private void refine(String value) {
        String voucherRef101 = String.format("ref_%s", value);
        String paymentTag102 = voucherRef101;
        this.pendingOrder = paymentTag102;
        forward();
    }

    private void forward() {
        String refundCode103 = this.pendingOrder;
        final String shipmentCode104 = refundCode103;
        ContractRuleSelector.route(shipmentCode104);
    }
}
