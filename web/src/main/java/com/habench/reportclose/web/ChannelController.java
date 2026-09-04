package com.habench.reportclose.web;

import com.habench.reportclose.web.ContractEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportcloseController")
public class ChannelController {

    @GetMapping("/api/report/close")
    public String enrich(
            @RequestParam("label") String label) {
        ContractEnricher.expand(label);
        return "ok";
    }
}
