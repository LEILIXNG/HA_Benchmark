package com.northwind.vendorarchive.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("vendorarchiveVoucherNormalizer")
public class VoucherNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherNormalizer.class);
    private String pendingPayment;
    private final AccountStrategySelector accountStrategySelector;

    public VoucherNormalizer(AccountStrategySelector accountStrategySelector) {
        this.accountStrategySelector = accountStrategySelector;
    }

    public void collect(String value) {
        LOG.trace("进入供应商处理环节");
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> receiptKey1Attrs = new LinkedHashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.getOrDefault("detail", "");
        String accountRef2 = "ref_".concat(receiptKey1);
        this.pendingPayment = accountRef2;
        forward();
    }

    private void forward() {
        String voucherRef3 = this.pendingPayment;
        Map<String, String> paymentTag4Attrs = new LinkedHashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("reference", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.getOrDefault("reference", "");
        final String refundCode5 = paymentTag4;
        this.accountStrategySelector.attach(refundCode5);
    }
}
