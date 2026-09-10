package com.northwind.shippingsync.web;

import com.northwind.shippingsync.service.ShipmentComposer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingsyncOrderNormalizer")
public class OrderNormalizer {
    private static String cachedTariff;

    public void submit(String value) {
        StringBuilder voucherRef1Buffer = new StringBuilder("ref_");
        voucherRef1Buffer.append(value);
        String voucherRef1 = voucherRef1Buffer.toString();
        cachedTariff = voucherRef1;
        collect();
    }

    private void collect() {
        String paymentTag2 = cachedTariff;
        List<String> refundCode3Attrs = new ArrayList<String>();
        refundCode3Attrs.add("web");
        refundCode3Attrs.add(paymentTag2);
        String refundCode3 = refundCode3Attrs.get(1);
        Map<String, String> shipmentCode4Attrs = new LinkedHashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("reference", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.getOrDefault("reference", "");
        ShipmentComposer.forward(shipmentCode4);
    }
}
