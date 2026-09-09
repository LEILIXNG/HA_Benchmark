package com.northwind.fulfilsettlequeue.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilsettlequeueController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ManifestService manifestService;

    public CatalogController(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    @GetMapping("/api/fulfil/settlequeue")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Catalog-Reference");
        LOG.trace("进入履约处理环节");
        this.manifestService.assemble(keyword);
        return "ok";
    }
}
