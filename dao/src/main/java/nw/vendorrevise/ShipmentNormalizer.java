package nw.vendorrevise;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentNormalizer.class);
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        LOG.debug("开始整理供应商字段");
        ShipmentNormalizer self = new ShipmentNormalizer();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> refundCode201Attrs = new LinkedHashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("detail", value);
        String refundCode201 = refundCode201Attrs.getOrDefault("detail", "");
        this.pendingOrder = refundCode201;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode202 = this.pendingOrder;
        final String manifestKey203 = shipmentCode202;
        cachedOrder = manifestKey203;
        translate();
    }

    private void translate() {
        String invoiceKey204 = cachedOrder;
        String batchTag205 = "ref_" + invoiceKey204;
        BundleBuilder.reconcile(batchTag205);
    }
}
