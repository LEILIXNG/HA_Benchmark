package com.northwind.shippingclose.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippingcloseController")
@RequestMapping("/api/shipping")
public class OrderController {
    private final VoucherRouter voucherRouter;

    public OrderController(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    @GetMapping("/close/{tag}")
    public String stage(
            @PathVariable("tag") String tag) {
        this.voucherRouter.forward(tag);
        return "done";
    }
}
