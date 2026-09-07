package com.habench.ordernotice.web;

import com.habench.ordernotice.web.ManifestCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordernoticeController")
public class ReceiptController {

    @GetMapping("/api/order/notice")
    public String dispatch(
            @RequestParam("token") String token) {
        ManifestCollector.submit(token);
        return "ok";
    }
}
