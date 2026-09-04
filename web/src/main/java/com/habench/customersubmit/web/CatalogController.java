package com.habench.customersubmit.web;

import com.habench.customersubmit.web.TariffComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersubmitController")
public class CatalogController {

    @GetMapping("/api/customer/submit")
    public String assemble(
            @RequestParam("keyword") String keyword) {
        TariffComposer.prepare(keyword);
        return "ok";
    }
}
