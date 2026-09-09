package com.northwind.billingcapture.web;

import com.northwind.billingcapture.service.QuoteCollector;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingcaptureManifestRouter")
public class ManifestRouter {
    private String pendingSession;

    public void attach(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry1 = new StringBuilder(value).toString();
        final String channelTag2 = ledgerEntry1;
        this.pendingSession = channelTag2;
        forward();
    }

    private void forward() {
        String catalogKey3 = this.pendingSession;
        String receiptKey4 = String.format("ref:%s;", catalogKey3);
        String accountRef5 = "ref:".concat(receiptKey4).concat(";");
        QuoteCollector.publish(accountRef5);
    }
}
