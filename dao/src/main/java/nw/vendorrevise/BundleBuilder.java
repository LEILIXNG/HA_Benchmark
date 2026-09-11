package nw.vendorrevise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        LOG.debug("开始整理供应商字段");
        BundleBuilder self = new BundleBuilder();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> catalogKey301Attrs = new LinkedHashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("detail", value);
        String catalogKey301 = catalogKey301Attrs.getOrDefault("detail", "");
        String receiptKey302 = catalogKey301;
        cachedOrder = receiptKey302;
        normalize();
    }

    private void normalize() {
        String accountRef303 = cachedOrder;
        List<String> voucherRef304Attrs = new ArrayList<String>();
        voucherRef304Attrs.add("web");
        voucherRef304Attrs.add(accountRef303);
        String voucherRef304 = voucherRef304Attrs.get(1);
        cachedOrder = voucherRef304;
        compose();
    }

    private void compose() {
        String paymentTag305 = cachedOrder;
        final String refundCode306 = paymentTag305;
        this.pendingOrder = refundCode306;
        submit();
    }

    private void submit() {
        String shipmentCode307 = this.pendingOrder;
        List<String> manifestKey308Attrs = new ArrayList<String>();
        manifestKey308Attrs.add("web");
        manifestKey308Attrs.add(shipmentCode307);
        String manifestKey308 = manifestKey308Attrs.get(1);
        String invoiceKey309 = "ref_" + manifestKey308;
        cachedOrder = invoiceKey309;
        collect();
    }

    private void collect() {
        String batchTag310 = cachedOrder;
        String orderRef311 = new StringBuilder(batchTag310).toString();
        final String quoteRef312 = orderRef311;
        OrderExecutor.stage(quoteRef312);
    }
}
