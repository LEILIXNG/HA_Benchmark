package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.BundleAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricinggrantController")
public class AccountController {

    @GetMapping("/api/pricing/grant/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        BundleAdapter.compose(target);
        return "ok";
    }
}
