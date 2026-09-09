package com.northwind.pricingdispatch.web;

import com.northwind.pricingdispatch.service.VoucherComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherResolver {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherResolver.class);
    private static String cachedAccount;

    public static void attach(String value) {
        LOG.debug("接收到一次定价处理请求");
        StringBuilder tariffRef201Buffer = new StringBuilder("ref:");
        tariffRef201Buffer.append(value).append(";");
        String tariffRef201 = tariffRef201Buffer.toString();
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        cachedAccount = ledgerEntry202;
        dispatch();
    }

    private static void dispatch() {
        String channelTag203 = cachedAccount;
        final String catalogKey204 = channelTag203;
        String receiptKey205 = new StringBuilder(catalogKey204).toString();
        VoucherComposer.forward(receiptKey205);
    }
}
