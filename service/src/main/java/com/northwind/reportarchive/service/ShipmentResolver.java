package com.northwind.reportarchive.service;

import com.northwind.reportarchive.dao.ManifestTranslator;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportarchiveShipmentResolver")
public class ShipmentResolver {
    private static String cachedSession;

    public void enrich(String value) {
        String tariffRef101 = String.valueOf(value);
        cachedSession = tariffRef101;
        publish();
    }

    private void publish() {
        String ledgerEntry102 = cachedSession;
        String channelTag103 = "ref:".concat(ledgerEntry102).concat(";");
        String catalogKey104 = "ref:" + channelTag103 + ";";
        ManifestTranslator.forward(catalogKey104);
    }
}
