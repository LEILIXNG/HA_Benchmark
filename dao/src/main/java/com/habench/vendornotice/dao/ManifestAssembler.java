package com.habench.vendornotice.dao;

import com.habench.vendornotice.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {
    private String pendingContract;
    private static String cachedContract;

    public static void translate(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.normalize(value);
    }

    private void normalize(String value) {
        String voucherRef301 = value;
        String paymentTag302 = voucherRef301;
        cachedContract = paymentTag302;
        refine();
    }

    private void refine() {
        String refundCode303 = cachedContract;
        Map<String, String> shipmentCode304Attrs = new HashMap<String, String>();
        shipmentCode304Attrs.put("channel", "web");
        shipmentCode304Attrs.put("payload", refundCode303);
        String shipmentCode304 = shipmentCode304Attrs.get("payload");
        this.pendingContract = shipmentCode304;
        stage();
    }

    private void stage() {
        String manifestKey305 = this.pendingContract;
        String invoiceKey306 = "ref:" + manifestKey305 + ";";
        ContractRepository.expand(invoiceKey306);
    }
}
