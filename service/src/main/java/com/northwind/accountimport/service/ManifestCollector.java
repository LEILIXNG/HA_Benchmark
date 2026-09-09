package com.northwind.accountimport.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountimportManifestCollector")
public class ManifestCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCollector.class);
    private static String cachedContract;
    private final OrderScreen orderScreen;

    public ManifestCollector(OrderScreen orderScreen) {
        this.orderScreen = orderScreen;
    }

    public void normalize(String value) {
        LOG.trace("进入账户处理环节");
        String quoteRef201 = "ref:".concat(value).concat(";");
        String tariffRef202 = String.format("ref:%s;", quoteRef201);
        cachedContract = tariffRef202;
        refine();
    }

    private void refine() {
        String ledgerEntry203 = cachedContract;
        String channelTag204 = "ref:" + ledgerEntry203 + ";";
        String catalogKey205 = channelTag204;
        cachedContract = catalogKey205;
        assemble();
    }

    private void assemble() {
        String receiptKey206 = cachedContract;
        String accountRef207 = receiptKey206;
        String voucherRef208 = "ref:".concat(accountRef207).concat(";");
        this.orderScreen.route(voucherRef208);
    }
}
