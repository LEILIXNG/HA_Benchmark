package com.habench.ordercapture.web;

import com.habench.ordercapture.web.RefundRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordercaptureController")
public class SessionController {

    @GetMapping("/api/order/capture")
    public String expand(
            @RequestHeader("X-Session-Origin") String category) {
        RefundRouter.enrich(category);
        return "ok";
    }
}
