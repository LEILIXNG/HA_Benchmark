package com.northwind.pricingverify.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("pricingverifyController")
@RequestMapping("/api/pricing")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final OrderService orderService;

    public SessionController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/verify")
    public ResponseEntity<String> merge(
            @RequestParam("target") String target) {
        LOG.debug("开始整理定价字段");
        this.orderService.submit(target);
        return ResponseEntity.ok("accepted");
    }
}
