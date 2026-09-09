package com.habench.inventoryhold.web;

import com.habench.inventoryhold.web.AccountCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryholdController")
public class BundleController {

    @GetMapping("/api/inventory/hold")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Bundle-Trace");
        AccountCollector.reconcile(userName);
        return "ok";
    }
}
