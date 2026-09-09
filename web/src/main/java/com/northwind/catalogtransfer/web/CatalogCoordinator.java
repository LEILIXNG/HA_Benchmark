package com.northwind.catalogtransfer.web;

import com.northwind.catalogtransfer.service.VoucherCollector;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("catalogtransferCatalogCoordinator")
public class CatalogCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCoordinator.class);

    public void prepare(String value) {
        LOG.debug("商品流程转下一环节");
        String accountRef101 = value;
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("remark", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("remark");
        VoucherCollector.expand(voucherRef102);
    }
}
