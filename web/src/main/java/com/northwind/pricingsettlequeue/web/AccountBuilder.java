package com.northwind.pricingsettlequeue.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 定价主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountBuilder {
    private static String cachedCatalog;

    public static void publish(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref_" + invoiceKey101;
        cachedCatalog = batchTag102;
        forward();
    }

    private static void forward() {
        String orderRef103 = cachedCatalog;
        List<String> quoteRef104Attrs = new ArrayList<String>();
        quoteRef104Attrs.add("web");
        quoteRef104Attrs.add(orderRef103);
        String quoteRef104 = quoteRef104Attrs.get(1);
        cachedCatalog = quoteRef104;
        merge();
    }

    private static void merge() {
        String tariffRef105 = cachedCatalog;
        String ledgerEntry106 = String.format("ref_%s", tariffRef105);
        VoucherPolicySelector.forward(ledgerEntry106);
    }
}
