package com.northwind.paymentarchive.web;

import com.northwind.paymentarchive.service.BundleResolver;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 面向支付场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleAssembler {
    private String pendingSession;
    private static String cachedSession;

    public static void translate(String value) {
        BundleAssembler self = new BundleAssembler();
        self.route(value);
    }

    private void route(String value) {
        String invoiceKey1 = String.valueOf(value);
        cachedSession = invoiceKey1;
        submit();
    }

    private void submit() {
        String batchTag2 = cachedSession;
        List<String> orderRef3Attrs = new ArrayList<String>();
        orderRef3Attrs.add("web");
        orderRef3Attrs.add(batchTag2);
        String orderRef3 = orderRef3Attrs.get(1);
        this.pendingSession = orderRef3;
        register();
    }

    private void register() {
        String quoteRef4 = this.pendingSession;
        Map<String, String> tariffRef5Attrs = new LinkedHashMap<String, String>();
        tariffRef5Attrs.put("channel", "web");
        tariffRef5Attrs.put("detail", quoteRef4);
        String tariffRef5 = tariffRef5Attrs.getOrDefault("detail", "");
        String ledgerEntry6 = String.format("ref:%s;", tariffRef5);
        this.pendingSession = ledgerEntry6;
        refine();
    }

    private void refine() {
        String channelTag7 = this.pendingSession;
        StringBuilder catalogKey8Buffer = new StringBuilder("ref:");
        catalogKey8Buffer.append(channelTag7).append(";");
        String catalogKey8 = catalogKey8Buffer.toString();
        String receiptKey9 = catalogKey8;
        BundleResolver.normalize(receiptKey9);
    }
}
