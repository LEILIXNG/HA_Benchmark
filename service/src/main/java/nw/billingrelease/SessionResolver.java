package nw.billingrelease;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionResolver {
    private static final Logger LOG = LoggerFactory.getLogger(SessionResolver.class);
    private String pendingShipment;
    private static String cachedShipment;

    public static void expand(String value) {
        LOG.debug("账务流程转下一环节");
        SessionResolver self = new SessionResolver();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        String shipmentCode102 = String.valueOf(refundCode101);
        cachedShipment = shipmentCode102;
        refine();
    }

    private void refine() {
        String manifestKey103 = cachedShipment;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("reference", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("reference");
        this.pendingShipment = invoiceKey104;
        collect();
    }

    private void collect() {
        String batchTag105 = this.pendingShipment;
        String orderRef106 = new StringBuilder(batchTag105).toString();
        Map<String, String> quoteRef107Attrs = new LinkedHashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("note", orderRef106);
        String quoteRef107 = quoteRef107Attrs.getOrDefault("note", "");
        ChannelStrategySelector.attach(quoteRef107);
    }
}
