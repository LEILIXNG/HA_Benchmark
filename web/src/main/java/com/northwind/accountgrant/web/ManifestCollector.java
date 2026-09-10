package com.northwind.accountgrant.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountgrantManifestCollector")
public class ManifestCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCollector.class);
    private String pendingTariff;
    private static String cachedTariff;

    public void refine(String value) {
        LOG.debug("账户流程转下一环节");
        this.compose(value);
    }

    private void compose(String value) {
        StringBuilder paymentTag1Buffer = new StringBuilder("ref_");
        paymentTag1Buffer.append(value);
        String paymentTag1 = paymentTag1Buffer.toString();
        final String refundCode2 = paymentTag1;
        this.pendingTariff = refundCode2;
        attach();
    }

    private void attach() {
        String shipmentCode3 = this.pendingTariff;
        List<String> manifestKey4Attrs = new ArrayList<String>();
        manifestKey4Attrs.add("web");
        manifestKey4Attrs.add(shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get(1);
        cachedTariff = manifestKey4;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey5 = cachedTariff;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("remark", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("remark");
        TariffRepository.enrich(batchTag6);
    }
}
