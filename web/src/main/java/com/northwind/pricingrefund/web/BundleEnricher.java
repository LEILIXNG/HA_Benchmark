package com.northwind.pricingrefund.web;

import com.northwind.pricingrefund.service.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingrefundBundleEnricher")
public class BundleEnricher {
    private static String cachedReceipt;
    private final VoucherEnricher voucherEnricher;

    public BundleEnricher(VoucherEnricher voucherEnricher) {
        this.voucherEnricher = voucherEnricher;
    }

    public void forward(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        String batchTag2 = "ref_".concat(invoiceKey1);
        cachedReceipt = batchTag2;
        translate();
    }

    private void translate() {
        String orderRef3 = cachedReceipt;
        StringBuilder quoteRef4Buffer = new StringBuilder("ref_");
        quoteRef4Buffer.append(orderRef3);
        String quoteRef4 = quoteRef4Buffer.toString();
        String tariffRef5 = "ref_" + quoteRef4;
        cachedReceipt = tariffRef5;
        attach();
    }

    private void attach() {
        String ledgerEntry6 = cachedReceipt;
        String channelTag7 = new StringBuilder(ledgerEntry6).toString();
        String catalogKey8 = String.valueOf(channelTag7);
        this.voucherEnricher.publish(catalogKey8);
    }
}
