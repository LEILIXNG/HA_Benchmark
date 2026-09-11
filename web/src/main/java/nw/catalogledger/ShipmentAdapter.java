package nw.catalogledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogledgerShipmentAdapter")
public class ShipmentAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAdapter.class);
    private final ShipmentResolver shipmentResolver;

    public ShipmentAdapter(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    public void refine(String value) {
        LOG.debug("商品流程转下一环节");
        final String tariffRef101 = value;
        this.shipmentResolver.compose(tariffRef101);
    }
}
