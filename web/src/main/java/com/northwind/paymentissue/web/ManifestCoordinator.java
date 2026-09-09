package com.northwind.paymentissue.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentissueManifestCoordinator")
public class ManifestCoordinator {
    private String pendingTariff;
    private final BatchService batchService;

    public ManifestCoordinator(BatchService batchService) {
        this.batchService = batchService;
    }

    public void publish(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> paymentTag1Attrs = new LinkedHashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("detail", value);
        String paymentTag1 = paymentTag1Attrs.getOrDefault("detail", "");
        this.pendingTariff = paymentTag1;
        submit();
    }

    private void submit() {
        String refundCode2 = this.pendingTariff;
        List<String> shipmentCode3Attrs = new ArrayList<String>();
        shipmentCode3Attrs.add("web");
        shipmentCode3Attrs.add(refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get(1);
        List<String> manifestKey4Attrs = new ArrayList<String>();
        manifestKey4Attrs.add("web");
        manifestKey4Attrs.add(shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get(1);
        this.batchService.refine(manifestKey4);
    }
}
