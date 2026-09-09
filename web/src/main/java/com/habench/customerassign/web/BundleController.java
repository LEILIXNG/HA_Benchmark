package com.habench.customerassign.web;

import com.habench.customerassign.web.PaymentRouter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerassignController")
public class BundleController {

    @GetMapping("/api/customer/assign")
    public String submit(
            @CookieValue("bundle_session") String resource) {
        PaymentRouter.publish(resource);
        return "ok";
    }
}
