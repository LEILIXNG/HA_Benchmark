package com.habench.shippingtrace.web;

import com.habench.shippingtrace.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingtraceController")
public class BatchController {

    @GetMapping("/api/shipping/trace")
    public String prepare(
            @RequestParam("resource") String resource) {
        VoucherRouter.enrich(resource);
        return "ok";
    }
}
