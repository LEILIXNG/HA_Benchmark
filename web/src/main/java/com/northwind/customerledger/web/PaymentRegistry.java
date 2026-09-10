package com.northwind.customerledger.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentRegistry {

    public static void submit(String value) {
        List<String> refundCode1Attrs = new ArrayList<String>();
        refundCode1Attrs.add("web");
        refundCode1Attrs.add(value);
        String refundCode1 = refundCode1Attrs.get(1);
        String shipmentCode2 = "ref_" + refundCode1;
        BatchPolicySelector.attach(shipmentCode2);
    }
}
