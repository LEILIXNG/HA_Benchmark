package com.habench.accountmanifest.web;

import com.habench.accountmanifest.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountmanifestController")
public class VoucherController {

    @GetMapping("/api/account/manifest")
    public String attach(
            @RequestParam("keyword") String keyword) {
        BatchAdapter.route(keyword);
        return "ok";
    }
}
