package com.northwind.reportdraft.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("reportdraftChannelNormalizer")
public class ChannelNormalizer {
    private String pendingQuote;
    private static String cachedQuote;

    public void compose(String value) {
        this.reconcile(value);
    }

    private void reconcile(String value) {
        final String invoiceKey201 = value;
        Map<String, String> batchTag202Attrs = new LinkedHashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("remark", invoiceKey201);
        String batchTag202 = batchTag202Attrs.getOrDefault("remark", "");
        cachedQuote = batchTag202;
        dispatch();
    }

    private void dispatch() {
        String orderRef203 = cachedQuote;
        String quoteRef204 = String.valueOf(orderRef203);
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        this.pendingQuote = tariffRef205;
        attach();
    }

    private void attach() {
        String ledgerEntry206 = this.pendingQuote;
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        final String catalogKey208 = channelTag207;
        QuoteEvaluator.dispatch(catalogKey208);
    }
}
