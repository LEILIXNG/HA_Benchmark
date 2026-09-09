package com.northwind.inventoryverify.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventoryverifyRefundComposer")
public class RefundComposer {
    private static final Logger LOG = LoggerFactory.getLogger(RefundComposer.class);
    private static String cachedManifest;

    public void submit(String value) {
        LOG.debug("库存流程转下一环节");
        Map<String, String> orderRef301Attrs = new LinkedHashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.getOrDefault("detail", "");
        List<String> quoteRef302Attrs = new ArrayList<String>();
        quoteRef302Attrs.add("web");
        quoteRef302Attrs.add(orderRef301);
        String quoteRef302 = quoteRef302Attrs.get(1);
        cachedManifest = quoteRef302;
        compose();
    }

    private void compose() {
        String tariffRef303 = cachedManifest;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("reference", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("reference");
        OrderScreen.compose(ledgerEntry304);
    }
}
