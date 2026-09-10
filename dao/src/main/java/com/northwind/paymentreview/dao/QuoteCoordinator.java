package com.northwind.paymentreview.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("paymentreviewQuoteCoordinator")
public class QuoteCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCoordinator.class);
    private String pendingLedger;
    private static String cachedLedger;
    private final LedgerEvaluator ledgerEvaluator;

    public QuoteCoordinator(LedgerEvaluator ledgerEvaluator) {
        this.ledgerEvaluator = ledgerEvaluator;
    }

    public void resolve(String value) {
        LOG.trace("进入支付处理环节");
        this.forward(value);
    }

    private void forward(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("detail", value);
        String invoiceKey201 = invoiceKey201Attrs.get("detail");
        cachedLedger = invoiceKey201;
        register();
    }

    private void register() {
        String batchTag202 = cachedLedger;
        String orderRef203 = "ref_" + batchTag202;
        Map<String, String> quoteRef204Attrs = new LinkedHashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("reference", orderRef203);
        String quoteRef204 = quoteRef204Attrs.getOrDefault("reference", "");
        this.pendingLedger = quoteRef204;
        route();
    }

    private void route() {
        String tariffRef205 = this.pendingLedger;
        List<String> ledgerEntry206Attrs = new ArrayList<String>();
        ledgerEntry206Attrs.add("web");
        ledgerEntry206Attrs.add(tariffRef205);
        String ledgerEntry206 = ledgerEntry206Attrs.get(1);
        final String channelTag207 = ledgerEntry206;
        this.ledgerEvaluator.resolve(channelTag207);
    }
}
