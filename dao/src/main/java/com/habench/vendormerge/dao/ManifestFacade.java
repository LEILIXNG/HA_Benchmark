package com.habench.vendormerge.dao;

import com.habench.vendormerge.dao.TariffFacade;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {
    private String pendingBatch;

    public static void route(String value) {
        ManifestFacade self = new ManifestFacade();
        self.resolve(value);
    }

    private void resolve(String value) {
        String accountRef201 = "ref:" + value + ";";
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        this.pendingBatch = voucherRef202;
        forward();
    }

    private void forward() {
        String paymentTag203 = this.pendingBatch;
        String refundCode204 = "ref:" + paymentTag203 + ";";
        String shipmentCode205 = refundCode204;
        TariffFacade.assemble(shipmentCode205);
    }
}
