package nw.ordermanifest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceResolver {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void merge(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String receiptKey401 = String.valueOf(value);
        String accountRef402 = "ref_" + receiptKey401;
        cachedCatalog = accountRef402;
        dispatch();
    }

    private void dispatch() {
        String voucherRef403 = cachedCatalog;
        String paymentTag404 = String.format("ref_%s", voucherRef403);
        cachedCatalog = paymentTag404;
        enrich();
    }

    private void enrich() {
        String refundCode405 = cachedCatalog;
        final String shipmentCode406 = refundCode405;
        this.pendingCatalog = shipmentCode406;
        forward();
    }

    private void forward() {
        String manifestKey407 = this.pendingCatalog;
        Map<String, String> invoiceKey408Attrs = new LinkedHashMap<String, String>();
        invoiceKey408Attrs.put("channel", "web");
        invoiceKey408Attrs.put("reference", manifestKey407);
        String invoiceKey408 = invoiceKey408Attrs.getOrDefault("reference", "");
        List<String> batchTag409Attrs = new ArrayList<String>();
        batchTag409Attrs.add("web");
        batchTag409Attrs.add(invoiceKey408);
        String batchTag409 = batchTag409Attrs.get(1);
        cachedCatalog = batchTag409;
        attach();
    }

    private void attach() {
        String orderRef410 = cachedCatalog;
        String quoteRef411 = "ref_".concat(orderRef410);
        Map<String, String> tariffRef412Attrs = new LinkedHashMap<String, String>();
        tariffRef412Attrs.put("channel", "web");
        tariffRef412Attrs.put("reference", quoteRef411);
        String tariffRef412 = tariffRef412Attrs.getOrDefault("reference", "");
        this.pendingCatalog = tariffRef412;
        compose();
    }

    private void compose() {
        String ledgerEntry413 = this.pendingCatalog;
        String channelTag414 = ledgerEntry413;
        OrderRouter.reconcile(channelTag414);
    }
}
