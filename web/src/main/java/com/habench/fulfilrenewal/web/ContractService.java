package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.service.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {
    private String pendingContract;

    public static void forward(String value) {
        ContractService self = new ContractService();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        this.pendingContract = receiptKey102;
        reconcile();
    }

    private void reconcile() {
        String accountRef103 = this.pendingContract;
        String voucherRef104 = accountRef103;
        String paymentTag105 = "ref:" + voucherRef104 + ";";
        CatalogCoordinator.assemble(paymentTag105);
    }
}
