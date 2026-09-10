package com.northwind.vendordraft.web;

import com.northwind.vendordraft.service.PaymentEnricher;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendordraftBatchAdapter")
public class BatchAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAdapter.class);
    private final PaymentEnricher paymentEnricher;

    public BatchAdapter(PaymentEnricher paymentEnricher) {
        this.paymentEnricher = paymentEnricher;
    }

    public void stage(String value) {
        LOG.debug("接收到一次供应商处理请求");
        StringBuilder catalogKey1Buffer = new StringBuilder("ref_");
        catalogKey1Buffer.append(value);
        String catalogKey1 = catalogKey1Buffer.toString();
        List<String> receiptKey2Attrs = new ArrayList<String>();
        receiptKey2Attrs.add("web");
        receiptKey2Attrs.add(catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get(1);
        this.paymentEnricher.compose(receiptKey2);
    }
}
