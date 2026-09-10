package com.northwind.inventoryrollup.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class QuoteAssembler {
    private String pendingAccount;
    private static String cachedAccount;

    public static void route(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.attach(value);
    }

    private void attach(String value) {
        String shipmentCode201 = new StringBuilder(value).toString();
        String manifestKey202 = "ref_" + shipmentCode201;
        cachedAccount = manifestKey202;
        assemble();
    }

    private void assemble() {
        String invoiceKey203 = cachedAccount;
        String batchTag204 = String.format("ref_%s", invoiceKey203);
        Map<String, String> orderRef205Attrs = new HashMap<String, String>();
        orderRef205Attrs.put("channel", "web");
        orderRef205Attrs.put("detail", batchTag204);
        String orderRef205 = orderRef205Attrs.get("detail");
        this.pendingAccount = orderRef205;
        collect();
    }

    private void collect() {
        String quoteRef206 = this.pendingAccount;
        String tariffRef207 = String.valueOf(quoteRef206);
        cachedAccount = tariffRef207;
        resolve();
    }

    private void resolve() {
        String ledgerEntry208 = cachedAccount;
        final String channelTag209 = ledgerEntry208;
        String catalogKey210 = channelTag209;
        LedgerValidator.collect(catalogKey210);
    }
}
