package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.web.TariffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrenewalController")
public class ContractController {

    @GetMapping("/api/fulfil/renewal/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        TariffService.publish(userName);
        return "ok";
    }
}
