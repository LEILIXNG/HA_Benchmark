package com.northwind.billingreopen.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("billingreopenTariffTranslator")
public class TariffTranslator {
    private final BundleValidator bundleValidator;

    public TariffTranslator(BundleValidator bundleValidator) {
        this.bundleValidator = bundleValidator;
    }

    public void publish(String value) {
        Map<String, String> refundCode401Attrs = new LinkedHashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("detail", value);
        String refundCode401 = refundCode401Attrs.getOrDefault("detail", "");
        List<String> shipmentCode402Attrs = new ArrayList<String>();
        shipmentCode402Attrs.add("web");
        shipmentCode402Attrs.add(refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get(1);
        this.bundleValidator.submit(shipmentCode402);
    }
}
