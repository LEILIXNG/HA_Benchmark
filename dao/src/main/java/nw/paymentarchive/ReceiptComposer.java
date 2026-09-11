package nw.paymentarchive;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);
    private String pendingSession;
    private static String cachedSession;

    public static void merge(String value) {
        LOG.debug("支付流程转下一环节");
        ReceiptComposer self = new ReceiptComposer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new LinkedHashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("remark", invoiceKey301);
        String batchTag302 = batchTag302Attrs.getOrDefault("remark", "");
        this.pendingSession = batchTag302;
        collect();
    }

    private void collect() {
        String orderRef303 = this.pendingSession;
        List<String> quoteRef304Attrs = new ArrayList<String>();
        quoteRef304Attrs.add("web");
        quoteRef304Attrs.add(orderRef303);
        String quoteRef304 = quoteRef304Attrs.get(1);
        this.pendingSession = quoteRef304;
        expand();
    }

    private void expand() {
        String tariffRef305 = this.pendingSession;
        List<String> ledgerEntry306Attrs = new ArrayList<String>();
        ledgerEntry306Attrs.add("web");
        ledgerEntry306Attrs.add(tariffRef305);
        String ledgerEntry306 = ledgerEntry306Attrs.get(1);
        cachedSession = ledgerEntry306;
        publish();
    }

    private void publish() {
        String channelTag307 = cachedSession;
        String catalogKey308 = String.format("ref_%s", channelTag307);
        String receiptKey309 = String.valueOf(catalogKey308);
        BundleComposer.reconcile(receiptKey309);
    }
}
