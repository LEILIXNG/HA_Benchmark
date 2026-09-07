package com.habench.vendorreopen.dao;

import com.habench.vendorreopen.dao.QuotePolicy;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {
    private String pendingAccount;
    private static String cachedAccount;

    public static void resolve(String value) {
        TariffFacade self = new TariffFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String refundCode301 = "ref:" + value + ";";
        String shipmentCode302 = refundCode301;
        cachedAccount = shipmentCode302;
        merge();
    }

    private void merge() {
        String manifestKey303 = cachedAccount;
        String invoiceKey304 = manifestKey303;
        this.pendingAccount = invoiceKey304;
        route();
    }

    private void route() {
        String batchTag305 = this.pendingAccount;
        Map<String, String> orderRef306Attrs = new HashMap<String, String>();
        orderRef306Attrs.put("channel", "web");
        orderRef306Attrs.put("payload", batchTag305);
        String orderRef306 = orderRef306Attrs.get("payload");
        QuotePolicy.expand(orderRef306);
    }
}
