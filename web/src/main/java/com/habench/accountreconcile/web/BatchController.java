package com.habench.accountreconcile.web;

import com.habench.accountreconcile.web.ManifestService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreconcileController")
public class BatchController {

    @GetMapping("/api/account/reconcile")
    public String stage(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ManifestService.expand(target);
        return "ok";
    }
}
