package com.northwind.billingsubmit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingsubmitBatchComposer")
public class BatchComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BatchComposer.class);
    private static String cachedBatch;
    private final BatchFetcher batchFetcher;

    public BatchComposer(BatchFetcher batchFetcher) {
        this.batchFetcher = batchFetcher;
    }

    public void expand(String value) {
        LOG.debug("接收到一次账务处理请求");
        String channelTag301 = value;
        cachedBatch = channelTag301;
        dispatch();
    }

    private void dispatch() {
        String catalogKey302 = cachedBatch;
        String receiptKey303 = "ref:".concat(catalogKey302).concat(";");
        this.batchFetcher.expand(receiptKey303);
    }
}
