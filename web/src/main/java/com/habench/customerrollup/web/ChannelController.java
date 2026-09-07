package com.habench.customerrollup.web;

import com.habench.customerrollup.web.ManifestAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrollupController")
public class ChannelController {

    @GetMapping("/api/customer/rollup")
    public String register(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ManifestAdapter.reconcile(category);
        return "ok";
    }
}
