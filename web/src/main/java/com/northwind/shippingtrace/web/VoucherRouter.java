package com.northwind.shippingtrace.web;

import com.northwind.shippingtrace.service.RefundPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherRouter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRouter.class);
    private String pendingBatch;
    private static String cachedBatch;

    public static void enrich(String value) {
        LOG.trace("进入发运处理环节");
        VoucherRouter self = new VoucherRouter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String accountRef1 = String.valueOf(value);
        String voucherRef2 = String.format("ref_%s", accountRef1);
        this.pendingBatch = voucherRef2;
        normalize();
    }

    private void normalize() {
        String paymentTag3 = this.pendingBatch;
        String refundCode4 = "ref_" + paymentTag3;
        cachedBatch = refundCode4;
        translate();
    }

    private void translate() {
        String shipmentCode5 = cachedBatch;
        final String manifestKey6 = shipmentCode5;
        StringBuilder invoiceKey7Buffer = new StringBuilder("ref_");
        invoiceKey7Buffer.append(manifestKey6);
        String invoiceKey7 = invoiceKey7Buffer.toString();
        this.pendingBatch = invoiceKey7;
        merge();
    }

    private void merge() {
        String batchTag8 = this.pendingBatch;
        String orderRef9 = String.format("ref_%s", batchTag8);
        String quoteRef10 = orderRef9;
        RefundPolicy.dispatch(quoteRef10);
    }
}
