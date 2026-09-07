package com.habench.accountassign.web;

import com.habench.accountassign.web.QuoteAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountassignController")
public class ManifestController {

    @GetMapping("/api/account/assign")
    public String route(
            @RequestParam("target") String target) {
        QuoteAdapter.compose(target);
        return "ok";
    }
}
