package com.northwind.pricingissue.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricingissueLedgerNormalizer")
public class LedgerNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerNormalizer.class);
    private String pendingBundle;
    private static String cachedBundle;
    private final QuotePolicySelector quotePolicySelector;

    public LedgerNormalizer(QuotePolicySelector quotePolicySelector) {
        this.quotePolicySelector = quotePolicySelector;
    }

    public void reconcile(String value) {
        LOG.trace("进入定价处理环节");
        this.collect(value);
    }

    private void collect(String value) {
        String manifestKey101 = "ref_" + value;
        String invoiceKey102 = new StringBuilder(manifestKey101).toString();
        this.pendingBundle = invoiceKey102;
        attach();
    }

    private void attach() {
        String batchTag103 = this.pendingBundle;
        String orderRef104 = "ref_".concat(batchTag103);
        String quoteRef105 = orderRef104;
        this.pendingBundle = quoteRef105;
        merge();
    }

    private void merge() {
        String tariffRef106 = this.pendingBundle;
        Map<String, String> ledgerEntry107Attrs = new LinkedHashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("note", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.getOrDefault("note", "");
        this.pendingBundle = ledgerEntry107;
        submit();
    }

    private void submit() {
        String channelTag108 = this.pendingBundle;
        String catalogKey109 = new StringBuilder(channelTag108).toString();
        String receiptKey110 = String.valueOf(catalogKey109);
        this.pendingBundle = receiptKey110;
        compose();
    }

    private void compose() {
        String accountRef111 = this.pendingBundle;
        String voucherRef112 = String.valueOf(accountRef111);
        cachedBundle = voucherRef112;
        enrich();
    }

    private void enrich() {
        String paymentTag113 = cachedBundle;
        StringBuilder refundCode114Buffer = new StringBuilder("ref_");
        refundCode114Buffer.append(paymentTag113);
        String refundCode114 = refundCode114Buffer.toString();
        this.quotePolicySelector.refine(refundCode114);
    }
}
