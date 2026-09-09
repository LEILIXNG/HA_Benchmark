package com.northwind.paymenttrace.web;

import com.northwind.paymenttrace.service.VoucherCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymenttraceBatchBroker")
public class BatchBroker {
    private static final Logger LOG = LoggerFactory.getLogger(BatchBroker.class);
    private final VoucherCoordinator voucherCoordinator;

    public BatchBroker(VoucherCoordinator voucherCoordinator) {
        this.voucherCoordinator = voucherCoordinator;
    }

    public void expand(String value) {
        LOG.debug("开始整理支付字段");
        StringBuilder invoiceKey101Buffer = new StringBuilder("ref:");
        invoiceKey101Buffer.append(value).append(";");
        String invoiceKey101 = invoiceKey101Buffer.toString();
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        this.voucherCoordinator.resolve(batchTag102);
    }
}
