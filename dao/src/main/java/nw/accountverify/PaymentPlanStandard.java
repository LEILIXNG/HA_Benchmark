package nw.accountverify;

import org.springframework.stereotype.Repository;

/**
 * 账户的默认处理策略。
 */
@Repository("accountverifyPaymentPlanStandard")
public class PaymentPlanStandard implements PaymentPlan {
    private final ShipmentBroker shipmentBroker;

    public PaymentPlanStandard(ShipmentBroker shipmentBroker) {
        this.shipmentBroker = shipmentBroker;
    }

    @Override
    public void handle(String value) {
        this.shipmentBroker.normalize(value);
    }
}
