package nw.paymentarchive;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleComposer.class);
    private String pendingSession;

    public static void reconcile(String value) {
        LOG.debug("支付流程转下一环节");
        BundleComposer self = new BundleComposer();
        self.attach(value);
    }

    private void attach(String value) {
        String voucherRef401 = "ref_" + value;
        StringBuilder paymentTag402Buffer = new StringBuilder("ref_");
        paymentTag402Buffer.append(voucherRef401);
        String paymentTag402 = paymentTag402Buffer.toString();
        this.pendingSession = paymentTag402;
        refine();
    }

    private void refine() {
        String refundCode403 = this.pendingSession;
        Map<String, String> shipmentCode404Attrs = new HashMap<String, String>();
        shipmentCode404Attrs.put("channel", "web");
        shipmentCode404Attrs.put("reference", refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get("reference");
        SessionGateway.forward(shipmentCode404);
    }
}
