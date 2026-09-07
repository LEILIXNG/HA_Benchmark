package com.habench.accountrollup.web;

import com.habench.accountrollup.web.ManifestBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrollupController")
public class ContractController {

    @GetMapping("/api/account/rollup")
    public String prepare(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ManifestBroker.refine(reference);
        return "ok";
    }
}
