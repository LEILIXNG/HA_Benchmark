package com.northwind.catalogarchive.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogarchiveBundleFacade")
public class BundleFacade {
    private final VoucherService voucherService;

    public BundleFacade(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public void collect(String value) {
        List<String> invoiceKey1Attrs = new ArrayList<String>();
        invoiceKey1Attrs.add("web");
        invoiceKey1Attrs.add(value);
        String invoiceKey1 = invoiceKey1Attrs.get(1);
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("remark", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("remark");
        this.voucherService.attach(batchTag2);
    }
}
