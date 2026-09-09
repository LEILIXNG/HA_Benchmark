package com.northwind.accountintake.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 账户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("accountintakeQuoteResolver")
public class QuoteResolver {
    private static String cachedChannel;

    public void enrich(String value) {
        String orderRef201 = "ref:" + value + ";";
        String quoteRef202 = new StringBuilder(orderRef201).toString();
        cachedChannel = quoteRef202;
        translate();
    }

    private void translate() {
        String tariffRef203 = cachedChannel;
        List<String> ledgerEntry204Attrs = new ArrayList<String>();
        ledgerEntry204Attrs.add("web");
        ledgerEntry204Attrs.add(tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get(1);
        AccountPolicySelector.prepare(ledgerEntry204);
    }
}
