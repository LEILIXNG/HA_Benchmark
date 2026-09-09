package com.habench.accountbind.web;

import com.habench.accountbind.web.VoucherAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountbindController")
public class ReceiptController {

    @GetMapping("/api/account/bind/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        VoucherAdapter.publish(userName);
        return "ok";
    }
}
