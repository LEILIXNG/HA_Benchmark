package com.northwind.shippingassign.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingassignController")
public class ContractController {
    private final SessionAssembler sessionAssembler;

    public ContractController(SessionAssembler sessionAssembler) {
        this.sessionAssembler = sessionAssembler;
    }

    @GetMapping("/api/shipping/assign")
    public String assemble(
            @RequestParam("keyword") String keyword) {
        this.sessionAssembler.compose(keyword);
        return "accepted";
    }
}
