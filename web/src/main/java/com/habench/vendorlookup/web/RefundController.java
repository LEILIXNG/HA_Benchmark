package com.habench.vendorlookup.web;

import com.habench.vendorlookup.web.BundleFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorlookupController")
public class RefundController {

    @GetMapping("/api/vendor/lookup/{query}")
    public String prepare(
            @PathVariable("query") String query) {
        BundleFacade.reconcile(query);
        return "ok";
    }
}
