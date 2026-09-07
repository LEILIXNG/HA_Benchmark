package com.habench.vendorsubmit.web;

import com.habench.vendorsubmit.web.ContractRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsubmitController")
public class CatalogController {

    @GetMapping("/api/vendor/submit")
    public String forward(
            @RequestParam("userName") String userName) {
        ContractRegistry.refine(userName);
        return "ok";
    }
}
