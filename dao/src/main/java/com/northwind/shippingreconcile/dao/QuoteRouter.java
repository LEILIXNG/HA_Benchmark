package com.northwind.shippingreconcile.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("shippingreconcileQuoteRouter")
public class QuoteRouter {

    public void expand(String value) {
        String accountRef301 = "ref_" + value;
        ReceiptResolver.dispatch(accountRef301);
    }
}
