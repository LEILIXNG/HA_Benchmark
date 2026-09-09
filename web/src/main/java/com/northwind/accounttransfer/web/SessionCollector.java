package com.northwind.accounttransfer.web;

import com.northwind.accounttransfer.service.RefundComposer;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accounttransferSessionCollector")
public class SessionCollector {
    private String pendingChannel;
    private static String cachedChannel;
    private final RefundComposer refundComposer;

    public SessionCollector(RefundComposer refundComposer) {
        this.refundComposer = refundComposer;
    }

    public void expand(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        String refundCode101 = value;
        String shipmentCode102 = String.valueOf(refundCode101);
        cachedChannel = shipmentCode102;
        reconcile();
    }

    private void reconcile() {
        String manifestKey103 = cachedChannel;
        String invoiceKey104 = new StringBuilder(manifestKey103).toString();
        this.pendingChannel = invoiceKey104;
        stage();
    }

    private void stage() {
        String batchTag105 = this.pendingChannel;
        String orderRef106 = "ref:" + batchTag105 + ";";
        StringBuilder quoteRef107Buffer = new StringBuilder("ref:");
        quoteRef107Buffer.append(orderRef106).append(";");
        String quoteRef107 = quoteRef107Buffer.toString();
        this.refundComposer.assemble(quoteRef107);
    }
}
