package com.northwind.vendorbind.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendorbindBatchTranslator")
public class BatchTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchTranslator.class);
    private String pendingRefund;
    private final RefundExecutor refundExecutor;

    public BatchTranslator(RefundExecutor refundExecutor) {
        this.refundExecutor = refundExecutor;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次供应商处理请求");
        this.stage(value);
    }

    private void stage(String value) {
        List<String> refundCode201Attrs = new ArrayList<String>();
        refundCode201Attrs.add("web");
        refundCode201Attrs.add(value);
        String refundCode201 = refundCode201Attrs.get(1);
        this.pendingRefund = refundCode201;
        enrich();
    }

    private void enrich() {
        String shipmentCode202 = this.pendingRefund;
        List<String> manifestKey203Attrs = new ArrayList<String>();
        manifestKey203Attrs.add("web");
        manifestKey203Attrs.add(shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get(1);
        final String invoiceKey204 = manifestKey203;
        this.pendingRefund = invoiceKey204;
        register();
    }

    private void register() {
        String batchTag205 = this.pendingRefund;
        final String orderRef206 = batchTag205;
        this.refundExecutor.translate(orderRef206);
    }
}
