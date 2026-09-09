package com.habench.inventorylookup.web;

import com.habench.inventorylookup.web.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorylookupController")
public class BatchController {

    @GetMapping("/api/inventory/lookup")
    public String translate(HttpServletRequest request) {
        String query = request.getHeader("X-Batch-Tenant");
        AccountService.stage(query);
        return "ok";
    }
}
