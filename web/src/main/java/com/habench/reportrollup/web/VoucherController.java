package com.habench.reportrollup.web;

import com.habench.reportrollup.web.ManifestCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrollupController")
public class VoucherController {

    @GetMapping("/api/report/rollup")
    public String enrich(
            @RequestParam("userName") String userName) {
        ManifestCoordinator.assemble(userName);
        return "ok";
    }
}
