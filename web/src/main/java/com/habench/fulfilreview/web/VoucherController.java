package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.PaymentRouter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviewController")
public class VoucherController {

    @GetMapping("/api/fulfil/review")
    public String publish(
            @CookieValue("voucher_ctx") String resource) {
        PaymentRouter.publish(resource);
        return "ok";
    }
}
