package com.habench.catalogtrace.web;

import com.habench.catalogtrace.web.LedgerComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogtraceController")
public class BatchController {

    @GetMapping("/api/catalog/trace")
    public String assemble(
            @RequestParam("tag") String tag) {
        LedgerComposer.forward(tag);
        return "ok";
    }
}
