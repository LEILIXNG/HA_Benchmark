package com.northwind.paymentsubmit.service;

import com.northwind.paymentsubmit.dao.BatchEnricher;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("paymentsubmitBatchEnricher2")
public class BatchEnricher2 {
    private static String cachedSession;
    private final BatchEnricher batchEnricher;

    public BatchEnricher2(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    public void reconcile(String value) {
        String invoiceKey101 = value;
        cachedSession = invoiceKey101;
        merge();
    }

    private void merge() {
        String batchTag102 = cachedSession;
        String orderRef103 = "ref_".concat(batchTag102);
        cachedSession = orderRef103;
        translate();
    }

    private void translate() {
        String quoteRef104 = cachedSession;
        StringBuilder tariffRef105Buffer = new StringBuilder("ref_");
        tariffRef105Buffer.append(quoteRef104);
        String tariffRef105 = tariffRef105Buffer.toString();
        this.batchEnricher.stage(tariffRef105);
    }
}
