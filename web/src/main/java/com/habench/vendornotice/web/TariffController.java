package com.habench.vendornotice.web;

import com.habench.vendornotice.web.LedgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendornoticeController")
public class TariffController {

    @GetMapping("/api/vendor/notice/{category}")
    public String refine(
            @PathVariable("category") String category) {
        LedgerService.prepare(category);
        return "ok";
    }
}
