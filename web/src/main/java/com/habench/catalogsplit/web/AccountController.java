package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.SessionRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsplitController")
public class AccountController {

    @GetMapping("/api/catalog/split")
    public String register(
            @RequestParam("filename") String filename) {
        SessionRouter.enrich(filename);
        return "ok";
    }
}
