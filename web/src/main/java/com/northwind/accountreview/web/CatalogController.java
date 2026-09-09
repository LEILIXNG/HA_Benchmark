package com.northwind.accountreview.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountreviewController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final BundleService bundleService;

    public CatalogController(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @GetMapping("/api/account/review")
    public String dispatch(
            @RequestHeader("X-Catalog-Client") String token) {
        LOG.trace("进入账户处理环节");
        this.bundleService.translate(token);
        return "done";
    }
}
