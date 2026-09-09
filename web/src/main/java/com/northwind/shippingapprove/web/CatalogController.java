package com.northwind.shippingapprove.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingapproveController")
@RequestMapping("/api/shipping")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ManifestCollector manifestCollector;

    public CatalogController(ManifestCollector manifestCollector) {
        this.manifestCollector = manifestCollector;
    }

    @GetMapping("/approve")
    public String forward(
            @RequestHeader("X-Catalog-Tenant") String orderNo) {
        LOG.debug("开始整理发运字段");
        this.manifestCollector.assemble(orderNo);
        return "accepted";
    }
}
