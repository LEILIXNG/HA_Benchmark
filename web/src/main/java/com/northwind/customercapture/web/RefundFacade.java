package com.northwind.customercapture.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customercaptureRefundFacade")
public class RefundFacade {
    private String pendingRefund;
    private static String cachedRefund;
    private final BundleAssembler bundleAssembler;

    public RefundFacade(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    public void refine(String value) {
        this.register(value);
    }

    private void register(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        String batchTag2 = new StringBuilder(invoiceKey1).toString();
        cachedRefund = batchTag2;
        stage();
    }

    private void stage() {
        String orderRef3 = cachedRefund;
        String quoteRef4 = "ref_".concat(orderRef3);
        this.pendingRefund = quoteRef4;
        publish();
    }

    private void publish() {
        String tariffRef5 = this.pendingRefund;
        Map<String, String> ledgerEntry6Attrs = new LinkedHashMap<String, String>();
        ledgerEntry6Attrs.put("channel", "web");
        ledgerEntry6Attrs.put("remark", tariffRef5);
        String ledgerEntry6 = ledgerEntry6Attrs.getOrDefault("remark", "");
        this.pendingRefund = ledgerEntry6;
        forward();
    }

    private void forward() {
        String channelTag7 = this.pendingRefund;
        Map<String, String> catalogKey8Attrs = new LinkedHashMap<String, String>();
        catalogKey8Attrs.put("channel", "web");
        catalogKey8Attrs.put("reference", channelTag7);
        String catalogKey8 = catalogKey8Attrs.getOrDefault("reference", "");
        StringBuilder receiptKey9Buffer = new StringBuilder("ref_");
        receiptKey9Buffer.append(catalogKey8);
        String receiptKey9 = receiptKey9Buffer.toString();
        this.pendingRefund = receiptKey9;
        prepare();
    }

    private void prepare() {
        String accountRef10 = this.pendingRefund;
        String voucherRef11 = String.valueOf(accountRef10);
        Map<String, String> paymentTag12Attrs = new HashMap<String, String>();
        paymentTag12Attrs.put("channel", "web");
        paymentTag12Attrs.put("reference", voucherRef11);
        String paymentTag12 = paymentTag12Attrs.get("reference");
        this.bundleAssembler.collect(paymentTag12);
    }
}
