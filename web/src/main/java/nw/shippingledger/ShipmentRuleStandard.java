package nw.shippingledger;

import org.springframework.stereotype.Component;

/**
 * 发运的默认处理策略。
 */
@Component("shippingledgerShipmentRuleStandard")
public class ShipmentRuleStandard implements ShipmentRule {
    private final ShipmentRouter shipmentRouter;

    public ShipmentRuleStandard(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    @Override
    public void handle(String value) {
        this.shipmentRouter.normalize(value);
    }
}
