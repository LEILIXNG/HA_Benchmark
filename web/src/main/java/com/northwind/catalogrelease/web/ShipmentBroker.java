package com.northwind.catalogrelease.web;

import com.northwind.catalogrelease.service.ContractCoordinator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogreleaseShipmentBroker")
public class ShipmentBroker {
    private String pendingInvoice;
    private final ContractCoordinator contractCoordinator;

    public ShipmentBroker(ContractCoordinator contractCoordinator) {
        this.contractCoordinator = contractCoordinator;
    }

    public void enrich(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("remark", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("remark");
        this.pendingInvoice = ledgerEntry2;
        prepare();
    }

    private void prepare() {
        String channelTag3 = this.pendingInvoice;
        StringBuilder catalogKey4Buffer = new StringBuilder("ref_");
        catalogKey4Buffer.append(channelTag3);
        String catalogKey4 = catalogKey4Buffer.toString();
        Map<String, String> receiptKey5Attrs = new LinkedHashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("detail", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.getOrDefault("detail", "");
        this.contractCoordinator.translate(receiptKey5);
    }
}
