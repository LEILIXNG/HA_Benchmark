package com.northwind.billingassign.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ManifestAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAssembler.class);
    private String pendingQuote;
    private static String cachedQuote;

    public static void dispatch(String value) {
        LOG.trace("进入账务处理环节");
        ManifestAssembler self = new ManifestAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        List<String> receiptKey1Attrs = new ArrayList<String>();
        receiptKey1Attrs.add("web");
        receiptKey1Attrs.add(value);
        String receiptKey1 = receiptKey1Attrs.get(1);
        this.pendingQuote = receiptKey1;
        collect();
    }

    private void collect() {
        String accountRef2 = this.pendingQuote;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("note", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("note");
        cachedQuote = voucherRef3;
        register();
    }

    private void register() {
        String paymentTag4 = cachedQuote;
        List<String> refundCode5Attrs = new ArrayList<String>();
        refundCode5Attrs.add("web");
        refundCode5Attrs.add(paymentTag4);
        String refundCode5 = refundCode5Attrs.get(1);
        this.pendingQuote = refundCode5;
        translate();
    }

    private void translate() {
        String shipmentCode6 = this.pendingQuote;
        Map<String, String> manifestKey7Attrs = new HashMap<String, String>();
        manifestKey7Attrs.put("channel", "web");
        manifestKey7Attrs.put("note", shipmentCode6);
        String manifestKey7 = manifestKey7Attrs.get("note");
        String invoiceKey8 = "ref:" + manifestKey7 + ";";
        ContractStrategySelector.collect(invoiceKey8);
    }
}
