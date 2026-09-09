package com.northwind.vendorgrant.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorgrantController")
public class OrderController {
    private final BundleResolver bundleResolver;

    public OrderController(BundleResolver bundleResolver) {
        this.bundleResolver = bundleResolver;
    }

    @GetMapping("/api/vendor/grant")
    public ResponseEntity<String> expand(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Order-Context");
        this.bundleResolver.assemble(orderNo);
        return ResponseEntity.ok("ok");
    }
}
