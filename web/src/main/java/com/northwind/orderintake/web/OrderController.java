package com.northwind.orderintake.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("orderintakeController")
@RequestMapping("/api/order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final LedgerBuilder ledgerBuilder;

    public OrderController(LedgerBuilder ledgerBuilder) {
        this.ledgerBuilder = ledgerBuilder;
    }

    @GetMapping("/intake")
    public String refine(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Order-Correlation");
        LOG.trace("进入订单处理环节");
        this.ledgerBuilder.expand(orderNo);
        return "ok";
    }
}
