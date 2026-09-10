package com.northwind.fulfilrenewal.web;

import com.northwind.fulfilrenewal.service.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilrenewalContractService")
public class ContractService {
    private String pendingContract;
    private final CatalogCoordinator catalogCoordinator;

    public ContractService(CatalogCoordinator catalogCoordinator) {
        this.catalogCoordinator = catalogCoordinator;
    }

    public void forward(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("detail", value);
        String catalogKey101 = catalogKey101Attrs.get("detail");
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("remark", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("remark");
        this.pendingContract = receiptKey102;
        reconcile();
    }

    private void reconcile() {
        String accountRef103 = this.pendingContract;
        String voucherRef104 = new StringBuilder(accountRef103).toString();
        String paymentTag105 = "ref_".concat(voucherRef104);
        this.catalogCoordinator.assemble(paymentTag105);
    }
}
