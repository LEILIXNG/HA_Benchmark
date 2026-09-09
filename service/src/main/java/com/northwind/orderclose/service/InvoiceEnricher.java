package com.northwind.orderclose.service;

import com.northwind.orderclose.dao.BundleBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("ordercloseInvoiceEnricher")
public class InvoiceEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceEnricher.class);
    private static String cachedManifest;
    private final BundleBuilder bundleBuilder;

    public InvoiceEnricher(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    public void enrich(String value) {
        LOG.debug("订单流程转下一环节");
        StringBuilder accountRef101Buffer = new StringBuilder("ref:");
        accountRef101Buffer.append(value).append(";");
        String accountRef101 = accountRef101Buffer.toString();
        cachedManifest = accountRef101;
        prepare();
    }

    private void prepare() {
        String voucherRef102 = cachedManifest;
        final String paymentTag103 = voucherRef102;
        Map<String, String> refundCode104Attrs = new LinkedHashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("reference", paymentTag103);
        String refundCode104 = refundCode104Attrs.getOrDefault("reference", "");
        cachedManifest = refundCode104;
        expand();
    }

    private void expand() {
        String shipmentCode105 = cachedManifest;
        String manifestKey106 = String.format("ref:%s;", shipmentCode105);
        this.bundleBuilder.refine(manifestKey106);
    }
}
