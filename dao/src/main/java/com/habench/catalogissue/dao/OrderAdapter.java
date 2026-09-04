package com.habench.catalogissue.dao;

import com.habench.catalogissue.dao.RefundValidator;
import java.util.HashMap;
import java.util.Map;

public final class OrderAdapter {
    private static String cachedTariff;

    public static void publish(String value) {
        Map<String, String> batchTag501Attrs = new HashMap<String, String>();
        batchTag501Attrs.put("channel", "web");
        batchTag501Attrs.put("payload", value);
        String batchTag501 = batchTag501Attrs.get("payload");
        cachedTariff = batchTag501;
        collect();
    }

    private static void collect() {
        String orderRef502 = cachedTariff;
        String quoteRef503 = "ref:" + orderRef502 + ";";
        String tariffRef504 = "ref:" + quoteRef503 + ";";
        cachedTariff = tariffRef504;
        merge();
    }

    private static void merge() {
        String ledgerEntry505 = cachedTariff;
        Map<String, String> channelTag506Attrs = new HashMap<String, String>();
        channelTag506Attrs.put("channel", "web");
        channelTag506Attrs.put("payload", ledgerEntry505);
        String channelTag506 = channelTag506Attrs.get("payload");
        Map<String, String> catalogKey507Attrs = new HashMap<String, String>();
        catalogKey507Attrs.put("channel", "web");
        catalogKey507Attrs.put("payload", channelTag506);
        String catalogKey507 = catalogKey507Attrs.get("payload");
        cachedTariff = catalogKey507;
        resolve();
    }

    private static void resolve() {
        String receiptKey508 = cachedTariff;
        Map<String, String> accountRef509Attrs = new HashMap<String, String>();
        accountRef509Attrs.put("channel", "web");
        accountRef509Attrs.put("payload", receiptKey508);
        String accountRef509 = accountRef509Attrs.get("payload");
        RefundValidator.route(accountRef509);
    }
}
