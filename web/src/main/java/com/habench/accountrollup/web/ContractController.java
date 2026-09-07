package com.habench.accountrollup.web;

import com.habench.accountrollup.web.AccountBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrollupController")
public class ContractController {

    @GetMapping("/api/account/rollup")
    public String stage(
            @RequestParam("tag") String tag) {
        AccountBuilder.refine(tag);
        return "ok";
    }
}
