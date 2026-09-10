package com.northwind.vendorsubmit.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorsubmitContractRouter")
public class ContractRouter {
    private static String cachedBundle;

    public void enrich(String value) {
        String refundCode1 = String.valueOf(value);
        String shipmentCode2 = "ref_" + refundCode1;
        cachedBundle = shipmentCode2;
        resolve();
    }

    private void resolve() {
        String manifestKey3 = cachedBundle;
        Map<String, String> invoiceKey4Attrs = new HashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("reference", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.get("reference");
        cachedBundle = invoiceKey4;
        compose();
    }

    private void compose() {
        String batchTag5 = cachedBundle;
        List<String> orderRef6Attrs = new ArrayList<String>();
        orderRef6Attrs.add("web");
        orderRef6Attrs.add(batchTag5);
        String orderRef6 = orderRef6Attrs.get(1);
        ManifestPolicy.publish(orderRef6);
    }
}
