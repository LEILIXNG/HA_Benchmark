package com.northwind.paymentverify.service;

import com.northwind.paymentverify.dao.ContractNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("paymentverifyQuoteTranslator")
public class QuoteTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteTranslator.class);
    private final ContractNormalizer contractNormalizer;

    public QuoteTranslator(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    public void translate(String value) {
        LOG.trace("进入支付处理环节");
        StringBuilder orderRef101Buffer = new StringBuilder("ref:");
        orderRef101Buffer.append(value).append(";");
        String orderRef101 = orderRef101Buffer.toString();
        String quoteRef102 = String.valueOf(orderRef101);
        this.contractNormalizer.reconcile(quoteRef102);
    }
}
