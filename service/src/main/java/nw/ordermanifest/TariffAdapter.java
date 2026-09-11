package nw.ordermanifest;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffAdapter {

    public static void publish(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.get("detail");
        OrderService.resolve(quoteRef201);
    }
}
