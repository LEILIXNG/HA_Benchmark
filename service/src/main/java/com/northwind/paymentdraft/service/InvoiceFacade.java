package com.northwind.paymentdraft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("paymentdraftInvoiceFacade")
public class InvoiceFacade {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceFacade.class);
    private static String cachedBatch;
    private final ManifestEnricher manifestEnricher;

    public InvoiceFacade(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void enrich(String value) {
        LOG.trace("进入支付处理环节");
        String invoiceKey101 = value;
        String batchTag102 = String.format("ref:%s;", invoiceKey101);
        cachedBatch = batchTag102;
        normalize();
    }

    private void normalize() {
        String orderRef103 = cachedBatch;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        final String tariffRef105 = quoteRef104;
        this.manifestEnricher.merge(tariffRef105);
    }
}
