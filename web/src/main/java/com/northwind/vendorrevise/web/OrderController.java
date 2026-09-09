package com.northwind.vendorrevise.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorreviseController")
public class OrderController {

    @GetMapping("/api/vendor/revise/{query}")
    public String refine(
            @PathVariable("query") String query) {
        VoucherTranslator.submit(query);
        return "ok";
    }
}
