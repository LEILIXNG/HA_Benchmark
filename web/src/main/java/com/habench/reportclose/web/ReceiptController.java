package com.habench.reportclose.web;

import com.habench.reportclose.web.VoucherAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportcloseController")
public class ReceiptController {

    @GetMapping("/api/report/close/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        VoucherAdapter.publish(userName);
        return "ok";
    }
}
