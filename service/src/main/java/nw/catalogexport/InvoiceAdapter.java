package nw.catalogexport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class InvoiceAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAdapter.class);
    private String pendingShipment;
    private static String cachedShipment;

    public static void merge(String value) {
        LOG.debug("商品流程转下一环节");
        InvoiceAdapter self = new InvoiceAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry101 = "ref_".concat(value);
        Map<String, String> channelTag102Attrs = new LinkedHashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("remark", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.getOrDefault("remark", "");
        this.pendingShipment = channelTag102;
        forward();
    }

    private void forward() {
        String catalogKey103 = this.pendingShipment;
        final String receiptKey104 = catalogKey103;
        this.pendingShipment = receiptKey104;
        collect();
    }

    private void collect() {
        String accountRef105 = this.pendingShipment;
        final String voucherRef106 = accountRef105;
        cachedShipment = voucherRef106;
        submit();
    }

    private void submit() {
        String paymentTag107 = cachedShipment;
        Map<String, String> refundCode108Attrs = new HashMap<String, String>();
        refundCode108Attrs.put("channel", "web");
        refundCode108Attrs.put("reference", paymentTag107);
        String refundCode108 = refundCode108Attrs.get("reference");
        String shipmentCode109 = String.format("ref_%s", refundCode108);
        this.pendingShipment = shipmentCode109;
        translate();
    }

    private void translate() {
        String manifestKey110 = this.pendingShipment;
        List<String> invoiceKey111Attrs = new ArrayList<String>();
        invoiceKey111Attrs.add("web");
        invoiceKey111Attrs.add(manifestKey110);
        String invoiceKey111 = invoiceKey111Attrs.get(1);
        cachedShipment = invoiceKey111;
        prepare();
    }

    private void prepare() {
        String batchTag112 = cachedShipment;
        List<String> orderRef113Attrs = new ArrayList<String>();
        orderRef113Attrs.add("web");
        orderRef113Attrs.add(batchTag112);
        String orderRef113 = orderRef113Attrs.get(1);
        List<String> quoteRef114Attrs = new ArrayList<String>();
        quoteRef114Attrs.add("web");
        quoteRef114Attrs.add(orderRef113);
        String quoteRef114 = quoteRef114Attrs.get(1);
        LedgerRuleSelector.resolve(quoteRef114);
    }
}
