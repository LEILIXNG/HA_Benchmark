package nw.shippinggrant;

import java.util.HashMap;
import java.util.Map;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundComposer {

    public static void translate(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("detail", value);
        String voucherRef401 = voucherRef401Attrs.get("detail");
        String paymentTag402 = "ref_" + voucherRef401;
        ShipmentAdapter.refine(paymentTag402);
    }
}
