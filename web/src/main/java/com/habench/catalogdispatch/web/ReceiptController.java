package com.habench.catalogdispatch.web;

import com.habench.catalogdispatch.web.VoucherAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogdispatchController")
public class ReceiptController {

    @GetMapping("/api/catalog/dispatch/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        VoucherAdapter.publish(userName);
        return "ok";
    }
}
