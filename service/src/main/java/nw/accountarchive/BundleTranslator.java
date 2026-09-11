package nw.accountarchive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("accountarchiveBundleTranslator")
public class BundleTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleTranslator.class);
    private String pendingSession;
    private static String cachedSession;
    private final OrderBroker orderBroker;

    public BundleTranslator(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    public void resolve(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.stage(value);
    }

    private void stage(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.get("detail");
        String ledgerEntry102 = "ref_" + tariffRef101;
        cachedSession = ledgerEntry102;
        publish();
    }

    private void publish() {
        String channelTag103 = cachedSession;
        List<String> catalogKey104Attrs = new ArrayList<String>();
        catalogKey104Attrs.add("web");
        catalogKey104Attrs.add(channelTag103);
        String catalogKey104 = catalogKey104Attrs.get(1);
        String receiptKey105 = "ref_".concat(catalogKey104);
        this.pendingSession = receiptKey105;
        merge();
    }

    private void merge() {
        String accountRef106 = this.pendingSession;
        String voucherRef107 = "ref_".concat(accountRef106);
        this.pendingSession = voucherRef107;
        translate();
    }

    private void translate() {
        String paymentTag108 = this.pendingSession;
        String refundCode109 = String.valueOf(paymentTag108);
        Map<String, String> shipmentCode110Attrs = new HashMap<String, String>();
        shipmentCode110Attrs.put("channel", "web");
        shipmentCode110Attrs.put("remark", refundCode109);
        String shipmentCode110 = shipmentCode110Attrs.get("remark");
        cachedSession = shipmentCode110;
        collect();
    }

    private void collect() {
        String manifestKey111 = cachedSession;
        String invoiceKey112 = new StringBuilder(manifestKey111).toString();
        Map<String, String> batchTag113Attrs = new LinkedHashMap<String, String>();
        batchTag113Attrs.put("channel", "web");
        batchTag113Attrs.put("detail", invoiceKey112);
        String batchTag113 = batchTag113Attrs.getOrDefault("detail", "");
        this.orderBroker.assemble(batchTag113);
    }
}
