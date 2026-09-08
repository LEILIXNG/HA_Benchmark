package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinggrantController")
public class VoucherController {

    @GetMapping("/api/shipping/grant")
    public String attach(
            @RequestParam("keyword") String keyword) {
        BatchAdapter.route(keyword);
        return "ok";
    }
}
