package com.habench.vendorsync.web;

import com.habench.vendorsync.web.AccountEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsyncController")
public class BatchController {

    @GetMapping("/api/vendor/sync/{resource}")
    public String dispatch(
            @PathVariable("resource") String resource) {
        AccountEnricher.submit(resource);
        return "ok";
    }
}
