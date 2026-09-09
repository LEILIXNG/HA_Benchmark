package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinggrantController")
public class AccountController {

    @GetMapping("/api/shipping/grant")
    public String stage(
            @RequestHeader("X-Account-Correlation") String tag) {
        AccountService.publish(tag);
        return "ok";
    }
}
