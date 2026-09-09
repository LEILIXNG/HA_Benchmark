package com.northwind.ordersettlequeue.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("ordersettlequeueController")
public class RefundController {
    private final ReceiptComposer receiptComposer;

    public RefundController(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    @GetMapping("/api/order/settlequeue")
    public String compose(HttpServletRequest request) {
        String category = request.getHeader("X-Refund-Origin");
        this.receiptComposer.publish(category);
        return "ok";
    }
}
