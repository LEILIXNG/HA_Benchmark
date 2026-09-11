package nw.paymentrollup;

import org.springframework.stereotype.Component;

/**
 * 支付的默认处理策略。
 */
@Component("paymentrollupCatalogPolicyStandard")
public class CatalogPolicyStandard implements CatalogPolicy {
    private final ShipmentBroker shipmentBroker;

    public CatalogPolicyStandard(ShipmentBroker shipmentBroker) {
        this.shipmentBroker = shipmentBroker;
    }

    @Override
    public void handle(String value) {
        this.shipmentBroker.enrich(value);
    }
}
