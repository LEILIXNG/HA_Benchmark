package com.habench.fulfildraft.web;

import com.habench.fulfildraft.web.BundleNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildraftController")
public class PaymentController {

    @GetMapping("/api/fulfil/draft")
    public String reconcile(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        BundleNormalizer.reconcile(category);
        return "ok";
    }
}
