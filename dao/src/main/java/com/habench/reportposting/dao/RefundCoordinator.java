package com.habench.reportposting.dao;

import com.habench.reportposting.dao.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private String pendingManifest;

    public static void assemble(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.route(value);
    }

    private void route(String value) {
        String batchTag301 = "ref:" + value + ";";
        this.pendingManifest = batchTag301;
        attach();
    }

    private void attach() {
        String orderRef302 = this.pendingManifest;
        String quoteRef303 = "ref:" + orderRef302 + ";";
        Map<String, String> tariffRef304Attrs = new HashMap<String, String>();
        tariffRef304Attrs.put("channel", "web");
        tariffRef304Attrs.put("payload", quoteRef303);
        String tariffRef304 = tariffRef304Attrs.get("payload");
        ManifestRepository.submit(tariffRef304);
    }
}
