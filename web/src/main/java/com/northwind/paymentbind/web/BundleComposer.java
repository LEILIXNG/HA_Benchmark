package com.northwind.paymentbind.web;

import com.northwind.paymentbind.service.ContractScreen;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleComposer {
    private static String cachedSession;

    public static void merge(String value) {
        List<String> shipmentCode1Attrs = new ArrayList<String>();
        shipmentCode1Attrs.add("web");
        shipmentCode1Attrs.add(value);
        String shipmentCode1 = shipmentCode1Attrs.get(1);
        String manifestKey2 = shipmentCode1;
        cachedSession = manifestKey2;
        expand();
    }

    private static void expand() {
        String invoiceKey3 = cachedSession;
        String batchTag4 = "ref:".concat(invoiceKey3).concat(";");
        ContractScreen.resolve(batchTag4);
    }
}
