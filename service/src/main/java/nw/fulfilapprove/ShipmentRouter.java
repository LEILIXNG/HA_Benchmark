package nw.fulfilapprove;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("fulfilapproveShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private final SessionEnricher sessionEnricher;

    public ShipmentRouter(SessionEnricher sessionEnricher) {
        this.sessionEnricher = sessionEnricher;
    }

    public void enrich(String value) {
        LOG.debug("开始整理履约字段");
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.get("detail");
        Map<String, String> invoiceKey102Attrs = new LinkedHashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("remark", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.getOrDefault("remark", "");
        this.sessionEnricher.collect(invoiceKey102);
    }
}
