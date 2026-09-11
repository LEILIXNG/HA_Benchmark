package nw.shippingassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingassignShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private final VoucherEnricher voucherEnricher;

    public ShipmentRouter(VoucherEnricher voucherEnricher) {
        this.voucherEnricher = voucherEnricher;
    }

    public void merge(String value) {
        LOG.debug("发运流程转下一环节");
        this.voucherEnricher.register(value);
    }
}
