package com.northwind.ordersplit.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("ordersplitController")
@RequestMapping("/api/order")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);

    @GetMapping("/split")
    public String prepare(HttpServletRequest request) {
        String target = request.getHeader("X-Receipt-Origin");
        LOG.debug("接收到一次订单处理请求");
        BundleBuilder.enrich(target);
        return "done";
    }
}
