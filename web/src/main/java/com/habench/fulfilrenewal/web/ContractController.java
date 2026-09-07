package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.web.TariffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrenewalController")
public class ContractController {

    @GetMapping("/api/fulfil/renewal")
    public String reconcile(
            @RequestParam("target") String target) {
        TariffService.compose(target);
        return "ok";
    }
}
