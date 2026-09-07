package com.habench.inventorysync.web;

import com.habench.inventorysync.web.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysyncController")
public class SessionController {

    @GetMapping("/api/inventory/sync")
    public String reconcile(
            @RequestParam("resource") String resource) {
        SessionService.prepare(resource);
        return "ok";
    }
}
