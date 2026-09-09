package com.northwind.catalogrefund.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogrefundLedgerService")
public class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private final CatalogFetcher catalogFetcher;

    public LedgerService(CatalogFetcher catalogFetcher) {
        this.catalogFetcher = catalogFetcher;
    }

    public void translate(String value) {
        LOG.debug("商品流程转下一环节");
        String voucherRef301 = String.valueOf(value);
        List<String> paymentTag302Attrs = new ArrayList<String>();
        paymentTag302Attrs.add("web");
        paymentTag302Attrs.add(voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get(1);
        this.catalogFetcher.compose(paymentTag302);
    }
}
