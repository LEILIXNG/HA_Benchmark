package com.northwind.inventoryverify.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventoryverifyController")
public class ManifestController {
    private final OrderBuilder orderBuilder;

    public ManifestController(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    @GetMapping("/api/inventory/verify")
    public String stage(HttpServletRequest request) {
        String reference = request.getHeader("X-Manifest-Context");
        this.orderBuilder.refine(reference);
        return "done";
    }
}
