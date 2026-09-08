package com.habench.accountdigest.web;

import com.habench.accountdigest.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountdigestController")
public class TariffController {

    @GetMapping("/api/account/digest/{tag}")
    public String reconcile(
            @PathVariable("tag") String tag) {
        BatchAdapter.merge(tag);
        return "ok";
    }
}
