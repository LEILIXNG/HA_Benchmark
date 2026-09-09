package com.habench.vendordraft.web;

import com.habench.vendordraft.web.ManifestRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordraftController")
public class ManifestController {

    @GetMapping("/api/vendor/draft")
    public String resolve(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Manifest-Channel");
        ManifestRegistry.prepare(orderNo);
        return "ok";
    }
}
