package com.habench.reportsplit.web;

import com.habench.reportsplit.web.SessionEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsplitController")
public class ContractController {

    @GetMapping("/api/report/split/{tag}")
    public String merge(
            @PathVariable("tag") String tag) {
        SessionEnricher.compose(tag);
        return "ok";
    }
}
