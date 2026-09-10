package com.northwind.billingrevise.service;

import com.northwind.billingrevise.dao.CatalogRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderCollector {

    public static void merge(String value) {
        String paymentTag101 = String.format("ref_%s", value);
        List<String> refundCode102Attrs = new ArrayList<String>();
        refundCode102Attrs.add("web");
        refundCode102Attrs.add(paymentTag101);
        String refundCode102 = refundCode102Attrs.get(1);
        CatalogRegistry.reconcile(refundCode102);
    }
}
