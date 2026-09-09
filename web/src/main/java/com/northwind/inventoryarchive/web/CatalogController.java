package com.northwind.inventoryarchive.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventoryarchiveController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ContractTranslator contractTranslator;

    public CatalogController(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    @GetMapping("/api/inventory/archive")
    public ResponseEntity<String> prepare(
            @RequestHeader("X-Catalog-Trace") String tag) {
        LOG.debug("库存流程转下一环节");
        this.contractTranslator.attach(tag);
        return ResponseEntity.ok("done");
    }
}
