package com.northwind.shippingsettle.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("shippingsettleBundleNormalizer")
public class BundleNormalizer {
    private String pendingTariff;
    private static String cachedTariff;

    public void submit(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        StringBuilder tariffRef1Buffer = new StringBuilder("ref_");
        tariffRef1Buffer.append(value);
        String tariffRef1 = tariffRef1Buffer.toString();
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("remark", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("remark");
        cachedTariff = ledgerEntry2;
        collect();
    }

    private void collect() {
        String channelTag3 = cachedTariff;
        String catalogKey4 = String.format("ref_%s", channelTag3);
        this.pendingTariff = catalogKey4;
        attach();
    }

    private void attach() {
        String receiptKey5 = this.pendingTariff;
        Map<String, String> accountRef6Attrs = new LinkedHashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("remark", receiptKey5);
        String accountRef6 = accountRef6Attrs.getOrDefault("remark", "");
        ManifestValidator.attach(accountRef6);
    }
}
