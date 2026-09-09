package com.northwind.customercapture.service;

import com.northwind.customercapture.dao.BatchNormalizer;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("customercaptureContractEnricher")
public class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);
    private String pendingRefund;
    private final BatchNormalizer batchNormalizer;

    public ContractEnricher(BatchNormalizer batchNormalizer) {
        this.batchNormalizer = batchNormalizer;
    }

    public void forward(String value) {
        LOG.debug("接收到一次客户处理请求");
        this.submit(value);
    }

    private void submit(String value) {
        final String ledgerEntry201 = value;
        this.pendingRefund = ledgerEntry201;
        collect();
    }

    private void collect() {
        String channelTag202 = this.pendingRefund;
        final String catalogKey203 = channelTag202;
        List<String> receiptKey204Attrs = new ArrayList<String>();
        receiptKey204Attrs.add("web");
        receiptKey204Attrs.add(catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get(1);
        this.batchNormalizer.submit(receiptKey204);
    }
}
