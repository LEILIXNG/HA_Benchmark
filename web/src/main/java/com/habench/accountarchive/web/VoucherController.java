package com.habench.accountarchive.web;

import com.habench.accountarchive.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountarchiveController")
public class VoucherController {

    @GetMapping("/api/account/archive")
    public String attach(
            @RequestParam("keyword") String keyword) {
        BatchAdapter.route(keyword);
        return "ok";
    }
}
