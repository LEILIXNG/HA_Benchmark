package nw.shippingarchive;

import java.util.HashMap;
import java.util.Map;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ShipmentCoordinator {
    private String pendingSession;

    public static void assemble(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String receiptKey101 = "ref_" + value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("remark", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("remark");
        this.pendingSession = accountRef102;
        publish();
    }

    private void publish() {
        String voucherRef103 = this.pendingSession;
        String paymentTag104 = String.valueOf(voucherRef103);
        LedgerGuard.resolve(paymentTag104);
    }
}
