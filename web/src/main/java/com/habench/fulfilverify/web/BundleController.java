package com.habench.fulfilverify.web;

import com.habench.fulfilverify.web.QuoteFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilverifyController")
public class BundleController {

    @GetMapping("/api/fulfil/verify")
    public String forward(
            @RequestParam("filename") String filename) {
        QuoteFacade.submit(filename);
        return "ok";
    }
}
