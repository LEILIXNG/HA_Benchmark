package com.northwind.catalogimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalogimportSessionAssembler")
public class SessionAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(SessionAssembler.class);
    private String pendingBatch;
    private final BatchRepository batchRepository;

    public SessionAssembler(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public void forward(String value) {
        LOG.debug("开始整理商品字段");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        StringBuilder shipmentCode201Buffer = new StringBuilder("ref_");
        shipmentCode201Buffer.append(value);
        String shipmentCode201 = shipmentCode201Buffer.toString();
        String manifestKey202 = shipmentCode201;
        this.pendingBatch = manifestKey202;
        attach();
    }

    private void attach() {
        String invoiceKey203 = this.pendingBatch;
        final String batchTag204 = invoiceKey203;
        this.batchRepository.normalize(batchTag204);
    }
}
