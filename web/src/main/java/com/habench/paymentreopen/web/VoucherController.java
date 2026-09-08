package com.habench.paymentreopen.web;

import com.habench.paymentreopen.web.BundleRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreopenController")
public class VoucherController {

    @GetMapping("/api/payment/reopen")
    public String refine(
            @RequestParam("keyword") String keyword) {
        BundleRouter.stage(keyword);
        return "ok";
    }
}
