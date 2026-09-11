package nw.paymentbind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherBroker {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBroker.class);
    private String pendingSession;
    private static String cachedSession;

    public static void submit(String value) {
        LOG.debug("接收到一次支付处理请求");
        VoucherBroker self = new VoucherBroker();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> shipmentCode301Attrs = new LinkedHashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("detail", value);
        String shipmentCode301 = shipmentCode301Attrs.getOrDefault("detail", "");
        String manifestKey302 = shipmentCode301;
        this.pendingSession = manifestKey302;
        refine();
    }

    private void refine() {
        String invoiceKey303 = this.pendingSession;
        String batchTag304 = String.format("ref_%s", invoiceKey303);
        String orderRef305 = "ref_".concat(batchTag304);
        this.pendingSession = orderRef305;
        prepare();
    }

    private void prepare() {
        String quoteRef306 = this.pendingSession;
        Map<String, String> tariffRef307Attrs = new LinkedHashMap<String, String>();
        tariffRef307Attrs.put("channel", "web");
        tariffRef307Attrs.put("note", quoteRef306);
        String tariffRef307 = tariffRef307Attrs.getOrDefault("note", "");
        List<String> ledgerEntry308Attrs = new ArrayList<String>();
        ledgerEntry308Attrs.add("web");
        ledgerEntry308Attrs.add(tariffRef307);
        String ledgerEntry308 = ledgerEntry308Attrs.get(1);
        cachedSession = ledgerEntry308;
        expand();
    }

    private void expand() {
        String channelTag309 = cachedSession;
        Map<String, String> catalogKey310Attrs = new HashMap<String, String>();
        catalogKey310Attrs.put("channel", "web");
        catalogKey310Attrs.put("remark", channelTag309);
        String catalogKey310 = catalogKey310Attrs.get("remark");
        Map<String, String> receiptKey311Attrs = new HashMap<String, String>();
        receiptKey311Attrs.put("channel", "web");
        receiptKey311Attrs.put("note", catalogKey310);
        String receiptKey311 = receiptKey311Attrs.get("note");
        ReceiptRegistry.prepare(receiptKey311);
    }
}
