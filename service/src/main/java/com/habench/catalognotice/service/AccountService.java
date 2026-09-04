package com.habench.catalognotice.service;

import com.habench.catalognotice.dao.InvoiceAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private String pendingOrder;

    public static void collect(String value) {
        AccountService self = new AccountService();
        self.assemble(value);
    }

    private void assemble(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        this.pendingOrder = manifestKey102;
        refine();
    }

    private void refine() {
        String invoiceKey103 = this.pendingOrder;
        String batchTag104 = invoiceKey103;
        Map<String, String> orderRef105Attrs = new HashMap<String, String>();
        orderRef105Attrs.put("channel", "web");
        orderRef105Attrs.put("payload", batchTag104);
        String orderRef105 = orderRef105Attrs.get("payload");
        InvoiceAdapter.refine(orderRef105);
    }
}
