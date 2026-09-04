package com.habench.accountdigest.web;

import com.habench.accountdigest.web.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {
    private static String cachedPayment;

    public static void register(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        cachedPayment = ledgerEntry2;
        refine();
    }

    private static void refine() {
        String channelTag3 = cachedPayment;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        cachedPayment = catalogKey4;
        merge();
    }

    private static void merge() {
        String receiptKey5 = cachedPayment;
        String accountRef6 = "ref:" + receiptKey5 + ";";
        String voucherRef7 = "ref:" + accountRef6 + ";";
        cachedPayment = voucherRef7;
        forward();
    }

    private static void forward() {
        String paymentTag8 = cachedPayment;
        Map<String, String> refundCode9Attrs = new HashMap<String, String>();
        refundCode9Attrs.put("channel", "web");
        refundCode9Attrs.put("payload", paymentTag8);
        String refundCode9 = refundCode9Attrs.get("payload");
        String shipmentCode10 = "ref:" + refundCode9 + ";";
        cachedPayment = shipmentCode10;
        assemble();
    }

    private static void assemble() {
        String manifestKey11 = cachedPayment;
        String invoiceKey12 = "ref:" + manifestKey11 + ";";
        String batchTag13 = invoiceKey12;
        ManifestRouter.dispatch(batchTag13);
    }
}
