package com.northwind.shippingbatch.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("shippingbatchController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final RefundEnricher refundEnricher;

    public CatalogController(RefundEnricher refundEnricher) {
        this.refundEnricher = refundEnricher;
    }

    @GetMapping("/api/shipping/batch")
    public ResponseEntity<String> prepare(HttpServletRequest request) {
        String filename = request.getHeader("X-Catalog-Reference");
        LOG.debug("开始整理发运字段");
        this.refundEnricher.route(filename);
        return ResponseEntity.ok("done");
    }
}
