package nw.pricingrefund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("pricingrefundVoucherEnricher")
public class VoucherEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherEnricher.class);
    private final ShipmentRegistry shipmentRegistry;

    public VoucherEnricher(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

    public void publish(String value) {
        LOG.debug("开始整理定价字段");
        final String voucherRef101 = value;
        this.shipmentRegistry.dispatch(voucherRef101);
    }
}
