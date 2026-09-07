package com.habench.customerdispatch.web;

import com.habench.customerdispatch.web.BundleBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdispatchController")
public class BundleController {

    @GetMapping("/api/customer/dispatch/{token}")
    public String compose(
            @PathVariable("token") String token) {
        BundleBuilder.translate(token);
        return "ok";
    }
}
