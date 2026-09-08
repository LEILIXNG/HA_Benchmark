package com.habench.vendorsettlequeue.web;

import com.habench.vendorsettlequeue.web.BatchEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsettlequeueController")
public class OrderController {

    @GetMapping("/api/vendor/settlequeue")
    public String dispatch(
            @RequestParam("tag") String tag) {
        BatchEnricher.forward(tag);
        return "ok";
    }
}
