package com.northwind.inventorymerge.web;

import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorymergeContractResolver")
public class ContractResolver {
    private String pendingOrder;
    private static String cachedOrder;
    private final TariffPolicySelector tariffPolicySelector;

    public ContractResolver(TariffPolicySelector tariffPolicySelector) {
        this.tariffPolicySelector = tariffPolicySelector;
    }

    public void resolve(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String refundCode1 = "ref:" + value + ";";
        StringBuilder shipmentCode2Buffer = new StringBuilder("ref:");
        shipmentCode2Buffer.append(refundCode1).append(";");
        String shipmentCode2 = shipmentCode2Buffer.toString();
        this.pendingOrder = shipmentCode2;
        stage();
    }

    private void stage() {
        String manifestKey3 = this.pendingOrder;
        String invoiceKey4 = new StringBuilder(manifestKey3).toString();
        final String batchTag5 = invoiceKey4;
        cachedOrder = batchTag5;
        normalize();
    }

    private void normalize() {
        String orderRef6 = cachedOrder;
        String quoteRef7 = String.format("ref:%s;", orderRef6);
        this.tariffPolicySelector.compose(quoteRef7);
    }
}
