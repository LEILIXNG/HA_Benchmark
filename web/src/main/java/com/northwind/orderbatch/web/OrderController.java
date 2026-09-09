package com.northwind.orderbatch.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("orderbatchController")
public class OrderController {

    @GetMapping("/api/order/batch")
    public String stage(HttpServletRequest request) {
        String category = request.getHeader("X-Order-Tenant");
        InvoiceCollector.translate(category);
        return "accepted";
    }
}
