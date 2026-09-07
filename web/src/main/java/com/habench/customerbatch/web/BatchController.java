package com.habench.customerbatch.web;

import com.habench.customerbatch.web.ManifestCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbatchController")
public class BatchController {

    @GetMapping("/api/customer/batch")
    public String collect(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ManifestCoordinator.submit(orderNo);
        return "ok";
    }
}
