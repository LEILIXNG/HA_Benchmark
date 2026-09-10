package com.northwind.billingtrace.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentFacade {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        PaymentFacade self = new PaymentFacade();
        self.resolve(value);
    }

    private void resolve(String value) {
        String invoiceKey101 = new StringBuilder(value).toString();
        cachedBundle = invoiceKey101;
        normalize();
    }

    private void normalize() {
        String batchTag102 = cachedBundle;
        String orderRef103 = new StringBuilder(batchTag102).toString();
        this.pendingBundle = orderRef103;
        merge();
    }

    private void merge() {
        String quoteRef104 = this.pendingBundle;
        Map<String, String> tariffRef105Attrs = new HashMap<String, String>();
        tariffRef105Attrs.put("channel", "web");
        tariffRef105Attrs.put("detail", quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get("detail");
        cachedBundle = tariffRef105;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry106 = cachedBundle;
        StringBuilder channelTag107Buffer = new StringBuilder("ref_");
        channelTag107Buffer.append(ledgerEntry106);
        String channelTag107 = channelTag107Buffer.toString();
        String catalogKey108 = new StringBuilder(channelTag107).toString();
        OrderPlanSelector.translate(catalogKey108);
    }
}
