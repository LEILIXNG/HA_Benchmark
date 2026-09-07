package com.habench.customerreview.web;

import com.habench.customerreview.web.BatchAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreviewController")
public class ContractController {

    @GetMapping("/api/customer/review")
    public String compose(
            @RequestParam("reference") String reference) {
        BatchAssembler.normalize(reference);
        return "ok";
    }
}
