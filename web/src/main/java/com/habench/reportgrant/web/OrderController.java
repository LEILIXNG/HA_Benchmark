package com.habench.reportgrant.web;

import com.habench.reportgrant.web.AccountRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportgrantController")
public class OrderController {

    @GetMapping("/api/report/grant")
    public String assemble(
            @RequestParam("resource") String resource) {
        AccountRouter.reconcile(resource);
        return "ok";
    }
}
