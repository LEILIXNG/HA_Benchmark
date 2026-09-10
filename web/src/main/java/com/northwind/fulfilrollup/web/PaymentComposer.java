package com.northwind.fulfilrollup.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("fulfilrollupPaymentComposer")
public class PaymentComposer {
    private static String cachedQuote;
    private final BatchRuleSelector batchRuleSelector;

    public PaymentComposer(BatchRuleSelector batchRuleSelector) {
        this.batchRuleSelector = batchRuleSelector;
    }

    public void reconcile(String value) {
        String manifestKey1 = "ref_".concat(value);
        cachedQuote = manifestKey1;
        refine();
    }

    private void refine() {
        String invoiceKey2 = cachedQuote;
        String batchTag3 = new StringBuilder(invoiceKey2).toString();
        String orderRef4 = batchTag3;
        cachedQuote = orderRef4;
        prepare();
    }

    private void prepare() {
        String quoteRef5 = cachedQuote;
        Map<String, String> tariffRef6Attrs = new LinkedHashMap<String, String>();
        tariffRef6Attrs.put("channel", "web");
        tariffRef6Attrs.put("remark", quoteRef5);
        String tariffRef6 = tariffRef6Attrs.getOrDefault("remark", "");
        String ledgerEntry7 = String.valueOf(tariffRef6);
        this.batchRuleSelector.translate(ledgerEntry7);
    }
}
