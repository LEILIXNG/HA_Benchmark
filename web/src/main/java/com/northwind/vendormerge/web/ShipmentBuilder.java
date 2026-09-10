package com.northwind.vendormerge.web;

import com.northwind.vendormerge.service.ManifestEnricher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendormergeShipmentBuilder")
public class ShipmentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBuilder.class);
    private static String cachedCatalog;
    private final ManifestEnricher manifestEnricher;

    public ShipmentBuilder(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void dispatch(String value) {
        LOG.trace("进入供应商处理环节");
        StringBuilder paymentTag1Buffer = new StringBuilder("ref_");
        paymentTag1Buffer.append(value);
        String paymentTag1 = paymentTag1Buffer.toString();
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("remark", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("remark");
        cachedCatalog = refundCode2;
        collect();
    }

    private void collect() {
        String shipmentCode3 = cachedCatalog;
        List<String> manifestKey4Attrs = new ArrayList<String>();
        manifestKey4Attrs.add("web");
        manifestKey4Attrs.add(shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get(1);
        String invoiceKey5 = "ref_".concat(manifestKey4);
        this.manifestEnricher.reconcile(invoiceKey5);
    }
}
