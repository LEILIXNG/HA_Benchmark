package com.northwind.customerreopen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerreopenTariffEnricher")
public class TariffEnricher {
    private String pendingTariff;
    private static String cachedTariff;
    private final VoucherScreen voucherScreen;

    public TariffEnricher(VoucherScreen voucherScreen) {
        this.voucherScreen = voucherScreen;
    }

    public void normalize(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        StringBuilder orderRef301Buffer = new StringBuilder("ref:");
        orderRef301Buffer.append(value).append(";");
        String orderRef301 = orderRef301Buffer.toString();
        String quoteRef302 = "ref:" + orderRef301 + ";";
        cachedTariff = quoteRef302;
        collect();
    }

    private void collect() {
        String tariffRef303 = cachedTariff;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("reference", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("reference");
        Map<String, String> channelTag305Attrs = new LinkedHashMap<String, String>();
        channelTag305Attrs.put("channel", "web");
        channelTag305Attrs.put("detail", ledgerEntry304);
        String channelTag305 = channelTag305Attrs.getOrDefault("detail", "");
        this.pendingTariff = channelTag305;
        translate();
    }

    private void translate() {
        String catalogKey306 = this.pendingTariff;
        List<String> receiptKey307Attrs = new ArrayList<String>();
        receiptKey307Attrs.add("web");
        receiptKey307Attrs.add(catalogKey306);
        String receiptKey307 = receiptKey307Attrs.get(1);
        this.voucherScreen.collect(receiptKey307);
    }
}
