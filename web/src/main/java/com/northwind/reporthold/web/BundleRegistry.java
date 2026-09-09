package com.northwind.reporthold.web;

import com.northwind.reporthold.service.ShipmentComposer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("reportholdBundleRegistry")
public class BundleRegistry {
    private final ShipmentComposer shipmentComposer;

    public BundleRegistry(ShipmentComposer shipmentComposer) {
        this.shipmentComposer = shipmentComposer;
    }

    public void normalize(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        String quoteRef2 = new StringBuilder(orderRef1).toString();
        this.shipmentComposer.attach(quoteRef2);
    }
}
