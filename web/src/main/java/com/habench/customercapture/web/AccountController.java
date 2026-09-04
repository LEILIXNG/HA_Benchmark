package com.habench.customercapture.web;

import com.habench.customercapture.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customercaptureController")
public class AccountController {

    @GetMapping("/api/customer/capture/{tag}")
    public String stage(
            @PathVariable("tag") String tag) {
        ReceiptCollector.merge(tag);
        return "ok";
    }
}
