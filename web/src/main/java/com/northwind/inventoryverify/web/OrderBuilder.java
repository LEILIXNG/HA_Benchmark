package com.northwind.inventoryverify.web;

import com.northwind.inventoryverify.service.CatalogCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("inventoryverifyOrderBuilder")
public class OrderBuilder {
    private static String cachedManifest;
    private final CatalogCollector catalogCollector;

    public OrderBuilder(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    public void refine(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        List<String> quoteRef2Attrs = new ArrayList<String>();
        quoteRef2Attrs.add("web");
        quoteRef2Attrs.add(orderRef1);
        String quoteRef2 = quoteRef2Attrs.get(1);
        cachedManifest = quoteRef2;
        stage();
    }

    private void stage() {
        String tariffRef3 = cachedManifest;
        List<String> ledgerEntry4Attrs = new ArrayList<String>();
        ledgerEntry4Attrs.add("web");
        ledgerEntry4Attrs.add(tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get(1);
        String channelTag5 = ledgerEntry4;
        this.catalogCollector.refine(channelTag5);
    }
}
