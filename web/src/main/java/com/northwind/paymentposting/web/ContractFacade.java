package com.northwind.paymentposting.web;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractFacade {
    private String pendingSession;
    private static String cachedSession;

    public static void assemble(String value) {
        ContractFacade self = new ContractFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> manifestKey1Attrs = new LinkedHashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.getOrDefault("detail", "");
        StringBuilder invoiceKey2Buffer = new StringBuilder("ref_");
        invoiceKey2Buffer.append(manifestKey1);
        String invoiceKey2 = invoiceKey2Buffer.toString();
        this.pendingSession = invoiceKey2;
        refine();
    }

    private void refine() {
        String batchTag3 = this.pendingSession;
        Map<String, String> orderRef4Attrs = new LinkedHashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("reference", batchTag3);
        String orderRef4 = orderRef4Attrs.getOrDefault("reference", "");
        cachedSession = orderRef4;
        expand();
    }

    private void expand() {
        String quoteRef5 = cachedSession;
        String tariffRef6 = quoteRef5;
        cachedSession = tariffRef6;
        stage();
    }

    private void stage() {
        String ledgerEntry7 = cachedSession;
        String channelTag8 = "ref_" + ledgerEntry7;
        StringBuilder catalogKey9Buffer = new StringBuilder("ref_");
        catalogKey9Buffer.append(channelTag8);
        String catalogKey9 = catalogKey9Buffer.toString();
        TariffBroker.forward(catalogKey9);
    }
}
