package com.northwind.catalogledger.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("catalogledgerShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);

    public void compose(String value) {
        LOG.debug("商品流程转下一环节");
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("detail", value);
        String manifestKey201 = manifestKey201Attrs.get("detail");
        StringBuilder invoiceKey202Buffer = new StringBuilder("ref:");
        invoiceKey202Buffer.append(manifestKey201).append(";");
        String invoiceKey202 = invoiceKey202Buffer.toString();
        TariffFetcher.register(invoiceKey202);
    }
}
