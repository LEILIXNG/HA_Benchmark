package com.habench.vendorexport.web;

import com.habench.vendorexport.web.QuoteFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorexportController")
public class BundleController {

    @GetMapping("/api/vendor/export")
    public String forward(
            @RequestParam("filename") String filename) {
        QuoteFacade.submit(filename);
        return "ok";
    }
}
