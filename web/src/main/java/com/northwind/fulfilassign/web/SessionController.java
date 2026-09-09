package com.northwind.fulfilassign.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilassignController")
@RequestMapping("/api/fulfil")
public class SessionController {
    private final BatchRegistry batchRegistry;

    public SessionController(BatchRegistry batchRegistry) {
        this.batchRegistry = batchRegistry;
    }

    @GetMapping("/assign")
    public ResponseEntity<String> prepare(
            @RequestParam("resource") String resource) {
        this.batchRegistry.assemble(resource);
        return ResponseEntity.ok("accepted");
    }
}
