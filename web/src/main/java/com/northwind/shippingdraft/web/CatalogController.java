package com.northwind.shippingdraft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("shippingdraftController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final RefundAdapter refundAdapter;

    public CatalogController(RefundAdapter refundAdapter) {
        this.refundAdapter = refundAdapter;
    }

    @GetMapping("/api/shipping/draft")
    public String reconcile(
            @CookieValue("catalog_tag") String resource) {
        LOG.debug("接收到一次发运处理请求");
        this.refundAdapter.collect(resource);
        return "accepted";
    }
}
