package com.northwind.billingsettlequeue.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingsettlequeueRefundRegistry")
public class RefundRegistry {
    private static String cachedTariff;
    private final PaymentTranslator paymentTranslator;

    public RefundRegistry(PaymentTranslator paymentTranslator) {
        this.paymentTranslator = paymentTranslator;
    }

    public void translate(String value) {
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        cachedTariff = quoteRef1;
        resolve();
    }

    private void resolve() {
        String tariffRef2 = cachedTariff;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = new StringBuilder(ledgerEntry3).toString();
        this.paymentTranslator.merge(channelTag4);
    }
}
