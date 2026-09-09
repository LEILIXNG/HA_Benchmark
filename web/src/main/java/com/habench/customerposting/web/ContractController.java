package com.habench.customerposting.web;

import com.habench.customerposting.web.AccountCoordinator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerpostingController")
public class ContractController {

    @GetMapping("/api/customer/posting")
    public String normalize(
            @CookieValue("contract_ctx") String reference) {
        AccountCoordinator.reconcile(reference);
        return "ok";
    }
}
