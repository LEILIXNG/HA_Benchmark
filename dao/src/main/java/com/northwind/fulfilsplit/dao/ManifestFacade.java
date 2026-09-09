package com.northwind.fulfilsplit.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("fulfilsplitManifestFacade")
public class ManifestFacade {
    private String pendingBatch;
    private final ReceiptBuilder receiptBuilder;

    public ManifestFacade(ReceiptBuilder receiptBuilder) {
        this.receiptBuilder = receiptBuilder;
    }

    public void route(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        StringBuilder accountRef201Buffer = new StringBuilder("ref:");
        accountRef201Buffer.append(value).append(";");
        String accountRef201 = accountRef201Buffer.toString();
        List<String> voucherRef202Attrs = new ArrayList<String>();
        voucherRef202Attrs.add("web");
        voucherRef202Attrs.add(accountRef201);
        String voucherRef202 = voucherRef202Attrs.get(1);
        this.pendingBatch = voucherRef202;
        forward();
    }

    private void forward() {
        String paymentTag203 = this.pendingBatch;
        String refundCode204 = String.format("ref:%s;", paymentTag203);
        final String shipmentCode205 = refundCode204;
        this.receiptBuilder.assemble(shipmentCode205);
    }
}
