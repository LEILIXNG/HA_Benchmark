package com.habench.ordertrace.web;

import com.habench.ordertrace.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertraceController")
public class VoucherController {

    @GetMapping("/api/order/trace")
    public String attach(
            @RequestParam("keyword") String keyword) {
        BatchAdapter.route(keyword);
        return "ok";
    }
}
