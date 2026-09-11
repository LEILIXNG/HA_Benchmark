package nw.catalogledger;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogledgerVoucherStrategyStandard")
public class VoucherStrategyStandard implements VoucherStrategy {
    private final ShipmentAdapter shipmentAdapter;

    public VoucherStrategyStandard(ShipmentAdapter shipmentAdapter) {
        this.shipmentAdapter = shipmentAdapter;
    }

    @Override
    public void handle(String value) {
        this.shipmentAdapter.refine(value);
    }
}
