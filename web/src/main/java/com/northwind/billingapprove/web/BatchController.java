package com.northwind.billingapprove.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingapproveController")
@RequestMapping("/api/billing")
public class BatchController {
    private final CatalogFacade catalogFacade;

    public BatchController(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @GetMapping("/approve")
    public ResponseEntity<String> submit(
            @RequestHeader("X-Batch-Trace") String filename) {
        this.catalogFacade.expand(filename);
        return ResponseEntity.ok("accepted");
    }
}
