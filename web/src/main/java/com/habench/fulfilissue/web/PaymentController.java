package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilissueController")
public class PaymentController {

    @GetMapping("/api/fulfil/issue/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        BatchAdapter.compose(tag);
        return "ok";
    }
}
