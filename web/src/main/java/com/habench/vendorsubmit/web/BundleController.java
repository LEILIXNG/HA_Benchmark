package com.habench.vendorsubmit.web;

import com.habench.vendorsubmit.web.ContractRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsubmitController")
public class BundleController {

    @GetMapping("/api/vendor/submit/{tag}")
    public String publish(
            @PathVariable("tag") String tag) {
        ContractRouter.enrich(tag);
        return "ok";
    }
}
