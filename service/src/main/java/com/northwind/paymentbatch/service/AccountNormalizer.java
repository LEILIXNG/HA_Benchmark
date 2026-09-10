package com.northwind.paymentbatch.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("paymentbatchAccountNormalizer")
public class AccountNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountNormalizer.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final SessionPolicySelector sessionPolicySelector;

    public AccountNormalizer(SessionPolicySelector sessionPolicySelector) {
        this.sessionPolicySelector = sessionPolicySelector;
    }

    public void attach(String value) {
        LOG.debug("支付流程转下一环节");
        this.forward(value);
    }

    private void forward(String value) {
        String invoiceKey201 = "ref_" + value;
        StringBuilder batchTag202Buffer = new StringBuilder("ref_");
        batchTag202Buffer.append(invoiceKey201);
        String batchTag202 = batchTag202Buffer.toString();
        this.pendingReceipt = batchTag202;
        resolve();
    }

    private void resolve() {
        String orderRef203 = this.pendingReceipt;
        Map<String, String> quoteRef204Attrs = new LinkedHashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("reference", orderRef203);
        String quoteRef204 = quoteRef204Attrs.getOrDefault("reference", "");
        String tariffRef205 = String.format("ref_%s", quoteRef204);
        cachedReceipt = tariffRef205;
        publish();
    }

    private void publish() {
        String ledgerEntry206 = cachedReceipt;
        String channelTag207 = new StringBuilder(ledgerEntry206).toString();
        this.pendingReceipt = channelTag207;
        submit();
    }

    private void submit() {
        String catalogKey208 = this.pendingReceipt;
        Map<String, String> receiptKey209Attrs = new HashMap<String, String>();
        receiptKey209Attrs.put("channel", "web");
        receiptKey209Attrs.put("detail", catalogKey208);
        String receiptKey209 = receiptKey209Attrs.get("detail");
        final String accountRef210 = receiptKey209;
        this.sessionPolicySelector.enrich(accountRef210);
    }
}
