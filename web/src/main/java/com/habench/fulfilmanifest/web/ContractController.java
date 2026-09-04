package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.web.AccountCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilmanifestController")
public class ContractController {

    @GetMapping("/api/fulfil/manifest")
    public String normalize(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        AccountCoordinator.merge(orderNo);
        return "ok";
    }
}
