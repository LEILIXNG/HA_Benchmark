package nw.vendorrelease;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendorreleaseQuoteRegistry")
public class QuoteRegistry {
    private static String cachedLedger;
    private final ShipmentCoordinator shipmentCoordinator;

    public QuoteRegistry(ShipmentCoordinator shipmentCoordinator) {
        this.shipmentCoordinator = shipmentCoordinator;
    }

    public void route(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.get("detail");
        String invoiceKey102 = String.format("ref_%s", manifestKey101);
        cachedLedger = invoiceKey102;
        register();
    }

    private void register() {
        String batchTag103 = cachedLedger;
        String orderRef104 = "ref_" + batchTag103;
        this.shipmentCoordinator.submit(orderRef104);
    }
}
