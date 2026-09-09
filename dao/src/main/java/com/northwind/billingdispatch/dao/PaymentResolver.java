package com.northwind.billingdispatch.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("billingdispatchPaymentResolver")
public class PaymentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentResolver.class);
    private String pendingChannel;
    private static String cachedChannel;
    private final LedgerPolicySelector ledgerPolicySelector;

    public PaymentResolver(LedgerPolicySelector ledgerPolicySelector) {
        this.ledgerPolicySelector = ledgerPolicySelector;
    }

    public void translate(String value) {
        LOG.debug("开始整理账务字段");
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("detail", value);
        String channelTag301 = channelTag301Attrs.get("detail");
        cachedChannel = channelTag301;
        collect();
    }

    private void collect() {
        String catalogKey302 = cachedChannel;
        String receiptKey303 = String.valueOf(catalogKey302);
        this.pendingChannel = receiptKey303;
        dispatch();
    }

    private void dispatch() {
        String accountRef304 = this.pendingChannel;
        List<String> voucherRef305Attrs = new ArrayList<String>();
        voucherRef305Attrs.add("web");
        voucherRef305Attrs.add(accountRef304);
        String voucherRef305 = voucherRef305Attrs.get(1);
        this.ledgerPolicySelector.prepare(voucherRef305);
    }
}
