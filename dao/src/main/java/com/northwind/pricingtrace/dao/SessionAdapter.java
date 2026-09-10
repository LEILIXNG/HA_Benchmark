package com.northwind.pricingtrace.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("pricingtraceSessionAdapter")
public class SessionAdapter {
    private String pendingTariff;
    private static String cachedTariff;
    private final TariffGateway tariffGateway;

    public SessionAdapter(TariffGateway tariffGateway) {
        this.tariffGateway = tariffGateway;
    }

    public void attach(String value) {
        this.dispatch(value);
    }

    private void dispatch(String value) {
        final String channelTag301 = value;
        String catalogKey302 = String.format("ref_%s", channelTag301);
        this.pendingTariff = catalogKey302;
        enrich();
    }

    private void enrich() {
        String receiptKey303 = this.pendingTariff;
        Map<String, String> accountRef304Attrs = new HashMap<String, String>();
        accountRef304Attrs.put("channel", "web");
        accountRef304Attrs.put("reference", receiptKey303);
        String accountRef304 = accountRef304Attrs.get("reference");
        cachedTariff = accountRef304;
        expand();
    }

    private void expand() {
        String voucherRef305 = cachedTariff;
        String paymentTag306 = "ref_" + voucherRef305;
        Map<String, String> refundCode307Attrs = new LinkedHashMap<String, String>();
        refundCode307Attrs.put("channel", "web");
        refundCode307Attrs.put("note", paymentTag306);
        String refundCode307 = refundCode307Attrs.getOrDefault("note", "");
        this.tariffGateway.translate(refundCode307);
    }
}
