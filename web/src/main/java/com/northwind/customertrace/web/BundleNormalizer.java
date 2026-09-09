package com.northwind.customertrace.web;

import com.northwind.customertrace.service.ShipmentComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customertraceBundleNormalizer")
public class BundleNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleNormalizer.class);
    private String pendingReceipt;

    public void refine(String value) {
        LOG.debug("开始整理客户字段");
        this.submit(value);
    }

    private void submit(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingReceipt = channelTag1;
        forward();
    }

    private void forward() {
        String catalogKey2 = this.pendingReceipt;
        String receiptKey3 = new StringBuilder(catalogKey2).toString();
        ShipmentComposer.compose(receiptKey3);
    }
}
