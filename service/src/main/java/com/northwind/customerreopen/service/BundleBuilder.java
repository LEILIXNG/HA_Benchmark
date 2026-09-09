package com.northwind.customerreopen.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("customerreopenBundleBuilder")
public class BundleBuilder {
    private final TariffEnricher tariffEnricher;

    public BundleBuilder(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    public void forward(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.get("detail");
        this.tariffEnricher.normalize(catalogKey201);
    }
}
