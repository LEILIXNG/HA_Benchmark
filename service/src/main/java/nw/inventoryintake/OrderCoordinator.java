package nw.inventoryintake;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderCoordinator {

    public static void forward(String value) {
        Map<String, String> receiptKey401Attrs = new LinkedHashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("detail", value);
        String receiptKey401 = receiptKey401Attrs.getOrDefault("detail", "");
        PaymentExecutor.reconcile(receiptKey401);
    }
}
