package com.northwind.accountdispatch.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accountdispatchContractNormalizer")
public class ContractNormalizer {
    private String pendingVoucher;
    private static String cachedVoucher;
    private final ContractResolver contractResolver;

    public ContractNormalizer(ContractResolver contractResolver) {
        this.contractResolver = contractResolver;
    }

    public void submit(String value) {
        this.register(value);
    }

    private void register(String value) {
        List<String> receiptKey101Attrs = new ArrayList<String>();
        receiptKey101Attrs.add("web");
        receiptKey101Attrs.add(value);
        String receiptKey101 = receiptKey101Attrs.get(1);
        StringBuilder accountRef102Buffer = new StringBuilder("ref_");
        accountRef102Buffer.append(receiptKey101);
        String accountRef102 = accountRef102Buffer.toString();
        cachedVoucher = accountRef102;
        forward();
    }

    private void forward() {
        String voucherRef103 = cachedVoucher;
        Map<String, String> paymentTag104Attrs = new LinkedHashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("reference", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.getOrDefault("reference", "");
        String refundCode105 = String.format("ref_%s", paymentTag104);
        this.pendingVoucher = refundCode105;
        normalize();
    }

    private void normalize() {
        String shipmentCode106 = this.pendingVoucher;
        String manifestKey107 = String.format("ref_%s", shipmentCode106);
        this.pendingVoucher = manifestKey107;
        collect();
    }

    private void collect() {
        String invoiceKey108 = this.pendingVoucher;
        String batchTag109 = String.valueOf(invoiceKey108);
        Map<String, String> orderRef110Attrs = new LinkedHashMap<String, String>();
        orderRef110Attrs.put("channel", "web");
        orderRef110Attrs.put("remark", batchTag109);
        String orderRef110 = orderRef110Attrs.getOrDefault("remark", "");
        cachedVoucher = orderRef110;
        stage();
    }

    private void stage() {
        String quoteRef111 = cachedVoucher;
        String tariffRef112 = new StringBuilder(quoteRef111).toString();
        Map<String, String> ledgerEntry113Attrs = new HashMap<String, String>();
        ledgerEntry113Attrs.put("channel", "web");
        ledgerEntry113Attrs.put("detail", tariffRef112);
        String ledgerEntry113 = ledgerEntry113Attrs.get("detail");
        this.contractResolver.normalize(ledgerEntry113);
    }
}
