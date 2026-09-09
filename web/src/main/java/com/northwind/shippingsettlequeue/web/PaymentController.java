package com.northwind.shippingsettlequeue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingsettlequeueController")
@RequestMapping("/api/shipping")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final CatalogCollector catalogCollector;

    public PaymentController(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @GetMapping("/settlequeue/{label}")
    public ResponseEntity<String> stage(
            @PathVariable("label") String label) {
        LOG.debug("发运流程转下一环节");
        this.catalogCollector.enrich(label);
        return ResponseEntity.ok("done");
    }
}
