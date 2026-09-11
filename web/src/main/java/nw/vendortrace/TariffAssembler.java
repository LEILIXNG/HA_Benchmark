package nw.vendortrace;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffAssembler {

    public static void publish(String value) {
        Map<String, String> shipmentCode1Attrs = new LinkedHashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.getOrDefault("detail", "");
        RefundPolicySelector.reconcile(shipmentCode1);
    }
}
