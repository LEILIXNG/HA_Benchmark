package com.habench.vendorgrant.web;

import com.habench.vendorgrant.web.BundleResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorgrantController")
public class OrderController {

    @GetMapping("/api/vendor/grant")
    public String reconcile(
            @RequestParam("keyword") String keyword) {
        BundleResolver.assemble(keyword);
        return "ok";
    }
}
