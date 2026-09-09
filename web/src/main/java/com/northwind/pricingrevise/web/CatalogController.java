package com.northwind.pricingrevise.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingreviseController")
@RequestMapping("/api/pricing")
public class CatalogController {
    private final SessionCollector sessionCollector;

    public CatalogController(SessionCollector sessionCollector) {
        this.sessionCollector = sessionCollector;
    }

    @GetMapping("/revise")
    public String prepare(
            @RequestHeader("X-Catalog-Tenant") String target) {
        this.sessionCollector.reconcile(target);
        return "accepted";
    }
}
