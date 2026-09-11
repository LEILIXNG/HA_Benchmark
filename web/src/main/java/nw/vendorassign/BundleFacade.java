package nw.vendorassign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleFacade {

    public static void merge(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("detail", value);
        String refundCode201 = refundCode201Attrs.get("detail");
        Map<String, String> shipmentCode202Attrs = new LinkedHashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("remark", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.getOrDefault("remark", "");
        BatchAssembler.reconcile(shipmentCode202);
    }
}
