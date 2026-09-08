package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.TariffFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilapproveController")
public class BundleController {

    @GetMapping("/api/fulfil/approve/{tag}")
    public String assemble(
            @PathVariable("tag") String tag) {
        TariffFacade.merge(tag);
        return "ok";
    }
}
