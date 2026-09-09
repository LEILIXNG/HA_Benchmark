package com.northwind.paymentsubmit.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentsubmitOrderRegistry")
public class OrderRegistry {
    private String pendingSession;
    private final VoucherPlanSelector voucherPlanSelector;

    public OrderRegistry(VoucherPlanSelector voucherPlanSelector) {
        this.voucherPlanSelector = voucherPlanSelector;
    }

    public void assemble(String value) {
        this.attach(value);
    }

    private void attach(String value) {
        String invoiceKey401 = new StringBuilder(value).toString();
        this.pendingSession = invoiceKey401;
        forward();
    }

    private void forward() {
        String batchTag402 = this.pendingSession;
        String orderRef403 = new StringBuilder(batchTag402).toString();
        Map<String, String> quoteRef404Attrs = new LinkedHashMap<String, String>();
        quoteRef404Attrs.put("channel", "web");
        quoteRef404Attrs.put("reference", orderRef403);
        String quoteRef404 = quoteRef404Attrs.getOrDefault("reference", "");
        this.voucherPlanSelector.merge(quoteRef404);
    }
}
