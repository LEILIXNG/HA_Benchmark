package com.habench.catalogbatch.web;

import com.habench.catalogbatch.web.VoucherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogbatchController")
public class AccountController {

    @GetMapping("/api/catalog/batch/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        VoucherFacade.publish(target);
        return "ok";
    }
}
