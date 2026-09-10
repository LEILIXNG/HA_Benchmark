package com.northwind.pricingadjust.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingadjustCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private static String cachedSession;
    private final ManifestCoordinator manifestCoordinator;

    public CatalogBroker(ManifestCoordinator manifestCoordinator) {
        this.manifestCoordinator = manifestCoordinator;
    }

    public void stage(String value) {
        LOG.trace("进入定价处理环节");
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.get("detail");
        String tariffRef202 = "ref_" + quoteRef201;
        cachedSession = tariffRef202;
        compose();
    }

    private void compose() {
        String ledgerEntry203 = cachedSession;
        String channelTag204 = String.valueOf(ledgerEntry203);
        Map<String, String> catalogKey205Attrs = new LinkedHashMap<String, String>();
        catalogKey205Attrs.put("channel", "web");
        catalogKey205Attrs.put("detail", channelTag204);
        String catalogKey205 = catalogKey205Attrs.getOrDefault("detail", "");
        this.manifestCoordinator.dispatch(catalogKey205);
    }
}
