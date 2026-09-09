package com.northwind.customerrollup.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customerrollupController")
public class AccountController {
    private final BatchComposer batchComposer;

    public AccountController(BatchComposer batchComposer) {
        this.batchComposer = batchComposer;
    }

    @GetMapping("/api/customer/rollup/{tag}")
    public String expand(
            @PathVariable("tag") String tag) {
        this.batchComposer.prepare(tag);
        return "ok";
    }
}
