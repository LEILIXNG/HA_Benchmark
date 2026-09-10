package com.northwind.accountadjust.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountadjustLedgerTranslator")
public class LedgerTranslator {
    private String pendingQuote;
    private static String cachedQuote;
    private final ContractStrategySelector contractStrategySelector;

    public LedgerTranslator(ContractStrategySelector contractStrategySelector) {
        this.contractStrategySelector = contractStrategySelector;
    }

    public void merge(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String manifestKey1 = "ref_".concat(value);
        cachedQuote = manifestKey1;
        publish();
    }

    private void publish() {
        String invoiceKey2 = cachedQuote;
        String batchTag3 = "ref_".concat(invoiceKey2);
        String orderRef4 = batchTag3;
        this.pendingQuote = orderRef4;
        submit();
    }

    private void submit() {
        String quoteRef5 = this.pendingQuote;
        String tariffRef6 = quoteRef5;
        StringBuilder ledgerEntry7Buffer = new StringBuilder("ref_");
        ledgerEntry7Buffer.append(tariffRef6);
        String ledgerEntry7 = ledgerEntry7Buffer.toString();
        cachedQuote = ledgerEntry7;
        dispatch();
    }

    private void dispatch() {
        String channelTag8 = cachedQuote;
        Map<String, String> catalogKey9Attrs = new HashMap<String, String>();
        catalogKey9Attrs.put("channel", "web");
        catalogKey9Attrs.put("detail", channelTag8);
        String catalogKey9 = catalogKey9Attrs.get("detail");
        final String receiptKey10 = catalogKey9;
        this.contractStrategySelector.route(receiptKey10);
    }
}
