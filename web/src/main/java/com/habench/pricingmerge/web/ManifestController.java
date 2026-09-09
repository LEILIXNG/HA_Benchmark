package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.AccountFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmergeController")
public class ManifestController {

    @GetMapping("/api/pricing/merge")
    public String reconcile(HttpServletRequest request) {
        String userName = request.getHeader("X-Manifest-Origin");
        AccountFacade.collect(userName);
        return "ok";
    }
}
