package com.northwind.fulfilverify.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("fulfilverifyController")
public class BundleController {
    private final QuoteFacade quoteFacade;

    public BundleController(QuoteFacade quoteFacade) {
        this.quoteFacade = quoteFacade;
    }

    @GetMapping("/api/fulfil/verify")
    public ResponseEntity<String> forward(
            @RequestParam("filename") String filename) {
        this.quoteFacade.submit(filename);
        return ResponseEntity.ok("ok");
    }
}
