package com.habench.accountrollup.web;

import com.habench.accountrollup.web.BatchNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrollupController")
public class BatchController {

    @GetMapping("/api/account/rollup/{userName}")
    public String reconcile(
            @PathVariable("userName") String userName) {
        BatchNormalizer.assemble(userName);
        return "ok";
    }
}
