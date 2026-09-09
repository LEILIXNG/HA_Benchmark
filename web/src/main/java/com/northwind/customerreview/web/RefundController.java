package com.northwind.customerreview.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customerreviewController")
@RequestMapping("/api/customer")
public class RefundController {
    private final OrderCoordinator orderCoordinator;

    public RefundController(OrderCoordinator orderCoordinator) {
        this.orderCoordinator = orderCoordinator;
    }

    @GetMapping("/review")
    public ResponseEntity<String> collect(
            @RequestParam("reference") String reference) {
        this.orderCoordinator.merge(reference);
        return ResponseEntity.ok("done");
    }
}
