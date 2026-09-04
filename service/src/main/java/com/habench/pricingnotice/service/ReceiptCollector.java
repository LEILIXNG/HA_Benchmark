package com.habench.pricingnotice.service;

import com.habench.pricingnotice.dao.AccountEnricher;

public final class ReceiptCollector {

    public static void publish(String value) {
        String quoteRef501 = "ref:" + value + ";";
        String tariffRef502 = quoteRef501;
        AccountEnricher.submit(tariffRef502);
    }
}
