package com.northwind.reportbind.web;

import com.northwind.reportbind.service.LedgerNormalizer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportbindRefundCoordinator")
public class RefundCoordinator {
    private String pendingContract;
    private final LedgerNormalizer ledgerNormalizer;

    public RefundCoordinator(LedgerNormalizer ledgerNormalizer) {
        this.ledgerNormalizer = ledgerNormalizer;
    }

    public void assemble(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        String manifestKey1 = String.valueOf(value);
        this.pendingContract = manifestKey1;
        prepare();
    }

    private void prepare() {
        String invoiceKey2 = this.pendingContract;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("note", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("note");
        this.pendingContract = batchTag3;
        resolve();
    }

    private void resolve() {
        String orderRef4 = this.pendingContract;
        String quoteRef5 = new StringBuilder(orderRef4).toString();
        this.pendingContract = quoteRef5;
        enrich();
    }

    private void enrich() {
        String tariffRef6 = this.pendingContract;
        String ledgerEntry7 = new StringBuilder(tariffRef6).toString();
        String channelTag8 = String.valueOf(ledgerEntry7);
        this.ledgerNormalizer.refine(channelTag8);
    }
}
