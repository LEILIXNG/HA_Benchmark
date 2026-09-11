package nw.customerrollup;

import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("customerrollupVoucherAdapter")
public class VoucherAdapter {
    private String pendingAccount;
    private final ShipmentStrategySelector shipmentStrategySelector;

    public VoucherAdapter(ShipmentStrategySelector shipmentStrategySelector) {
        this.shipmentStrategySelector = shipmentStrategySelector;
    }

    public void prepare(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        String refundCode501 = new StringBuilder(value).toString();
        this.pendingAccount = refundCode501;
        publish();
    }

    private void publish() {
        String shipmentCode502 = this.pendingAccount;
        String manifestKey503 = new StringBuilder(shipmentCode502).toString();
        this.shipmentStrategySelector.collect(manifestKey503);
    }
}
