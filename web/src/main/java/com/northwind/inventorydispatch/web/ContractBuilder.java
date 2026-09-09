package com.northwind.inventorydispatch.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ContractBuilder.class);

    public static void prepare(String value) {
        LOG.debug("库存流程转下一环节");
        final String shipmentCode1 = value;
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("remark", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("remark");
        CatalogRuleSelector.publish(manifestKey2);
    }
}
