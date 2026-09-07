package com.habench.accountrenewal.web;

import com.habench.accountrenewal.web.OrderFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrenewalController")
public class ContractController {

    @GetMapping("/api/account/renewal")
    public String forward(
            @RequestParam("keyword") String keyword) {
        OrderFacade.collect(keyword);
        return "ok";
    }
}
