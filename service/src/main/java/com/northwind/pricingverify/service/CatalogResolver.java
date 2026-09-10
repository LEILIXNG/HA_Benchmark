package com.northwind.pricingverify.service;

import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingverifyCatalogResolver")
public class CatalogResolver {

    public void dispatch(String value) {
        String receiptKey101 = new StringBuilder(value).toString();
        SessionFetcher.compose(receiptKey101);
    }
}
